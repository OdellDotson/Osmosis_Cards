package Osmosis;

import ks.common.model.Move;
import ks.common.model.Pile;
import ks.common.view.*;

public class ReserveController extends java.awt.event.MouseAdapter {
    /** The Osmosis instance. */
    protected Osmosis osmosisGame = null;
    
    /** The PileView widget being controlled. */
    PileView pileview;
    Pile reserve;

    /** NarcoticDeckController constructor comment. */
    public ReserveController(Osmosis game, PileView pileview, Pile reserve) {
        super();

        osmosisGame = game;
        this.pileview = pileview;
        this.reserve = reserve;
    }
    
    /**
     * On mouse Press for now, we simply delete top card. 
     * 
     * @param me     low-level mouse event
     */
    public void mousePressed(java.awt.event.MouseEvent me) {

    	//System.out.println("Clicked a reserve.");
		 //Pile f = (Pile) osmosisGame.getModelElement("hand");
	    //Pile h = (Pile) osmosisGame.getModelElement("hand");
	    
	 
    }
    
    public void mouseReleased(java.awt.event.MouseEvent me)
    {
        
        Move m = new ReserveToFoundationMove(osmosisGame,reserve);
        if (m.doMove(osmosisGame)) {
            // SUCCESS: have solitaire game store this move
        	osmosisGame.pushMove(m);

            // have solitaire game refresh widgets that were affected 
        	osmosisGame.refreshWidgets();
        }
        
        else{}
        //System.out.println("Reserve controller messed UP");
 		
     	
     	
 		pileview.redraw();       
    }
}
