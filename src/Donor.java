import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


/**
 * This class defines the people making donations in the program
 * it inherits frm the User class
 * The donor has additional attributes such as a list of all donation history
 * they also have individual inboxes which is a collection of chats they have had with donors
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
    public static Donor getDonor(String email){
        Donor current=null;
        //querry the database
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/myProjectDb1","root","wanyika_1234?");
//here sonoo is database name, root is username and password
            String querry="select * from Users where email=?";
            PreparedStatement stmt=con.prepareStatement(querry);


            stmt.setString(2, email);


            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                current=new Donor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7));
            }
            con.close();
        }catch(Exception e){ System.out.println("Donor not found");}
        return current;}



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
    public ArrayList<Donation> getDonations(){
        ArrayList<Donation> donations=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/myProjectDb1","root","wanyika_1234?");

            String querry="select * from AllDonations where emailAddress=? ";
            PreparedStatement stmt=con.prepareStatement(querry);

            stmt.setString(1, this.getEmailAddress());


            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                Donation donation=new Donation(Need.getNeed(rs.getInt(8)),this,Organisation.getOrg(rs.getString(4)));
                donations.add(donation);
            }
            con.close();
        }catch(Exception e){ System.out.println("User not found");}

        return donations;
    }
}
