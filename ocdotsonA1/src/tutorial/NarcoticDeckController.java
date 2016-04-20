package tutorial;

import ks.common.games.Solitaire;
import ks.common.model.Deck;
import ks.common.model.Move;
import ks.common.model.Pile;
import v2.DealFourMove;

public class NarcoticDeckController extends java.awt.event.MouseAdapter {
    /** The narcotic instance. */
    protected Solitaire narcoticGame = null;

    /** NarcoticDeckController constructor comment. */
    public NarcoticDeckController(Solitaire game) {
        super();

        narcoticGame = game;
    }
    


	/**
     * A MousePressed event on the DeckView is a signal to deal the next
     * set of cards (if the deck is nonempty).
     *
     * @param me     low-level mouse event
     */
    public void mousePressed(java.awt.event.MouseEvent me) {

        // Find the deck from our model
        Deck d = (Deck) narcoticGame.getModelElement("deck");
        Pile p1 = (Pile) narcoticGame.getModelElement("pile1");
        Pile p2 = (Pile) narcoticGame.getModelElement("pile2");
        Pile p3 = (Pile) narcoticGame.getModelElement("pile3");
        Pile p4 = (Pile) narcoticGame.getModelElement("pile4");

        if (!d.empty()) {
            // Deal four cards
            Move m = new DealFourMove(d, p1, p2, p3, p4);
            if (m.doMove(narcoticGame)) {
                // SUCCESS: have solitaire game store this move
                narcoticGame.pushMove(m);

                // have solitaire game refresh widgets that were affected 
                narcoticGame.refreshWidgets();
            }
        }
    }
}
