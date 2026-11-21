package auction;

public class AuctionScreen {

    private final Auction auction;
    private double lastSeenBid;

    public AuctionScreen(Auction auction) {
        this.auction = auction;
        this.lastSeenBid = auction.getHighestBid();
    }

    public void check() {
        if (auction.getHighestBid() == lastSeenBid) {
            System.out.println("[TELAO] Consultou o leilao... nada mudou.");
            return;
        }

        lastSeenBid = auction.getHighestBid();
        System.out.println("[TELAO] " + auction.getItem() + " | Maior lance: R$ " + lastSeenBid
                + " (" + auction.getHighestBidder() + ")");
    }
}
