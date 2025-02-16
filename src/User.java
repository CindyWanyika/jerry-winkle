import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class defines the programs user which could either be a donor or organisation
 * Each user has attributes including a fname,an email address, an inbox to enable donor organisation communication
 * The user also has a pword to enable them to login which allows us to save their information such as location and other attributes in a file
 */
public class User {
    //attributes
    protected static int idCount=000000;
    private int id;
    private String fname;
    private String lname;
    private String pword;
    private String accountType;
    private String country;
    private String emailAddress;


    //constructor
    public User(int id,String name,String lname,String pword,String type,String country,String email){
        this.id=id;
        this.pword =pword;
        this.fname =name;
        this.lname=lname;
        this.accountType=type;
        this.country=country;
        this.emailAddress=email;
        
    }
    public User(int id,String name,String country,String email){
        this.id=id;
        this.fname =name;
        this.country=country;
        this.emailAddress=email;

    }
    public static boolean userExists(String email){
        boolean exists=false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/myProjectDb1","root","wanyika_1234?");

            String querry="select * from Users where email=?";
            PreparedStatement stmt=con.prepareStatement(querry);

            stmt.setString(1, email);

            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                exists=true;
            }
            con.close();
        }catch(Exception e){ System.out.println("User not found");}
        return exists;
    }

    public static User login(String name,String email,String password){
        User current=null;
        //querry the database
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/myProjectDb1","root","wanyika_1234?");
//here sonoo is database name, root is username and password
            String querry="select * from Users where Firstname=? and email=? and password=?";
            PreparedStatement stmt=con.prepareStatement(querry);

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);

            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                current=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getString(6),rs.getString(7));
            }
            con.close();
        }catch(Exception e){ System.out.println("User not found");}
        return current;}


    //Methods
    //getters and setters
    public String getFname() {return fname;}

    public void setFname(String fname) {this.fname = fname;}

    public String getPword() {return pword;}

    public void setPword(String pword) {this.pword = pword;}

    public String getAccountType() {return accountType;}

    public void setAccountType(String accountType) {this.accountType = accountType;}

    public String getEmailAddress() {return emailAddress;}

    public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}

    //login

    //create account

    public static void createAccount(String name,String lname,String pword,String type,String country,String emailAddress){
        //write to the database
        int id=idCount;
        idCount++;
        User current=new User(id,name,lname,pword,type,country,emailAddress);
        String url = "jdbc:mysql://localhost:3306/myProjectDb1";
        String user = "root";
        String password = "wanyika_1234?";

        String query = "INSERT INTO Users VALUES (?, ?, ?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, lname);
            stmt.setString(4, pword);
            stmt.setString(5, type);
            stmt.setString(6, country);
            stmt.setString(7, emailAddress);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Account created successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
