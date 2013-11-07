import java.util.ArrayList;
import java.util.Random;

/**
 * Each turn there is a chance that a random event will happen. Each round, a player has a 
 * 27% chance that a random event will happen. No bad event can happen to the player with the 
 * lowest score.
 *
 * Some events require a price calculation. This is dependent on a factor m. 
 * m is determined by what round the game is in. 
 * Round	1	2	3	4	5	6	7	8	9	10	11	12 
 * m	    25	25	25	50	50	50	50 75	75	75	75	100
 *
 * If an event does happen, then one of the following events is chosen:
 *
 * YOU JUST RECEIVED A PACKAGE FROM THE GT ALUMNI CONTAINING 3 FOOD AND 2 ENERGY UNITS.
 * A WANDERING TECH STUDENT REPAID YOUR HOSPITALITY BY LEAVING TWO BARS OF ORE.
 * THE MUSEUM BOUGHT YOUR ANTIQUE PERSONAL COMPUTER FOR $8*m.
 * YOU FOUND A DEAD MOOSE RAT AND SOLD THE HIDE FOR $2*m.
 * FLYING CAT-BUGS ATE THE ROOF OFF YOUR HOUSE. REPAIRS COST $4*m.
 * MISCHIEVOUS UGA STUDENTS BROKE INTO YOUR STORAGE SHED AND STOLE HALF YOUR FOOD.
 * YOUR SPACE GYPSY INLAWS MADE A MESS OF THE TOWN. IT COST YOU $6*m TO CLEAN IT UP.
 */

public class RandomEvents{

	private Random rand = new Random();
	private int m;

	/**
	 * RandomEvents sets factor m.
	 * @param roundNumber gets current round number
	 */
	public RandomEvents(int roundNumber){
		if(roundNumber < 4){
			this.m = 25;
		}
		else if((roundNumber > 3) && (roundNumber < 8)){
			this.m = 50;
		}
		else if((roundNumber > 7) && (roundNumber < 11)){
			this.m = 50;
		}
		else{
			this.m = 100;
		}
	}

	/**
	 * Generates random event.
	 * @param players ArrayList contaning all players
	 * @param currPlayer The current player
	 * @param limit Determines if event good or good/bad.
	 */
	public void generate(ArrayList<Player> players, int currPlayer, int limit){
		int playerSmithore = (int)players.get(currPlayer).getSmithore();
		int playerEnergy = (int)players.get(currPlayer).getEnergy();
		int playerValue = (int)players.get(currPlayer).getMoney();
		int playerFood = (int)players.get(currPlayer).getFood();
		int eventRand = rand.nextInt(limit);
		int inlawsRepair = 6*m;
		int catRepair = 4*m;
		int pcBonus = 8*m;
		
		if(eventRand == 0){
			System.out.println("You just received a package from the GT Alumni containing 3 Food and 2 Energy units.");
			players.get(currPlayer).setFood(playerFood + 3);
			players.get(currPlayer).setEnergy(playerEnergy+ 2);
		}
		else if(eventRand == 1){
			System.out.println("A wandering Tech student repaid your hospitality by leaving 2 bars of Smithore.");
			players.get(currPlayer).setSmithore(playerSmithore + 2);
		}
		else if(eventRand == 2){
			System.out.println("The museum bought your antique laptop for $" + pcBonus + ".");
			players.get(currPlayer).setMoney(playerValue + pcBonus);
		}
		else if(eventRand == 3){
			System.out.println("Flying cat-bugs ate the roof off your house. Repair costs $" + catRepair + ".");
			players.get(currPlayer).setMoney(playerValue - catRepair);
		}
		else if(eventRand == 4){
			System.out.println("UGA students broke into your storage shed and stole half of your Food.");
			players.get(currPlayer).setFood(playerFood / 2);
		}
		else if(eventRand == 5){
			System.out.println("Your gypsy in-laws made a mess of the Town. It cost you $" + inlawsRepair + " to clean it up.");
			players.get(currPlayer).setMoney(playerValue - inlawsRepair);
		}	
	}
}