package Osmosis;

import heineman.klondike.DealCardMove;
import junit.framework.TestCase;
import ks.client.gamefactory.GameWindow;
import ks.common.model.Card;
import ks.common.model.Deck;
import ks.common.model.Pile;
import ks.launcher.Main;

public class Tests extends TestCase{
	
	GameWindow gw;
	Osmosis osmo;

	protected void setUp()
	{		
		osmo = new Osmosis();
		GameWindow gw = Main.generateWindow(osmo, Deck.OrderBySuit);
	}
	
	
	public void testOsmosis()
	{
		//gw.setVisible(true);
		
		//Osmosis.
		//assertEquals();
		
		DealMove testDeal = new DealMove(osmo.deck, osmo.hand);

		assertTrue (osmo.hand.empty());
		assertTrue (testDeal.valid(osmo));
		assertTrue (testDeal.doMove(osmo));
		assertTrue (testDeal.undo(osmo));
		assertTrue (osmo.hand.empty());

		ReserveToFoundationMove testMove1 = new ReserveToFoundationMove(osmo, osmo.pile1);
		ReserveToFoundationMove testMove2 = new ReserveToFoundationMove(osmo, osmo.pile2);
		ReserveToFoundationMove testMove3 = new ReserveToFoundationMove(osmo, osmo.pile3);
		ReserveToFoundationMove testMove4 = new ReserveToFoundationMove(osmo, osmo.pile4);
		
		HandToFoundationMove testHandMove1 = new HandToFoundationMove(osmo, osmo.hand);
		

		assertTrue (testMove1.valid(osmo));
		assertTrue (testMove1.doMove(osmo));
		assertTrue (testMove1.undo(osmo));
		assertTrue (testMove1.doMove(osmo));
		assertTrue (testMove1.doMove(osmo));
		assertTrue (testMove1.doMove(osmo));
		assertTrue (testMove1.doMove(osmo));
		assertEquals ((testMove1.doMove(osmo)), false);
		
		assertTrue (testMove2.valid(osmo));
		assertTrue (testMove2.doMove(osmo));
		assertTrue (testMove2.doMove(osmo));
		assertTrue (testMove2.doMove(osmo));
		assertTrue (testMove2.doMove(osmo));
		assertEquals ((testMove2.doMove(osmo)), false);
		
		assertTrue (testDeal.doMove(osmo));
		assertEquals(testHandMove1.allowedToPlaceIntoFoundation(osmo, osmo.pile1), false);
		assertEquals(testHandMove1.allowedToPlaceIntoFoundation(osmo, osmo.pile2), false);
		assertEquals(testHandMove1.allowedToPlaceIntoFoundation(osmo, osmo.pile3), true);
		assertEquals(testHandMove1.allowedToPlaceIntoFoundation(osmo, osmo.pile4), false);
		assertEquals(testHandMove1.allowedToMakeHandFoundationMove(osmo), false);
		assertFalse (testHandMove1.doMove(osmo));
		assertEquals(osmo.pile1.count(), 0);
		assertTrue (testDeal.undo(osmo));

		assertTrue (testMove3.valid(osmo));
		assertTrue (testMove3.doMove(osmo));
		assertTrue (testMove3.doMove(osmo));
		assertTrue (testMove3.doMove(osmo));
		assertTrue (testMove3.doMove(osmo));
		assertEquals ((testMove3.doMove(osmo)), false);

		assertTrue (testMove4.valid(osmo));
		assertTrue (testMove4.doMove(osmo));
		assertTrue (testMove4.doMove(osmo));
		assertTrue (testMove4.doMove(osmo));
		assertTrue (testMove4.doMove(osmo));
		assertEquals ((testMove4.doMove(osmo)), false);

		assertTrue(osmo.pile1.empty());
		assertTrue(osmo.pile2.empty());
		assertTrue(osmo.pile3.empty());
		assertTrue(osmo.pile4.empty());

		assertTrue (testDeal.doMove(osmo));
		assertTrue(testHandMove1.valid(osmo));
		
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.undo(osmo));
		assertTrue (testHandMove1.doMove(osmo));		
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testDeal.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testDeal.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testDeal.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testDeal.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testDeal.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testDeal.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testDeal.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		

		assertEquals(testHandMove1.allowedToMakeHandFoundationMove(osmo), true);
		

		
		assertTrue (testDeal.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testDeal.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		

		assertTrue (testDeal.doMove(osmo));
		assertTrue (testDeal.doMove(osmo));
		assertTrue (testDeal.doMove(osmo));
		assertTrue (testDeal.doMove(osmo));
		assertTrue (testDeal.doMove(osmo));
		assertTrue (testDeal.doMove(osmo));
		assertTrue (testDeal.undo(osmo));
		assertTrue (testDeal.doMove(osmo));
		assertTrue (testDeal.doMove(osmo));
		
		assertTrue(osmo.hand.empty());


		assertEquals(testHandMove1.allowedToMakeHandFoundationMove(osmo), true);
		assertEquals(testHandMove1.allowedToPlaceIntoFoundation(osmo, osmo.pile1), false);
		assertEquals(testHandMove1.allowedToPlaceIntoFoundation(osmo, osmo.pile2), false);
		assertEquals(testHandMove1.allowedToPlaceIntoFoundation(osmo, osmo.pile3), false);
		assertEquals(testHandMove1.allowedToPlaceIntoFoundation(osmo, osmo.pile4), false);
		

		assertTrue (testDeal.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));

		assertTrue (testDeal.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		assertTrue (testHandMove1.doMove(osmo));
		
		assertTrue(osmo.hand.empty());
		

		
	}
}
