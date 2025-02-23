import java.time.LocalDate;

public class Donation {

    private Need need;
    private String needName;
    private String category;
    private Donor donor;
    private Organisation recipient;
    private final LocalDate date;

    public Donation(Need need,Donor donor,Organisation recipient){

        this.need=need;
        this.donor=donor;
        this.recipient=recipient;
        this.date = LocalDate.now();
    }
    public Donation(Donor donor,Organisation recipient,String needName,String categ){

        this.needName=needName;
        this.category=categ;
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

    @Override
    public String toString(){
        return "Organisation name"+this.recipient.getFname()+
                "\nDonorName: "+this.donor.getFname()+
                "\nCategory: "+this.category+
                "\nDescription: "+this.needName+
                "\nDate: "+this.date.toString();

    }


}
