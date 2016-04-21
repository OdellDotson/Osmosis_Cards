package Osmosis;

import ks.common.games.Solitaire;
import ks.common.model.Column;
import ks.common.model.Deck;
import ks.common.model.Move;
import ks.common.model.Pile;
import ks.common.view.*;

public class OsmosisHandController extends java.awt.event.MouseAdapter {

	protected Osmosis osmosisGame = null;
    FanPileView handView;

    public OsmosisHandController(Osmosis game, FanPileView handView) {
        super();

        osmosisGame = game;
        this.handView = handView;
    }
    
    /**
     * On mouse Press for now, we simply delete top card. 
     * 
     * @param me     low-level mouse event
     */
    
    public void mousePressed(java.awt.event.MouseEvent me) {
//    	// Original controller
		//handView.redraw();      
		
    	System.out.println("Clicked the hand.");
		 //Pile f = (Pile) osmosisGame.getModelElement("hand");
	    Column h = (Column) osmosisGame.getModelElement("hand");
	    
	    
        Move m = new HandToFoundationMove(osmosisGame,h);
        if (m.doMove(osmosisGame)) {
            // SUCCESS: have solitaire game store this move
        	osmosisGame.pushMove(m);

            // have solitaire game refresh widgets that were affected 
        	osmosisGame.refreshWidgets();
        }
        else
        	System.out.println("Messed UP");
    }
}
