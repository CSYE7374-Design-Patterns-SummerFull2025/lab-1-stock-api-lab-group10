package edu.neu.csye7374;

public interface Tradeable0 extends Tradable {
    default void setBid(String bid) {
        System.out.println("[Tradeable0 default setBid] Bid received: " + bid);
    }
    default String getMetric() {
        return "[Tradeable0 default metric]";
    }
}