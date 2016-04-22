package Osmosis;

import ks.common.games.Solitaire;
import ks.common.model.Column;
import ks.common.model.Move;

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
    
    public boolean allowedToMakeHandFoundationMove(Osmosis mainGame)
    {
    	if(mainGame.pile1.count() > 0)
    	{
	    	if(mainGame.pile1.peek().sameSuit(mainGame.column1.peek()))
	        {
	        	return false;
	        }        
	        else if((mainGame.column2.count()>0) && mainGame.pile1.peek().sameSuit(mainGame.column2.peek()) || mainGame.column2.count()==0)
	        {
	        	for(int i = 0; i < mainGame.column1.count(); i++)
	        	{
	        		if(mainGame.column1.peek(i).getRank() == mainGame.pile1.peek().getRank())
	        		{
	        			return false;
	        		}
		        }
	        }
	        else if((mainGame.column3.count()>0) && mainGame.pile1.peek().sameSuit(mainGame.column3.peek()) || mainGame.column3.count()==0)
	        {
	        	for(int i = 0; i < mainGame.column2.count(); i++)
	        	{
	        		if(mainGame.column2.peek(i).getRank() == mainGame.pile1.peek().getRank())
	        		{
	        			return false;
	        		}
		        }
	        } 
	        else if((mainGame.column4.count()>0) && mainGame.pile1.peek().sameSuit(mainGame.column4.peek()) || mainGame.column4.count()==0)
	        {
	        	for(int i = 0; i < mainGame.column3.count(); i++)
	        	{
	        		if(mainGame.column3.peek(i).getRank() == mainGame.pile1.peek().getRank())
	        		{
	        			return false;
	        		}
		        }
	        }
    	}
    	
    	if(mainGame.pile4.count() > 0)
    	{
	    	if(mainGame.pile4.peek().sameSuit(mainGame.column1.peek()))
	        {
	        	return false;
	        }        
	        else if((mainGame.column2.count()>0) && mainGame.pile4.peek().sameSuit(mainGame.column2.peek()) || mainGame.column2.count()==0)
	        {
	        	for(int i = 0; i < mainGame.column1.count(); i++)
	        	{
	        		if(mainGame.column1.peek(i).getRank() == mainGame.pile4.peek().getRank())
	        		{
	        			return false;
	        		}
		        }
	        }
	        else if((mainGame.column3.count()>0) && mainGame.pile4.peek().sameSuit(mainGame.column3.peek()) || mainGame.column3.count()==0)
	        {
	        	for(int i = 0; i < mainGame.column2.count(); i++)
	        	{
	        		if(mainGame.column2.peek(i).getRank() == mainGame.pile4.peek().getRank())
	        		{
	        			return false;
	        		}
		        }
	        } 
	        else if((mainGame.column4.count()>0) && mainGame.pile4.peek().sameSuit(mainGame.column4.peek()) || mainGame.column4.count()==0)
	        {
	        	for(int i = 0; i < mainGame.column3.count(); i++)
	        	{
	        		if(mainGame.column3.peek(i).getRank() == mainGame.pile4.peek().getRank())
	        		{
	        			return false;
	        		}
		        }
	        }
    	}
    	
    	
    	
    	if(mainGame.pile2.count() > 0)
    	{
	    	if(mainGame.pile2.peek().sameSuit(mainGame.column1.peek()))
	        {
	        	return false;
	        }        
	        else if((mainGame.column2.count()>0) && mainGame.pile2.peek().sameSuit(mainGame.column2.peek()) || mainGame.column2.count()==0)
	        {
	        	for(int i = 0; i < mainGame.column1.count(); i++)
	        	{
	        		if(mainGame.column1.peek(i).getRank() == mainGame.pile2.peek().getRank())
	        		{
	        			return false;
	        		}
		        }
	        }
	        else if((mainGame.column3.count()>0) && mainGame.pile2.peek().sameSuit(mainGame.column3.peek()) || mainGame.column3.count()==0)
	        {
	        	for(int i = 0; i < mainGame.column2.count(); i++)
	        	{
	        		if(mainGame.column2.peek(i).getRank() == mainGame.pile2.peek().getRank())
	        		{
	        			return false;
	        		}
		        }
	        } 
	        else if((mainGame.column4.count()>0) && mainGame.pile2.peek().sameSuit(mainGame.column4.peek()) || mainGame.column4.count()==0)
	        {
	        	for(int i = 0; i < mainGame.column3.count(); i++)
	        	{
	        		if(mainGame.column3.peek(i).getRank() == mainGame.pile2.peek().getRank())
	        		{
	        			return false;
	        		}
		        }
	        }
	    }
    	
    	
    	if(mainGame.pile3.count() > 0)
    	{
	    	if(mainGame.pile3.peek().sameSuit(mainGame.column1.peek()))
	        {
	        	return false;
	        }        
	        else if((mainGame.column2.count()>0) && mainGame.pile3.peek().sameSuit(mainGame.column2.peek()) || mainGame.column2.count()==0)
	        {
	        	for(int i = 0; i < mainGame.column1.count(); i++)
	        	{
	        		if(mainGame.column1.peek(i).getRank() == mainGame.pile3.peek().getRank())
	        		{
	        			return false;
	        		}
		        }
	        }
	        else if((mainGame.column3.count()>0) && mainGame.pile3.peek().sameSuit(mainGame.column3.peek()) || mainGame.column3.count()==0)
	        {
	        	for(int i = 0; i < mainGame.column2.count(); i++)
	        	{
	        		if(mainGame.column2.peek(i).getRank() == mainGame.pile3.peek().getRank())
	        		{
	        			return false;
	        		}
		        }
	        } 
	        else if((mainGame.column4.count()>0) && mainGame.pile3.peek().sameSuit(mainGame.column4.peek()) || mainGame.column4.count()==0)
	        {
	        	for(int i = 0; i < mainGame.column3.count(); i++)
	        	{
	        		if(mainGame.column3.peek(i).getRank() == mainGame.pile3.peek().getRank())
	        		{
	        			return false;
	        		}
		        }
	        }
    	}
    	
    	return true;
    }
    
    
    public boolean doMove(Solitaire theGame) {
    	//System.out.print("Move started... ");
        // VALIDATE:
    	System.out.println(allowedToMakeHandFoundationMove(mainGame));
        if (valid(theGame) == false)
        {
        	//System.out.print("Invalid move.");
            return false;
        }
        if (allowedToMakeHandFoundationMove(mainGame) == false)
        {
        	return false;
        }

        // EXECUTE:
    	System.out.println("Move is valid.");

//        if(hand.empty())
//        {
//        	System.out.print("Hand empty. ");
//        	return false;
//        }
//        if(hand.peek().sameSuit(mainGame.column1.peek()))
//        {
//        	mainGame.column1.add(hand.get());
//        	mostRecentFoundation = mainGame.column1;
//        	theGame.updateNumberCardsLeft(+1);
//        }        
//        else if(hand.peek().sameSuit(mainGame.column2.peek()))
//        {
//        	//if(column1.cards)
//        	{
//	        	mainGame.column1.add(hand.get());
//	        	mostRecentFoundation = mainGame.column1;
//	        	theGame.updateNumberCardsLeft(+1);
//        	}
//        } 
//        else if(hand.peek().sameSuit(mainGame.column3.peek()))
//        {
//        	
//        } 
//        else if(hand.peek().sameSuit(mainGame.column4.peek()))
//        {
//        	
//        }
//        //return true;
        
        
        if(hand.empty())
        {
        	System.out.print("Reserve empty. ");
        	return false;
        }
        if(hand.peek().sameSuit(mainGame.column1.peek()))
        {
        	mainGame.column1.add(hand.get());
        	mostRecentFoundation = mainGame.column1;
        	theGame.updateNumberCardsLeft(+1);
        }        
        else if((mainGame.column2.count()>0) && hand.peek().sameSuit(mainGame.column2.peek()) || mainGame.column2.count()==0)
        {
        	System.out.println("Nyah!");
        	for(int i = 0; i < mainGame.column1.count(); i++)
        	{
        		if(mainGame.column1.peek(i).getRank() == hand.peek().getRank())
        		{
        			mainGame.column2.add(hand.get());
    	        	mostRecentFoundation = mainGame.column2;
    	        	theGame.updateNumberCardsLeft(+1);
        		}
	        }
        }
        else if((mainGame.column3.count()>0) && hand.peek().sameSuit(mainGame.column3.peek()) || mainGame.column3.count()==0)
        {
        	for(int i = 0; i < mainGame.column2.count(); i++)
        	{
        		if(mainGame.column2.peek(i).getRank() == hand.peek().getRank())
        		{
        			mainGame.column3.add(hand.get());
    	        	mostRecentFoundation = mainGame.column3;
    	        	theGame.updateNumberCardsLeft(+1);
        		}
	        }
        } 
        else if((mainGame.column4.count()>0) && hand.peek().sameSuit(mainGame.column4.peek()) || mainGame.column4.count()==0)
        {
        	for(int i = 0; i < mainGame.column3.count(); i++)
        	{
        		if(mainGame.column3.peek(i).getRank() == hand.peek().getRank())
        		{
        			mainGame.column4.add(hand.get());
    	        	mostRecentFoundation = mainGame.column4;
    	        	theGame.updateNumberCardsLeft(+1);
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

