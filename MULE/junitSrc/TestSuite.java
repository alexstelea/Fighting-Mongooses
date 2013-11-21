
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runner.Result;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * JUnit tests for the Map, the Pub, Random Events, Player Creation, and Buy Item.
 *
 * @author Alex Stelea
 * @author Geoving Gerard II
 * @aurhor Jackson Hair
 * @author Kennon Bittick
 * @author Tyler MacGrogan
 * @version 11 | 21 | 2013
 */
@RunWith(JUnit4.class)
public class TestSuite {

    /* done by Kennon Bittick */
    @Test
    public void testMap() {
        /* test the default map */
        Map map = new Map(1);
        assertNotNull("Map object", map);
        Tile[] tiles = map.getTiles();
        assertNotNull("Tiles in map", tiles);
        /* plain tiles */
        assertTrue("plain tile", tiles[0] instanceof PlainTile);
        assertTrue("plain tile", tiles[1] instanceof PlainTile);
        assertTrue("plain tile", tiles[3] instanceof PlainTile);
        assertTrue("plain tile", tiles[5] instanceof PlainTile);
        assertTrue("plain tile", tiles[7] instanceof PlainTile);
        assertTrue("plain tile", tiles[8] instanceof PlainTile);
        assertTrue("plain tile", tiles[9] instanceof PlainTile);
        assertTrue("plain tile", tiles[11] instanceof PlainTile);
        assertTrue("plain tile", tiles[12] instanceof PlainTile);
        assertTrue("plain tile", tiles[14] instanceof PlainTile);
        assertTrue("plain tile", tiles[15] instanceof PlainTile);
        assertTrue("plain tile", tiles[16] instanceof PlainTile);
        assertTrue("plain tile", tiles[19] instanceof PlainTile);
        assertTrue("plain tile", tiles[20] instanceof PlainTile);
        assertTrue("plain tile", tiles[21] instanceof PlainTile);
        assertTrue("plain tile", tiles[23] instanceof PlainTile);
        assertTrue("plain tile", tiles[24] instanceof PlainTile);
        assertTrue("plain tile", tiles[25] instanceof PlainTile);
        assertTrue("plain tile", tiles[27] instanceof PlainTile);
        assertTrue("plain tile", tiles[29] instanceof PlainTile);
        assertTrue("plain tile", tiles[30] instanceof PlainTile);
        assertTrue("plain tile", tiles[32] instanceof PlainTile);
        assertTrue("plain tile", tiles[34] instanceof PlainTile);
        assertTrue("plain tile", tiles[35] instanceof PlainTile);
        assertTrue("plain tile", tiles[36] instanceof PlainTile);
        assertTrue("plain tile", tiles[37] instanceof PlainTile);
        assertTrue("plain tile", tiles[39] instanceof PlainTile);
        assertTrue("plain tile", tiles[41] instanceof PlainTile);
        assertTrue("plain tile", tiles[42] instanceof PlainTile);
        assertTrue("plain tile", tiles[43] instanceof PlainTile);
        /* river tiles */
        assertTrue("river tile", tiles[4] instanceof RiverTile);
        assertTrue("river tile", tiles[13] instanceof RiverTile);
        assertTrue("river tile", tiles[31] instanceof RiverTile);
        assertTrue("river tile", tiles[40] instanceof RiverTile);
        /* town tile */
        assertTrue("town tile", tiles[22] instanceof TownTile);
        /* mountain tiles */
        assertTrue("mountain tile", tiles[2] instanceof MountainTile);
        assertTrue("mountan num", ((MountainTile)tiles[2]).getMountainNum() == 1);
        assertTrue("mountain tile", tiles[6] instanceof MountainTile);
        assertTrue("mountan num", ((MountainTile)tiles[6]).getMountainNum() == 3);
        assertTrue("mountain tile", tiles[10] instanceof MountainTile);
        assertTrue("mountan num", ((MountainTile)tiles[10]).getMountainNum() == 1);
        assertTrue("mountain tile", tiles[17] instanceof MountainTile);
        assertTrue("mountan num", ((MountainTile)tiles[17]).getMountainNum() == 3);
        assertTrue("mountain tile", tiles[18] instanceof MountainTile);
        assertTrue("mountan num", ((MountainTile)tiles[18]).getMountainNum() == 3);
        assertTrue("mountain tile", tiles[26] instanceof MountainTile);
        assertTrue("mountan num", ((MountainTile)tiles[26]).getMountainNum() == 1);
        assertTrue("mountain tile", tiles[28] instanceof MountainTile);
        assertTrue("mountan num", ((MountainTile)tiles[28]).getMountainNum() == 2);
        assertTrue("mountain tile", tiles[33] instanceof MountainTile);
        assertTrue("mountan num", ((MountainTile)tiles[33]).getMountainNum() == 2);
        assertTrue("mountain tile", tiles[38] instanceof MountainTile);
        assertTrue("mountan num", ((MountainTile)tiles[38]).getMountainNum() == 2);
        assertTrue("mountain tile", tiles[44] instanceof MountainTile);
        assertTrue("mountan num", ((MountainTile)tiles[44]).getMountainNum() == 2);

        /* test a random map */
        map = new Map(2);
        assertNotNull("Map object", map);
        tiles = map.getTiles();
        assertNotNull("Tiles in map", tiles);
        int numTownTiles = 0;
        int numPlainTiles = 0;
        int numRiverTiles = 0;
        int numMountain1Tiles = 0;
        int numMountain2Tiles = 0;
        int numMountain3Tiles = 0;
        int numExtraTiles = 0;

        for (Tile tile : tiles) {
            if (tile instanceof TownTile) 
                numTownTiles++;
            else if (tile instanceof PlainTile)
                numPlainTiles++;
            else if (tile instanceof RiverTile)
                numRiverTiles++;
            else if (tile instanceof MountainTile && ((MountainTile)tile).getMountainNum() == 1)
                numMountain1Tiles++;
            else if (tile instanceof MountainTile && ((MountainTile)tile).getMountainNum() == 2)
                numMountain2Tiles++;
            else if (tile instanceof MountainTile && ((MountainTile)tile).getMountainNum() == 3)
                numMountain3Tiles++;
            else
                numExtraTiles++;
        }
        
        assertEquals("num town tiles", numTownTiles, 1);
        assertTrue("num plain tiles", (numPlainTiles <= 33 && numPlainTiles >= 23));
        assertTrue("num river tiles", (numRiverTiles >= 9 && numRiverTiles <= 13));
        assertTrue("num mountain1 tiles", (numMountain1Tiles <= 4 && numMountain1Tiles >= 2));
        assertTrue("num mountain2 tiles", (numMountain2Tiles <= 4 && numMountain2Tiles >= 2));
        assertTrue("num mountain3 tiles", (numMountain3Tiles <= 4 && numMountain3Tiles >= 2));
        assertEquals("num extra tiles", numExtraTiles, 0);
    }

