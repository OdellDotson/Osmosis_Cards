package Osmosis;

import ks.common.games.Solitaire;
import ks.common.model.Column;
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
     * Determines if a given reserve pile is able to play into any of the foundation columns.
     * @param mainGame
     * @param reserve
     * @return
     */
    public boolean allowedToPlaceIntoFoundation(Osmosis mainGame, Pile reserve)
    {
    	//If the reserve has more than 0 cards
    	if(reserve.count() > 0)
    	{
    		//If the reserve pile's top is the same suit as column 1, it can definitely go into column 1.
	    	if(reserve.peek().sameSuit(mainGame.column1.peek()))
	        {
	        	return true;
	        }        
	    	//If column 2 has cards and our reserve has the same suit as the column, or if the column 2 is empty
	        else if(((mainGame.column2.count()>0) && reserve.peek().sameSuit(mainGame.column2.peek()) || mainGame.column2.count()==0) && mainGame.column3.count() != 13)
	        {
	        	//Check if column 1 has any of that suit, so we know if we can add it.
	        	for(int i = 0; i < mainGame.column1.count(); i++)
	        	{
	        		if(mainGame.column1.peek(i).getRank() == reserve.peek().getRank())
	        		{
	        			return true;
	        		}
		        }
	        }
	        else if((mainGame.column3.count()>0) && reserve.peek().sameSuit(mainGame.column3.peek()) || mainGame.column3.count()==0)
	        {
	        	for(int i = 0; i < mainGame.column2.count(); i++)
	        	{
	        		if(mainGame.column2.peek(i).getRank() == reserve.peek().getRank())
	        		{
	        			return true;
	        		}
		        }
	        }
	        else if((mainGame.column4.count()>0) && reserve.peek().sameSuit(mainGame.column4.peek()) || mainGame.column4.count()==0)
	        {
	        	for(int i = 0; i < mainGame.column3.count(); i++)
	        	{
	        		if(mainGame.column3.peek(i).getRank() == reserve.peek().getRank())
	        		{
	        			return true;
	        		}
		        }
	        }
    	}
    	//If the reserve has no cards, it cannot place into any foundation columns.
    	//If we catch no other cases, return false.
    	return false;
    }
    
    /**
     * If any of the reserve piles are able to place into any of the foundation columns, 
     * do not allow any hand -> foundation moves.
     * @param mainGame
     * @return
     */
    public boolean allowedToMakeHandFoundationMove(Osmosis mainGame)
    {
    	return !(allowedToPlaceIntoFoundation(mainGame, mainGame.pile1) ||
    			allowedToPlaceIntoFoundation(mainGame, mainGame.pile2) ||
    			allowedToPlaceIntoFoundation(mainGame, mainGame.pile3) ||
    			allowedToPlaceIntoFoundation(mainGame, mainGame.pile4));
    }
    
    
    public boolean doMove(Solitaire theGame) {
    	//System.out.print("Move started... ");
        // VALIDATE:
    	//System.out.println(allowedToMakeHandFoundationMove(mainGame));
        if (valid(theGame) == false)
        {
        	//System.out.print("Invalid move.");
            return false;
        }
        if (allowedToMakeHandFoundationMove(mainGame) == false)
        {
        	System.out.println("There are valid reserve -> foundation moves, do one of those first.");
        	return false;
        }

        
        
        //If hand is empty
        if(hand.empty())
        {
        	System.out.print("Hand empty. ");
        	return false;
        }
        
        //Placing in foundation 1
        else if(hand.peek().sameSuit(mainGame.column1.peek()))
        {
        	mainGame.column1.add(hand.get());
        	mostRecentFoundation = mainGame.column1;
        	//theGame.updateNumberCardsLeft(-1);    			
			mainGame.updateScore(+1);
        }        
        
        //Placing in foundation 2
        else if((mainGame.column2.count()>0) && hand.peek().sameSuit(mainGame.column2.peek()) || mainGame.column2.count()==0)
        {
        	if((mainGame.column1.count() == 0) || (hand.count() == 0))
        	{}
        	else if(mainGame.column2.count()==0)
        	{
        		if (hand.peek().getRank() == mainGame.firstCard.getRank())
        		{
        			mainGame.column2.add(hand.get());
    	        	mostRecentFoundation = mainGame.column2;
    	        	//theGame.updateNumberCardsLeft(-1);    			
        			mainGame.updateScore(+1);//HERE
    	        	return true;
        		}
        	}
        	else
        	{
	        	for(int i = 0; i < mainGame.column1.count(); i++)
	        	{
	        		//System.out.print(i);
	        		//System.out.print(",");
	        		//System.out.println(mainGame.column1.count());
	        		if(mainGame.column1.peek(i).getRank() == hand.peek().getRank())
	        		{
	        			mainGame.column2.add(hand.get());
	    	        	mostRecentFoundation = mainGame.column2;
	    	        	//theGame.updateNumberCardsLeft(+1);    			
	        			mainGame.updateScore(+1);
	    	        	return true;
	        		}
		        }
        	}
        }
        
        //Placing in foundation 3
        else if((mainGame.column3.count()>0) && hand.peek().sameSuit(mainGame.column3.peek()) || mainGame.column3.count()==0)
        {
        	if(mainGame.column2.count() == 0 || hand.count() == 0)
        	{
        		
        	}
        	else if(mainGame.column3.count()==0)
        	{
        		if (hand.peek().getRank() == mainGame.firstCard.getRank())
        		{
        			mainGame.column3.add(hand.get());
    	        	mostRecentFoundation = mainGame.column3;
    	        	//theGame.updateNumberCardsLeft(+1);    			
        			mainGame.updateScore(+1);
    	        	return true;
        		}
        	}
        	else
        	{
	        	for(int i = 0; i < mainGame.column2.count(); i++)
	        	{
	        		if(mainGame.column2.peek(i).getRank() == hand.peek().getRank())
	        		{
	        			mainGame.column3.add(hand.get());
	    	        	mostRecentFoundation = mainGame.column3;
	    	        	//theGame.updateNumberCardsLeft(+1);    			
	        			mainGame.updateScore(+1);
	    	        	return true;
	        		}
		        }
        	}
        } 
        
        //Placing in foundation 4.
        else if((mainGame.column4.count()>0) && hand.peek().sameSuit(mainGame.column4.peek()) || mainGame.column4.count()==0)
        {
        	if(mainGame.column3.count() == 0 || hand.count() == 0)
        	{
        		
        	}        	
        	else if(mainGame.column4.count()==0)
        	{
        		if (hand.peek().getRank() == mainGame.firstCard.getRank())
        		{
        			mainGame.column4.add(hand.get());
    	        	mostRecentFoundation = mainGame.column4;
    	        	//theGame.updateNumberCardsLeft(+1);    			
        			mainGame.updateScore(+1);
    	        	return true;
        		}
        	}
        	else
        	{
	        	for(int i = 0; i < mainGame.column3.count(); i++)
	        	{
	        		if(mainGame.column3.peek(i).getRank() == hand.peek().getRank())
	        		{
	        			mainGame.column4.add(hand.get());
	    	        	mostRecentFoundation = mainGame.column4;
	    	        	//theGame.updateNumberCardsLeft(+1);    			
	        			mainGame.updateScore(+1);
	    	        	return true;
	        		}
		        }
        	}
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
		mainGame.updateScore(-1);
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

