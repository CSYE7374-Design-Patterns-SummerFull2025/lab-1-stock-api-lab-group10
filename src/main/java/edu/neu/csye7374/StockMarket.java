package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;
    private final List<Stock> stocks = new ArrayList<>();

    private StockMarket() { }

    public static StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void tradeStock(String name, String bid) {
        for (Stock s : stocks) {
            if (s.name.equalsIgnoreCase(name)) {
                s.setBid(bid);
                System.out.println("Traded " + name + " with bid " + bid);
                return;
            }
        }
        System.out.println("Stock not found: " + name);
    }

    public void removeStock(String name) {
        stocks.removeIf(s -> s.name.equalsIgnoreCase(name));
    }

    public void showStocks() {
        System.out.println("\n--- Current Market State ---");
        for (Stock s : stocks) {
            System.out.println(s);
        }
    }

    public static void demo() {
        StockMarket market = StockMarket.getInstance();

        Stock google = new GoogleStock("Google", 1110.15, "Google Common Stock");
        Stock apple = new AppleStock("Apple", 2364.25, "Apple Common Stock");
        Stock amazon = new AmazonStock("Amazon", 1854.75, "Amazon Common Stock");
        Stock ibm = new IBMStock("IBM", 45652.29, "IBM Common Stock");

        market.addStock(google);
        market.addStock(apple);
        market.addStock(amazon);
        market.addStock(ibm);

        // 6 bids for Google
        String[] googleBids = {"1120.00", "1130.00", "1140.00", "1150.00", "1160.00", "1170.00"};
        for (String bid : googleBids) {
            market.tradeStock("Google", bid);
            market.showStocks();
        }

        String[] appleBids = {"4561.00", "7894.00", "1548.00", "5862.50", "4578.00", "3265.00"};
        for (String bid : appleBids) {
            market.tradeStock("Apple", bid);
            market.showStocks();
        }

        String[] amazonBids = {"9874.00", "1542.00", "2652.00", "3652.00", "2552.00", "5874.00"};
        for (String bid : amazonBids) {
            market.tradeStock("Amazon", bid);
            market.showStocks();
        }

        String[] ibmBids = {"1542.00", "1642.00", "1744.00", "1756.00", "6598.00", "7865.00"};
        for (String bid : ibmBids) {
            market.tradeStock("IBM", bid);
            market.showStocks();
        }
    }
}
