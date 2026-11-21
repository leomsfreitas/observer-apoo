package auction;

public class Auction {

    private final String item;
    private double highestBid;
    private String highestBidder;

    public Auction(String item, double startingPrice) {
        this.item = item;
        this.highestBid = startingPrice;
    }

    public void placeBid(String bidder, double amount) {
        if (amount <= highestBid) {
            System.out.println("[LEILAO] Lance de " + bidder + " (R$ " + amount + ") recusado.");
            return;
        }

        highestBid = amount;
        highestBidder = bidder;
        System.out.println("[LEILAO] Novo lance: " + bidder + " - R$ " + amount);
    }

    public String getItem() {
        return item;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public String getHighestBidder() {
        return highestBidder;
    }
}
