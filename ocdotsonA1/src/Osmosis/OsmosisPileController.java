package Osmosis;

import ks.common.games.Solitaire;
import ks.common.view.*;

public class OsmosisPileController extends java.awt.event.MouseAdapter {
    /** The Osmosis instance. */
    protected Solitaire osmosisGame = null;
    
    /** The PileView widget being controlled. */
    PileView pileview;

    /** NarcoticDeckController constructor comment. */
    public OsmosisPileController(Solitaire game, PileView pileview) {
        super();

        osmosisGame = game;
        this.pileview = pileview;
    }
    
    /**
     * On mouse Press for now, we simply delete top card. 
     * 
     * @param me     low-level mouse event
     */
    public void mousePressed(java.awt.event.MouseEvent me) {
//    	// Original controller
//    	// get the element backing the view widget
//        Pile pile = (Pile) pileview.getModelElement();
//
//        // delete its top card.
//        Card c = pile.get();
//        System.out.println ("Removed " + c);
//        
//        // have solitaire game refresh widgets that were affected 
//        narcoticGame.refreshWidgets();
        
    	// Revised controller. Comment out the above code, and instead insert this
    	
		// Ask PileView to retrieve the top card as a CardView
		// Widget
		CardView cardView = pileview.getCardViewForTopCard(me);

		// Have container track this object now. Record where it came from
		Container c = osmosisGame.getContainer();
		c.setActiveDraggingObject (cardView, me);
		c.setDragSource(pileview);

		// we simply redraw our source pile to avoid flicker,
		// rather than refreshing all widgets...
		pileview.redraw();        
    }
}
