package edu.neu.csye7374;

public interface Tradeable1 extends Tradable {
    @Override
    default String getMetric() {
        return "[Tradeable1 default metric]";
    }
}