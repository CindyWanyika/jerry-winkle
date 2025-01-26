public class Donation {
    private String category;
    private Need need;
    private Donor donor;
    private Organisation recipient;

    public Donation(String category,Need need,Donor donor,Organisation recipient){
        this.category=category;
        this.need=need;
        this.donor=donor;
        this.recipient=recipient;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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
}
