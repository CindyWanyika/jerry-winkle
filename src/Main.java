
import java.sql.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
import java.util.ArrayList;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Donation> donations=new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/myProjectDb1","root","wanyika_1234?");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from AllDonations where DonorEmail=cindy@email");
            while(rs.next()) {
                Donation donation=new Donation(Need.getNeed(rs.getInt(8)),Donor.getDonor("cindy@email"),Organisation.getOrg(rs.getString(4)));
                donations.add(donation);
            }
            con.close();
        }catch(Exception e){ System.out.println(e);}

    }
}