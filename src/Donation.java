import java.time.LocalDate;

public class Donation {

    private Need need;
    private Donor donor;
    private Organisation recipient;
    private final LocalDate date;

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
}
