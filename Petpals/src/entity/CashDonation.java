package entity;
import java.time.LocalDate;

public class CashDonation extends Donation {
    private LocalDate donationDate;

    public CashDonation(String donorName, double amount, LocalDate donationDate) {
        super(donorName, amount);
        this.donationDate = donationDate;
    }

    @Override
    public void recordDonation() {
        System.out.println("Recording cash donation from " + donorName + " of amount " + amount + " on " + donationDate);
    }
}
