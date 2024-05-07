package dao;


public abstract class Donation {
    // Attributes
	//private Int donorID;
    private String donorName;
    private double Amount;
    
    public double getAmount() {
		return Amount;
	}
    //Setters
	public void setAmount(double amount) {
		Amount = amount;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	// Getters
    public String getDonorName() {
        return donorName;
    }

    public double getdonationAmount() {
        return Amount;
    }
    //default cons
    public Donation() {
   	 System.out.println("default cons");
    }

    // Constructor
    public Donation(String donorName, double Amount) {
        this.donorName = donorName;
        this.Amount= Amount;
    }

    // Abstract method to record the donation
    public abstract void recordDonation();

    
}
