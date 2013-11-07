import java.util.Random;
import java.util.ArrayList;

/**
 * Land Office buys and sells property. If a player wishes to sell a property 
 * during their turn, they may enter the land office and offer a property to sell. 
 * If a mule is on the property when sold, it is lost. 
 * The selling price is 400 + random(0-200). 
 * 
 * You may also buy property if any is available from the land office. 
 * The buying price is 300 + round * random(0-100).
 *
*/

public class LandOffice{

	private Random rand = new Random();
	private int buyingRand = rand.nextInt(100) + 1;
	private int playerValue;
	private int buyingPrice;

	/**
	 * Land office sets buying price
	 * @param getRoundNumber gets current round number
	 */
	public LandOffice(int getRoundNumber){
		if(getRoundNumber < 3){
			this.buyingPrice = 0;
		}
		if(getRoundNumber > 2){
			this.buyingPrice = 300 + (getRoundNumber * buyingRand);;
		}
	}

	/**
	 * Player purchases property from Land Office. Subtracts land cost from player's money
	 * @param players ArrayList contaning all players
	 * @param currPlayer The current player
	 * @param tileSelection The tile current player selected
	 * @param map Used to set owner of tile to currPlayer
	 */
	public boolean buyProperty(int tileSelection, ArrayList<Player> players, int currPlayer, Map map){

		System.out.println("BuyingRand: " + buyingRand);
		System.out.println("Buying Price: " + buyingPrice);

		playerValue = (int)players.get(currPlayer).getMoney();
		if((playerValue - buyingPrice) >= 0){
				players.get(currPlayer).setMoney(playerValue - buyingPrice);
				map.setOwnerOfTile(tileSelection, players.get(currPlayer));
                return true;
		}
		else{
			System.out.println("Player does not have sufficient funds.");
            return false;
		}
	}

	/**
	 * Player sells property to Land Office. Adds land price to player's money.
	 * @param players ArrayList contaning all players
	 * @param currPlayer The current player
	 * @param tileSelection The tile current player selected
	 * @param map Used to set owner of tile to currPlayer
	 */
	public void sellingProperty(int tileSelection, ArrayList<Player> players, int currPlayer, Map map){
		int sellingRand = rand.nextInt(200) +1;
		int sellingPrice = 400 + sellingRand;
		playerValue = (int)players.get(currPlayer).getMoney();
		players.get(currPlayer).setMoney(playerValue + sellingPrice);
		map.setOwnerOfTile(tileSelection, null);
		if(map.getTiles()[tileSelection].hasMule = true){
			map.getTiles()[tileSelection].removeMule();
		}
	}
}
