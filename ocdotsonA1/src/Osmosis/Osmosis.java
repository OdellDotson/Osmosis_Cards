package Osmosis;

import ks.client.gamefactory.GameWindow;
import ks.common.games.Solitaire;
import ks.common.model.Column;
import ks.common.model.Deck;
import ks.common.model.Pile;
import ks.common.view.CardImages;
import ks.common.view.DeckView;
import ks.common.view.FanPileView;
import ks.common.view.IntegerView;
import ks.common.view.PileView;
import ks.common.view.RowView;
import ks.launcher.Main;

public class Osmosis extends Solitaire {
	
	IntegerView scoreView;
	IntegerView numLeftView;
	Deck deck;
	Pile pile1, pile2, pile3, pile4;
	Column column1, column2, column3, column4, hand;
	DeckView deckView;
	PileView pileView1, pileView2, pileView3, pileView4;
	FanPileView handView;
	RowView columnView1,columnView2,columnView3,columnView4;
	
	
	

	@Override
	public String getName() {
		return "Osmosis Dotson";
	}
	

	@Override
	public boolean hasWon() {
		return deck.empty() && hand.empty() && pile1.empty() && pile2.empty() && pile3.empty() && pile4.empty();
	}

	@Override
	public void initialize() {
		setSeed(193);
		// Initialize model, view, and controllers.
		initializeModel(getSeed());
		initializeView();
		initializeController();
		System.out.println(getSeed());
		// Prepare game AFTER all controllers are set up.
		// each reserve gets four cards from the deck.
		pile1.add (deck.get());
		pile2.add (deck.get());
		pile3.add (deck.get());
		pile4.add (deck.get());
		
		pile1.add (deck.get());
		pile2.add (deck.get());
		pile3.add (deck.get());
		pile4.add (deck.get());
		
		pile1.add (deck.get());
		pile2.add (deck.get());
		pile3.add (deck.get());
		pile4.add (deck.get());
		
		pile1.add (deck.get());
		pile2.add (deck.get());
		pile3.add (deck.get());
		pile4.add (deck.get());
		
		// we have dealt four cards to each of the four reserves.
		updateNumberCardsLeft (-16);	

		//Deal a single card to the first foundation.		
		column1.add(deck.get());

		
		updateNumberCardsLeft (-1);
	}
	
	
	
	void initializeController() {
		pileView1.setMouseAdapter(new ReserveController (this, pileView1, pile1));
		pileView2.setMouseAdapter(new ReserveController (this, pileView2, pile2));
		pileView3.setMouseAdapter(new ReserveController (this, pileView3, pile3));
		pileView4.setMouseAdapter(new ReserveController (this, pileView4, pile4));
		handView.setMouseAdapter(new HandController (this, handView));
		deckView.setMouseAdapter(new DealController (this));
	}
	
	void initializeModel(int seed) {
		// initial score is set to ZERO (every Solitaire game by default has a score) 
		// and there are 52 cards left.

		numLeft = getNumLeft();
		numLeft.setValue(52);
		score = getScore();
		score.setValue(0);
		
		// add to our model a deck, properly shuffled using the seed. 
		deck = new Deck("deck");
		deck.create(seed);
		addModelElement(deck);

		pile1 = new Pile("pile1");
		pile2 = new Pile("pile2");
		pile3 = new Pile("pile3");
		pile4 = new Pile("pile4");
		
		hand = new Column("hand");
		
		column1 = new Column("column1");
		column2 = new Column("column2");
		column3 = new Column("column3");
		column4 = new Column("column4");

		// add to our model a set of four piles and the hand.
		addModelElement(pile1);
		addModelElement(pile2);
		addModelElement(pile3);
		addModelElement(pile4);	
		addModelElement(hand);
		
		//Add to our model our four columns.
		addModelElement(column1);
		addModelElement(column2);
		addModelElement(column3);
		addModelElement(column4);	
	}
	
	void initializeView() {
		// Get the card artwork to be used. This is needed for the dimensions.
		CardImages ci = getCardImages();

		// add to our view (as defined within our superclass). Similar for other widgets
		deckView = new DeckView(deck);
		deckView.setBounds(80, 10, ci.getWidth(), ci.getHeight());
		addViewWidget(deckView);
		
		handView = new FanPileView(3, hand);
		handView.setBounds(200, 10, 3*ci.getWidth(), ci.getHeight());
		addViewWidget(handView);

		pileView1 = new PileView(pile1);
		pileView1.setBounds(120, 20 + ci.getHeight(), ci.getWidth(), ci.getHeight());
		addViewWidget(pileView1);

		pileView2 = new PileView(pile2);
		pileView2.setBounds(120, 40 + 2 * ci.getHeight(), ci.getWidth(), ci.getHeight());
		addViewWidget(pileView2);

		pileView3 = new PileView(pile3);
		pileView3.setBounds(120, 60 + 3 * ci.getHeight(), ci.getWidth(), ci.getHeight());
		addViewWidget(pileView3);

		pileView4 = new PileView(pile4);
		pileView4.setBounds(120, 80 + 4 * ci.getHeight(), ci.getWidth(), ci.getHeight());
		addViewWidget(pileView4);
		
		
		columnView1 = new RowView(column1);
		columnView1.setBounds(240, 20 + 1 * ci.getHeight(), ci.getWidth()+300, ci.getHeight());
		addViewWidget(columnView1);		
		
		columnView2 = new RowView(column2);
		columnView2.setBounds(240, 40 + 2 * ci.getHeight(), ci.getWidth()+300, ci.getHeight());
		addViewWidget(columnView2);	
		
		columnView3 = new RowView(column3);
		columnView3.setBounds(240, 60 + 3 * ci.getHeight(), ci.getWidth()+300, ci.getHeight());
		addViewWidget(columnView3);	
		
		columnView4 = new RowView(column4);
		columnView4.setBounds(240, 80 + 4 * ci.getHeight(), ci.getWidth()+300, ci.getHeight());
		addViewWidget(columnView4);
		

		scoreView = new IntegerView(getScore());
		scoreView.setBounds(100 + 5 * ci.getWidth(), 20, 100, 60);
		addViewWidget(scoreView);

		numLeftView = new IntegerView(getNumLeft());
		numLeftView.setBounds(200 + 5* ci.getWidth(), 20, 100, 60);
		addViewWidget(numLeftView);
	}
	
	/** Code to launch solitaire variation. */
	public static void main (String []args) {
		// Seed is to ensure we get the same initial cards every time.
		GameWindow gw = Main.generateWindow(new Osmosis(), 117);
		gw.setVisible(true);
	}

}
