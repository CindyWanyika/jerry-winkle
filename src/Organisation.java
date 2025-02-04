import java.sql.*;
import java.util.ArrayList;

public class Organisation extends User {
    private String description;
    private String licenceNo;


    public Organisation(int id,String name,String lname, String password, String type, String country, String email,String description,String licenceNo) {
        super(id,name,lname, password, type, country, email);
        this.description=description;
        this.licenceNo=licenceNo;
    }

    public static void createOrg(int id,String name, String lnameText, String passwordText, String type, String countryText, String emailAddress, String licence, String descriptionText) {
        Organisation current=new Organisation(id,name,lnameText,passwordText,type,countryText,emailAddress,descriptionText,licence);
        String url = "jdbc:mysql://localhost:3306/myProjectDb1";
        String user = "root";
        String password = "wanyika_1234?";

        String query = "INSERT INTO Organisations VALUES (?, ?, ?,?,?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {


            stmt.setString(1, name);
            stmt.setString(4, licence);
            stmt.setString(5, descriptionText);
            stmt.setString(2, countryText);
            stmt.setString(3, emailAddress);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("User inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(String licenceNo) {
        this.licenceNo = licenceNo;
    }
    /**
     * The organisations have funcionalities such as viewing their donations,adding to their needs and adding their needs and removing needs
     */
    public ArrayList<Donation> viewDonations(){
        ArrayList<Donation> allDonations=new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/myProjectDb1","root","wanyika_1234?");

            String querry="select * from Donations where orgname=? and orgID=?";
            PreparedStatement stmt=con.prepareStatement(querry);

            stmt.setString(1, this.getFname());
            stmt.setInt(2, this.getId());

            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                Donation donation=new Donation(rs.getString(2),rs.getString(4),rs.getString(5));
                allDonations.add(donation);
            }
            con.close();
        }catch(Exception e){ System.out.println("User not found");}

        return allDonations;
    }

    public ArrayList<Need> viewNeeds(){
        ArrayList<Need> allNeeds=new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/myProjectDb1","root","wanyika_1234?");

            String querry="select * from Needs where orgName=? and id=?";
            PreparedStatement stmt=con.prepareStatement(querry);

            stmt.setString(1, this.getFname());
            stmt.setInt(2, this.getId());

            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                Need need=new Need(rs.getString(3),rs.getString(5));
                allNeeds.add(need);
            }
            con.close();
        }catch(Exception e){ System.out.println("User not found");}
        return allNeeds;
    }
    public void addNeed(Need need){
        String url = "jdbc:mysql://localhost:3306/myProjectDb1";
        String user = "root";
        String password = "wanyika_1234?";

        String query = "INSERT INTO Needs VALUES (?, ?, ?,?,?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, this.getId());
            stmt.setString(2, this.getFname());
            stmt.setString(3, need.getCategory());
            stmt.setString(4, need.getDescription());
            stmt.setString(5, this.getEmailAddress());


            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Need inserted successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
