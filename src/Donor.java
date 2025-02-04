import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


/**
 * This class defines the people making donations in the program
 * it inherits frm the User class
 * The donor has additional attributes such as a list of all donation history
 * they also have individual inboxes which is a collection of chats they have had with dobnors
 * actions by the donor include viewing all the organisations and their needs
 * they can choose to have them sorted by region or category of needs
 * Once a user chooses the organisation and the item they wish to donate(by clicking on the donate button in the GUI
 * they get a popup message thanking them and sending them to the chat where they can interact with the organisation)
 * this seals the deal and the donation is stored to their donation history(alternatively it is marked as pending and once the organisation
 * confirms reception it is added to the donation history)
 */
public class Donor extends User{

    public Donor(int id,String name,String lname, String password, String type,String country, String email) {
        super(id,name,lname, password, type,country, email);

    }


    //methods

    //donate
    public String donate(Organisation org,Need need){
        //create a donation object
        Donation donation=new Donation(need,this,org);
        //add donation to history.Write to the database
        String url = "jdbc:mysql://localhost:3306/myProjectDb1";
        String user = "root";
        String password = "wanyika_1234?";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String query = "INSERT INTO Donations VALUES (?, ?, ?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, this.getId());
            stmt.setString(2, this.getFname());
            stmt.setInt(3, org.getId());
            stmt.setString(4, org.getFname());
            stmt.setString(5, need.getDescription());
            stmt.setDate(6, Date.valueOf(LocalDate.now().format(df)));


            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Donation added successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //method to allow messaging with selected organisation
        return "Thanks for donating";
    }
    public static void main(String[]args){
        Organisation org=new Organisation(123456,"char1"," ","pass","Organisation","Ghana","char1@email","char org","423514");
        Need need=new Need("Foodstuff","I need tea");
        Donor donor=new Donor(99999,"Cindy","w","pass2","Donor","Kenya","c@email");
        System.out.println(donor.donate(org,need));
        for(Need ned:donor.findNeeds("Foodstuff")){
            System.out.println(ned.getDescription());
        };
    }

    public static ArrayList<Need> findNeeds(String categFilter){
        ArrayList<Need> needs=new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/myProjectDb1","root","wanyika_1234?");

            String querry="select * from Needs where category=? ";
            PreparedStatement stmt=con.prepareStatement(querry);

            stmt.setString(1, categFilter);


            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                Need need=new Need(categFilter,rs.getString(4));
                needs.add(need);
            }
            con.close();
        }catch(Exception e){ System.out.println("User not found");}
        return needs;
    }
}
