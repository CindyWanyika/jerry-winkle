import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class defines the programs user which could either be a donor or organisation
 * Each user has attributes including a name,an email address, an inbox to enable donor organisation communication
 * The user also has a password to enable them to login which allows us to save their information such as location and other attributes in a file
 */
public class User {
    //attributes
    private String name;
    private String password;
    private String accountType;
    private String country;
    private String emailAddress;
    private ArrayList<Message> myMessages=new ArrayList<Message>();
    //a static hashmap to store user passwords for login
    private static HashMap<String,String> userPasswords=new HashMap<>();
    private static ArrayList<User> allUsers;
    //constructor
    public User(String name,String password,String type,String country,String email){
        this.password=password;
        this.name=name;
        this.accountType=type;
        this.country=country;
        this.emailAddress=email;
        userPasswords.put(name,password);
    }
    //Methods
    //getters and setters
    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getAccountType() {return accountType;}

    public void setAccountType(String accountType) {this.accountType = accountType;}

    public String getEmailAddress() {return emailAddress;}

    public void setEmailAddress(String emailAddress) {this.emailAddress = emailAddress;}

    //login
    public boolean login(String name,String password){
        if (userPasswords.containsKey(name)&& userPasswords.get(name).equals(password))return true;
        return false;
    }

    //create account
    public void createAccount(String name,String password,String type,String emailAddress){
        User current=new User(name,password,type,emailAddress);
        allUsers.add(current);

    }

    public ArrayList<Message> getMyMessages() {
        return myMessages;
    }

    public void addMessages(Message myMessage) {
        this.myMessages.add(myMessage);
    }

    //Send message
    public void sendMessage(User receiver,String text){
        Message created=new Message(this,receiver,text);
        this.addMessages(created);
        receiver.addMessages(created);
    }
}
