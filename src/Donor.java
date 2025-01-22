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
    private static ArrayList<Donation> donationHistory;
    public Donor(String name, String password, String type, String email) {
        super(name, password, type, email);
        donationHistory=new ArrayList<>();
    }

    public static ArrayList<Donation> getDonationHistory() {
        return donationHistory;
    }

    public static void setDonationHistory(ArrayList<Donation> donationHistory) {
        Donor.donationHistory = donationHistory;
    }
    //methods
    //donate
    public void donate(Organisation org,Need need){
        //create a donation object
        //add donation to history/?
        //method to allow messaging with selected organisation
    }
}
