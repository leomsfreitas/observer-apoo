package auction;

public class OutbidNotifier {

    private final Auction auction;
    private double lastSeenBid;
    private String lastSeenBidder;

    public OutbidNotifier(Auction auction) {
        this.auction = auction;
        this.lastSeenBid = auction.getHighestBid();
        this.lastSeenBidder = auction.getHighestBidder();
    }

    public void check() {
        if (auction.getHighestBid() == lastSeenBid) {
            System.out.println("[EMAIL] Consultou o leilao... nada mudou.");
            return;
        }

        if (lastSeenBidder != null) {
            System.out.println("[EMAIL] Para " + lastSeenBidder + ": seu lance foi superado. "
                    + "Novo maior lance: R$ " + auction.getHighestBid());
        } else {
            System.out.println("[EMAIL] Primeiro lance, ninguem para avisar.");
        }

        lastSeenBid = auction.getHighestBid();
        lastSeenBidder = auction.getHighestBidder();
    }
}
