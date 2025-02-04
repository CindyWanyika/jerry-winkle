import java.time.LocalDate;

public class Donation {

    private Need need;
    private String needName;
    private Donor donor;
    private String donorName;
    private Organisation recipient;
    private String orgName;
    private final LocalDate date;

    public Donation(String need,String dname,String orgname){
        this.needName=need;
        this.donorName=dname;
        this.orgName=orgname;
        this.date=LocalDate.now();
    }

    public Donation(Need need,Donor donor,Organisation recipient){

        this.need=need;
        this.donor=donor;
        this.recipient=recipient;
        this.date = LocalDate.now();
    }


    public Need getNeed() {
        return need;
    }

    public void setNeed(Need need) {
        this.need = need;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Organisation getRecipient() {
        return recipient;
    }

    public void setRecipient(Organisation recipient) {
        this.recipient = recipient;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getNeedName() {
        return needName;
    }

    public void setNeedName(String needName) {
        this.needName = needName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
