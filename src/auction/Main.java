package auction;

public class Main {

    public static void main(String[] args) {
        Auction auction = new Auction("Notebook Gamer", 2000.0);
        AuctionScreen screen = new AuctionScreen(auction);
        OutbidNotifier notifier = new OutbidNotifier(auction);
        BidHistory history = new BidHistory(auction);

        for (int round = 1; round <= 8; round++) {
            System.out.println("--- Rodada " + round + " ---");

            if (round == 1) {
                auction.placeBid("Ana", 2100.0);
            }
            if (round == 3) {
                auction.placeBid("Bruno", 2300.0);
            }
            if (round == 4) {
                auction.placeBid("Carla", 2500.0);
            }
            if (round == 5) {
                auction.placeBid("Bruno", 2400.0);
            }
            if (round == 6) {
                auction.placeBid("Bruno", 2700.0);
            }

            screen.check();
            if (round % 2 == 0) {
                notifier.check();
            }
            if (round % 3 == 0) {
                history.check();
            }
        }

        System.out.println("--- Fim do leilao ---");
        history.printHistory();
    }
}
