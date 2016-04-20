package tutorial;

import ks.client.gamefactory.GameWindow;
import ks.common.games.Solitaire;
import ks.common.view.CardImages;
import ks.common.view.IntegerView;
import ks.launcher.Main;

public class NarcoticTutorial0 extends Solitaire {
	
	IntegerView scoreView;
	IntegerView numLeftView;

	@Override
	public String getName() {
		return "Narcotic Tutorial 0";
	}

	@Override
	public boolean hasWon() {
		return false;
	}

	@Override
	public void initialize() {
		initializeModel(getSeed());
		initializeView();
		
	}
	
	void initializeController() {
		
	}
	
	void initializeModel(int seed) {
		// initial score is set to ZERO (every Solitaire game by default has a score) 
		// and there are 52 cards left.

		numLeft = getNumLeft();
		numLeft.setValue(52);
		score = getScore();
		score.setValue(0);
	}
	
	void initializeView() {
		// Get the card artwork to be used. This is needed for the dimensions.
		CardImages ci = getCardImages();

		scoreView = new IntegerView(score);
		scoreView.setBounds(100 + 5 * ci.getWidth(), 20, 100, 60);
		addViewWidget(scoreView);

		numLeftView = new IntegerView(numLeft);
		numLeftView.setBounds(200 + 5* ci.getWidth(), 20, 100, 60);
		addViewWidget(numLeftView);
	}
	
	/** Code to launch solitaire variation. */
	public static void main (String []args) {
		// Seed is to ensure we get the same initial cards every time.
		GameWindow gw = Main.generateWindow(new NarcoticTutorial0(), 117);
		gw.setVisible(true);
	}

}
