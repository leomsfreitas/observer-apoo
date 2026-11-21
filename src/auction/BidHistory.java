package auction;

import java.util.ArrayList;
import java.util.List;

public class BidHistory {

    private final Auction auction;
    private double lastSeenBid;
    private final List<String> entries = new ArrayList<>();

    public BidHistory(Auction auction) {
        this.auction = auction;
        this.lastSeenBid = auction.getHighestBid();
    }

    public void check() {
        if (auction.getHighestBid() == lastSeenBid) {
            System.out.println("[HISTORICO] Consultou o leilao... nada mudou.");
            return;
        }

        lastSeenBid = auction.getHighestBid();
        entries.add(auction.getHighestBidder() + " - R$ " + lastSeenBid);
        System.out.println("[HISTORICO] Registrado: " + auction.getHighestBidder() + " - R$ " + lastSeenBid);
    }

    public void printHistory() {
        System.out.println("[HISTORICO] Lances registrados:");
        for (String entry : entries) {
            System.out.println("  " + entry);
        }
    }
}
