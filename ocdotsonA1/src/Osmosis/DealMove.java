package Osmosis;

import ks.common.games.Solitaire;
import ks.common.model.Deck;
import ks.common.model.Move;
import ks.common.model.Pile;

public class DealMove extends Move {
    /** The deck. */
    protected Deck deck;

    /** The hand. */
	protected Pile hand;
    
    /**
     * Class Representing the action of dealing four cards to each Pile.
     */
    public DealMove(Deck d, Pile h) {
        super();

        /** Store all parameters with the Move Object. */
        this.deck = d;
        this.hand = h;

    }
    
    /**
     * Each move should knows how to execute itself.
     * <p>
     * Note: this interface wasn't in place in time for the course, so this
     * method returns false, and can be overridden by the necessary subclasses.
     * <p>
     * @param theGame    the game being played.
     * @return boolean
     */
    public boolean doMove(Solitaire theGame) {
    	System.out.print("Move started... ");
        // VALIDATE:
        if (valid(theGame) == false)
        {
        	System.out.print("Invalid move.");
            return false;
        }

        // EXECUTE:
    	System.out.println("Move is valid.");

        if(deck.count() == 0)
        {
        	System.out.print("Deck empty. ");
        	int handSize = hand.count(); //Temp variable to manage number of cards count
            for( int i = 0; i < handSize; i++)
            {
            	deck.add(hand.get());
                theGame.updateNumberCardsLeft(+1);
            }
        }
        else if(deck.count() == 2)
        {
        	System.out.println("Deck at two.");
	        hand.add(deck.get());
	        hand.add(deck.get());
	        theGame.updateNumberCardsLeft(-2);
        }
        else if(deck.count() == 1)
        {
            hand.add(deck.get());
            theGame.updateNumberCardsLeft(-1);
        }
        else if(deck.count() >= 3)
        {
            hand.add(deck.get());
            hand.add(deck.get());
            hand.add(deck.get());
            theGame.updateNumberCardsLeft(-3);
        }
        else
        {
        	System.out.println("We messed up son");
        }


        return true;
    }
    
    /**
     * To undo this move, we move the cards from the piles back into the Deck
     * in the order they were played.
     * @param theGame 
     */
    public boolean undo(Solitaire theGame) {
        // VALIDATE:
        if (hand.empty())
            return false;

        // UNDO:
        // carefully reverse order of operations (changes to models will cause views to be marked as dirty)
        deck.add(hand.get());
        deck.add(hand.get());
        deck.add(hand.get());

        // update count in deck.
        theGame.updateNumberCardsLeft(+3);
        return true;
    }
    
    /**
     * Validate DealMove.
     * @param theGame Solitaire 
     */
    public boolean valid(Solitaire theGame) {
        boolean validation = false;

        // VALIDATE:
        //    dealFour(d) : not d.empty()
        //if (!deck.empty()) {
            validation = true;

        return validation;
    }
}

