package Osmosis;

import ks.common.games.Solitaire;
import ks.common.model.Column;
import ks.common.model.Deck;
import ks.common.model.Move;
import ks.common.model.Pile;

public class HandToFoundationMove extends Move {

	protected Column hand;
	protected Osmosis mainGame;
	protected Column mostRecentFoundation;
    
    /**
     * Class Representing the action of dealing four cards to each Pile.
     */
    public HandToFoundationMove(Osmosis mainGame,Column h) {
        super();
        this.hand = h;
        this.mainGame = mainGame;
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
        //if ()

        // EXECUTE:
    	System.out.println("Move is valid.");

        if(hand.empty())
        {
        	System.out.print("Hand empty. ");
        	return false;
        }
        if(hand.peek().sameSuit(mainGame.column1.peek()))
        {
        	mainGame.column1.add(hand.get());
        	mostRecentFoundation = mainGame.column1;
        	theGame.updateNumberCardsLeft(+1);
        }        
        else if(hand.peek().sameSuit(mainGame.column2.peek()))
        {
        	//if(column1.)
        	{
	        	mainGame.column1.add(hand.get());
	        	mostRecentFoundation = mainGame.column1;
	        	theGame.updateNumberCardsLeft(+1);
        	}
        } 
        else if(hand.peek().sameSuit(mainGame.column3.peek()))
        {
        	
        } 
        else if(hand.peek().sameSuit(mainGame.column4.peek()))
        {
        	
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
        //if (hand.empty())
        //    return false;

        // UNDO:
        // carefully reverse order of operations (changes to models will cause views to be marked as dirty)
        //hand.add(foundation.get());

        // update count in deck.
        //theGame.updateNumberCardsLeft(+1);
        hand.add(mostRecentFoundation.get());
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

