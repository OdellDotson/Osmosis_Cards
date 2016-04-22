package Osmosis;

import ks.common.games.Solitaire;
import ks.common.model.Column;
import ks.common.model.Deck;
import ks.common.model.Move;
import ks.common.model.Pile;

public class DealController extends java.awt.event.MouseAdapter {
    /** The narcotic instance. */
    protected Osmosis osmosisGame = null;

    /** NarcoticDeckController constructor comment. */
    public DealController(Osmosis game) {
        super();
        osmosisGame = game;
    }
    


	/**
     * A MousePressed event on the DeckView is a signal to deal the next
     * set of cards (if the deck is nonempty).
     *
     * @param me     low-level mouse event
     */
    public void mousePressed(java.awt.event.MouseEvent me) {

        // Find the deck from our model
        Deck d = (Deck) osmosisGame.getModelElement("deck");
        Column h = (Column) osmosisGame.getModelElement("hand");

        // Deal 3 cards or remaining, or if empty move hand back to deck.
        Move m = new DealMove(d, h);
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