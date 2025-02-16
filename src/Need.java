import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Need {

    private int orgID;
    private String orgName;
    private String category;
    private String description;
    private String contactInfo;


    public Need(String category,String description){
        this.category=category;
        this.description=description;
    }

    public Need(int orgID,String orgName,String category,String description,String contactInfo){
        this.orgID=orgID;
        this.orgName=orgName;
        this.category=category;
        this.description=description;
        this.contactInfo=contactInfo;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public static ArrayList<Need> getAllNeeds(){
        ArrayList<Need> needs=new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/myProjectDb1","root","wanyika_1234?");

            String querry="select * from Needs";
            PreparedStatement stmt=con.prepareStatement(querry);


            ResultSet rs=stmt.executeQuery();
            while(rs.next()) {
                Need need=new Need(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                needs.add(need);
            }
            con.close();
        }catch(Exception e){ System.out.println("Error getting needs");}

        return needs;
    }
    @Override
    public String toString(){
        return "Organisation ID: "+this.orgID+
                "\nOrganisation name: "+this.orgName+
                "\nCategory: "+this.category+
                "\nDescription: "+this.description+
                "\nContact Information: "+this.contactInfo;
    }
    public static void main(String[] args){
        ArrayList<Need> all=Need.getAllNeeds();

        for(Need need:all){
            System.out.println(need.toString()+"\n");
        }
    }
}
