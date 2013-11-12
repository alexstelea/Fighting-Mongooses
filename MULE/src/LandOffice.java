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
	private int propertyOwned;

	/**
	 * Land office sets buying price
	 * @param propertyOwned gets number of property player owns
	 * @param getRoundNumber gets current round number
	 */
	public LandOffice(int propertyOwned, int getRoundNumber){
		if(propertyOwned > 1){
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
		playerValue = (int)players.get(currPlayer).getMoney();
		propertyOwned = (int)players.get(currPlayer).getPropertyOwned();

		if((playerValue - buyingPrice) >= 0){
				players.get(currPlayer).setMoney(playerValue - buyingPrice);
				map.setOwnerOfTile(tileSelection, players.get(currPlayer));
				players.get(currPlayer).setPropertyOwned(propertyOwned + 1);
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
	public boolean sellingProperty(int tileSelection, ArrayList<Player> players, int currPlayer, Map map){
		if(map.getOwnerOfTile(tileSelection) != null){
			int sellingRand = rand.nextInt(200) + 1;
			int sellingPrice = 400 + sellingRand;
			playerValue = (int)players.get(currPlayer).getMoney();
			propertyOwned = (int)players.get(currPlayer).getPropertyOwned();
			//Should remove flag from tile.
			map.setOwnerOfTile(tileSelection, null);
			System.out.println("owner: " + map.getOwnerOfTile(tileSelection));
			players.get(currPlayer).setMoney(playerValue + sellingPrice);
			players.get(currPlayer).setPropertyOwned(propertyOwned - 1);
			if(map.getTiles()[tileSelection].hasMule = true){
				map.getTiles()[tileSelection].removeMule();
			}
			return true;
		}
		else{
			return false;
		}
	}
}
