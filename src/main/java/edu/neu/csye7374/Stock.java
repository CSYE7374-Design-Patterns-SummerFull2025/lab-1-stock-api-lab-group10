package edu.neu.csye7374;

public abstract class Stock implements Tradeable0 {
    protected String name;
    protected double price;
    protected String description;

    public Stock(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    @Override
    public void setBid(String bid) {
        try {
            double bidVal = Double.parseDouble(bid);
            // simple average update
            this.price = (this.price + bidVal) / 2.0;
        } catch (NumberFormatException e) {
            System.err.println("Invalid bid: " + bid);
        }
    }

    @Override
    public abstract String getMetric();

    @Override
    public String toString() {
        return String.format("Stock[name=%s, price=%.2f, description='%s', metric=%s]",
                name, price, description, getMetric());
    }
}
