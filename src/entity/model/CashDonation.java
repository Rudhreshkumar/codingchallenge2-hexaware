package entity.model;
import dao.Donation;
import java.time.LocalDateTime;

public class CashDonation extends Donation {
    // Additional attribute
    private LocalDateTime donationDate;

    // Constructor
    public CashDonation(String donorName, double amount, LocalDateTime donationDate) {
        super(donorName, amount);
        this.donationDate = donationDate;
    }

    // Method to record a cash donation
    @Override
    public void recordDonation() {
        // Implement record keeping logic here
        System.out.println("Cash donation recorded for donor: " + getDonorName() +
                ", Amount: $" + getAmount() + ", Date: " + donationDate);
    }

    // Example usage
    public static void main(String[] args) {
        // Creating a cash donation object
        CashDonation cashDonation = new CashDonation("John Doe", 100.50, LocalDateTime.now());

        // Recording the donation
        cashDonation.recordDonation();
    }
}