    /* done by Geoving Gerard */
    @Test
    public void testPub() {
    	ArrayList<Player> players = new ArrayList<Player>();
    	Player p1 = new Player("Player 1", "cat", "red", 1);
    	players.add(p1);
    	Player p2 = new Player("Player 2", "frog", "blue", 1);
    	players.add(p2);
    	Player p3 = new Player("Player 3", "human", "orange", 1);
    	players.add(p3);
    	Player p4 = new Player("Player 4", "squirrel", "pink", 1);
    	players.add(p4);
    	Player p5 = new Player("Player 5", "elephant", "green", 1);
    	players.add(p5);
    	
    	/* test Pub at beginning of all rounds for various time remaining */
    	for(int x = 0; x < 13; x++){
	    	Pub pub1 = new Pub(x, 50);
	    	Pub pub2 = new Pub(x, 30);
	    	Pub pub3 = new Pub(x, 5);
	    	Pub pub4 = new Pub(x, 0);
	    	Pub pub5 = new Pub(x, -5);
	    	assertNotNull("Pub w/ 50 seconds remaining: ", pub1);
	    	assertNotNull("Pub w/ 30 seconds remaining: ", pub2);
	    	assertNotNull("Pub w/ 5 seconds remaining: ", pub3);
	    	assertNotNull("Pub w/ 0 seconds remaining: ", pub4);

	    	/* test Gamble for all players */
	    	for(int y = 0; y < 5; y++){
	    		assertNotNull("Gamble w/ 50 seconds remaining: ", pub1.gamble(players, y));
	    		assertNotNull("Gamble w/ 30 seconds remaining: ", pub2.gamble(players, y));
	    		assertNotNull("Gamble w/ 5 seconds remaining: ", pub3.gamble(players, y));
	    		assertNotNull("Gamble w/ 0 seconds remaining: ", pub4.gamble(players, y));
	    	}
	    }
    }

