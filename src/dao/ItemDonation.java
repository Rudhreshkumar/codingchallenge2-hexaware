package dao;

import dao.Donation;


public class ItemDonation extends Donation {
    // Additional attribute
    private String itemType;

    // Constructor
    public ItemDonation(String donorName, double amount, String itemType) {
        super(donorName, amount);
        this.itemType = itemType;
    }

    // Method to record an item donation
    @Override
    public void recordDonation() {
        // Implement record keeping logic here
        System.out.println("Item donation recorded for donor: " + getDonorName() +
                ", Amount: $" + getAmount() + ", Item Type: " + itemType);
    }

    // Example usage
    public static void main(String[] args) {
        // Creating an item donation object
        ItemDonation itemDonation = new ItemDonation("Jane Smith", 50.25, "Toys");

        // Recording the donation
        itemDonation.recordDonation();
    }
}