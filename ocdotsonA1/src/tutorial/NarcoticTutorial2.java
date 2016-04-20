package tutorial;

import ks.client.gamefactory.GameWindow;
import ks.common.games.Solitaire;
import ks.common.model.Deck;
import ks.common.model.Pile;
import ks.common.view.CardImages;
import ks.common.view.DeckView;
import ks.common.view.IntegerView;
import ks.common.view.PileView;
import ks.launcher.Main;

public class NarcoticTutorial2 extends Solitaire {
	
	IntegerView scoreView;
	IntegerView numLeftView;
	Deck deck;
	Pile pile1, pile2, pile3, pile4;
	DeckView deckView;
	PileView pileView1, pileView2, pileView3, pileView4;
	

	@Override
	public String getName() {
		return "Narcotic Tutorial 2";
	}

	@Override
	public boolean hasWon() {
		return deck.empty() &&
				   pile1.empty() && pile2.empty() && pile3.empty() && pile4.empty();
	}

	@Override
	public void initialize() {
		// Initialize model, view, and controllers.
		initializeModel(getSeed());
		initializeView();
		initializeController();
		
		// Prepare game AFTER all controllers are set up.
		// each column gets a card from the deck.
		pile1.add (deck.get());
		pile2.add (deck.get());
		pile3.add (deck.get());
		pile4.add (deck.get());
		
		// we have dealt four cards.
		updateNumberCardsLeft (-4);	

	}
	
	
	
	void initializeController() {
		deckView.setMouseAdapter(new NarcoticDeckController (this));

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

		// add to our model a set of four piles
		addModelElement(pile1);
		addModelElement(pile2);
		addModelElement(pile3);
		addModelElement(pile4);
		
		
	}
	
	void initializeView() {
		// Get the card artwork to be used. This is needed for the dimensions.
		CardImages ci = getCardImages();

		// add to our view (as defined within our superclass). Similar for other widgets
		deckView = new DeckView(deck);
		deckView.setBounds(20, 20, ci.getWidth(), ci.getHeight());
		addViewWidget(deckView);

		pileView1 = new PileView(pile1);
		pileView1.setBounds(40 + ci.getWidth(), 20, ci.getWidth(), ci.getHeight());
		addViewWidget(pileView1);

		pileView2 = new PileView(pile2);
		pileView2.setBounds(60 + 2 * ci.getWidth(), 20, ci.getWidth(), ci.getHeight());
		addViewWidget(pileView2);

		pileView3 = new PileView(pile3);
		pileView3.setBounds(80 + 3 * ci.getWidth(), 20, ci.getWidth(), ci.getHeight());
		addViewWidget(pileView3);

		pileView4 = new PileView(pile4);
		pileView4.setBounds(100 + 4 * ci.getWidth(), 20, ci.getWidth(), ci.getHeight());
		addViewWidget(pileView4);

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
		GameWindow gw = Main.generateWindow(new NarcoticTutorial2(), 117);
		gw.setVisible(true);
	}

}
