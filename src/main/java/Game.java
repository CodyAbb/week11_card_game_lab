import java.util.ArrayList;

public class Game {
    private ArrayList<Person> players;
    private Deck deck;

    public Game() {
        this.players = new ArrayList<Person>();
        this.deck = new Deck();
    }

    public void addPlayer(String name){
        this.players.add(new Person(name));
    }

    public void prepareDeck(){
        this.deck.populateDeck();
        this.deck.shuffleDeck();
    }

    public void giveCards(){
        for (Person player : players) {
            player.addToHand(deck.dealCard());
        }
    }

    public Person findWinner(){
        int winningScore = 0;
        Person winner = null;
        for (Person player : players) {
            int cardScore = Score.getValue(player.getCard());
            if (cardScore > winningScore) {
                winningScore = cardScore;
                winner = player;
            }
        }
        return winner;
    }
}
