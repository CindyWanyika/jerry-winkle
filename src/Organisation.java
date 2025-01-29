import java.util.ArrayList;

public class Organisation extends User {
    private String description;
    private String licenceNo;
    private ArrayList<Need> needs;

    public Organisation(String name, String password, String type, String country, String email,String description,String licenceNo) {
        super(name, password, type, country, email);
        needs=new ArrayList<Need>();
        this.description=description;
        this.licenceNo=licenceNo;
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

    public ArrayList<Need> getNeeds() {
        return needs;
    }

    public void setNeeds(ArrayList<Need> needs) {
        this.needs = needs;
    }
}