    /* Done by Alex Stelea */
   @Test
   public void testRandomEvent(){
    Player player = new Player("Alex", "elephant", "blue", 2);
    Player player2 = new Player("John", "elephant", "red", 2);

    ArrayList<Player> players = new ArrayList<Player>();
    players.add(player);
    players.add(player2);

    Boolean randomEventOccured = false;
    for (int i = 0; i < 13; i++){
        
        RandomEvents r1 = new RandomEvents(i);
        String returnString = r1.generate(players, 1, 10);
        if (returnString != null){
            assertNotNull("Random event after round" +i, returnString);
            randomEventOccured = true;
        }
    }
    assertTrue("A random event occured in the game", randomEventOccured);

   }
   
	/* done by Jackson Hair */
	@Test
    public void testPlayerCreation() {
        Player p1 = new Player("Jackson", "elephant", "blue", 2);
        assertNotNull("Normal Player Creation", p1);
        //wrong color
        p1 = null;
        try {
        p1 = new Player("Jackson", "elephant", "yellow", 2);
        } catch (IllegalArgumentException e) {}
        assertNull("Incorrect Color", p1);
        //wrong race
        p1 = null;
        try {
        p1 = new Player("Jackson", "dragon", "blue", 2);
        } catch (IllegalArgumentException e) {}
        assertNull("Incorrect Race", p1);
        //short name
        p1 = null;
        try {
        p1 = new Player("J", "elephant", "blue", 2);
        } catch (IllegalArgumentException e) {}
        assertNull("Name Too Short", p1);
        //long name
        p1 = null;
        try {
        p1 = new Player("Jacksonjacksonjacksonjackson", "elephant", "blue", 2);
        } catch (IllegalArgumentException e) {}
        assertNull("Name Too Long", p1);
        //0 difficulty
        p1 = null;
        try {
        p1 = new Player("Jackson", "elephant", "blue", 0);
        } catch (IllegalArgumentException e) {}
        assertNull("Incorrect difficulty", p1);
        //4 difficulty
        p1 = null;
        try {
        p1 = new Player("Jackson", "elephant", "blue", 4);
        } catch (IllegalArgumentException e) {}
        assertNull("Incorrect difficulty", p1);
        //wrong color
        p1 = null;
        try {
        p1 = new Player("Jackson", "elephant", null, 2);
        } catch (NullPointerException e) {}
        assertNull("Incorrect Color", p1);
        //wrong race
        p1 = null;
        try {
        p1 = new Player("Jackson", null, "blue", 2);
        } catch (NullPointerException e) {}
        assertNull("Incorrect Race", p1);
        //short name
        p1 = null;
        try {
        p1 = new Player(null, "elephant", "blue", 2);
        } catch (NullPointerException e) {}
        assertNull("Name Too Short", p1);
        //long name
        p1 = null;
        try {
        p1 = new Player(null, "elephant", "blue", 2);
        } catch (NullPointerException e) {}
        assertNull("Name Too Long", p1);
    }
	
	/* done by Tyler MacGrogan */
	@Test
	public void testBuyItem() {
		Player p1 = new Player("player1", "human", "red", 2);
		Player p2 = new Player("player2", "elephant", "blue", 2);
		ArrayList<Player> pList = new ArrayList<Player>();
		pList.add(p1);
		pList.add(p2);
		Store store = new Store(2);
		String result = store.buyItem(pList, 0, "food", 2);
		assertEquals("P1 food", pList.get(0).getFood(), 6);
		assertEquals("P1 money", pList.get(0).getMoney(), 540);
		result = store.buyItem(pList, 0, "food", 7);
		assertEquals("not enough food in stock", result, "noBuy");
		pList.get(0).setMoney(0);
		result = store.buyItem(pList, 0, "food", 1);
		assertEquals("not enough money for food", result, "noFunds");
	}
}
