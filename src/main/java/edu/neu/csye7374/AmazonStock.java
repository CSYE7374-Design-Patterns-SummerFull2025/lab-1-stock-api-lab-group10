package edu.neu.csye7374;

public class AmazonStock extends Stock {
    private final double initialPrice;

    public AmazonStock(String name, double price, String description) {
        super(name, price, description);
        this.initialPrice = price;
    }

    @Override
    public String getMetric() {
        double changePct = ((price - initialPrice) / initialPrice) * 100.0;
        return String.format("TechMetric: %.2f%%", changePct);
    }
}
