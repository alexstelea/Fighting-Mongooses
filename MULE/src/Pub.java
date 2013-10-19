import java.util.Random;
import java.util.ArrayList;

/**
 * Pub is where a player can gamble, a way to get a money bonus for unused time in their turn. 
 * The formula is: Money Bonus = Round Bonus * random between 0 and Time Bonus.
 *
 * The Round Bonus is given by:
 * Round 1	2  3  4	  5	  6   7	  8	  9	  10  11  12
 * Cash	 50	50 50 100 100 100 100 150 150 150 150 200
 * 
 * The Time bonus is computed by: 
 * 37-50 seconds left : 200 
 * 25-37 seconds left : 150 
 * 12-25 seconds left : 100 
 * 0-12 seconds left : 50
 * 
 * You cannot earn more than 250 by gambling.
*/

public class Pub{

	private Random rand = new Random();
	private int roundBonus;
	private int timeBonus;
	private int bonusRand = rand.nextInt(timeBonus);
	private int moneyBonus = roundBonus * bonusRand;

	/**
	 * Pub sets roundBonus and timeBonus
	 * @param getRoundNumber gets current round number
	 * @param time gets current time
	 */
	public Pub(int getRoundNumber, int time){
		if(getRoundNumber < 4){
			roundBonus = 50;
		}
		if((getRoundNumber > 3) && (getRoundNumber < 8)){
			roundBonus = 100;
		}
		if((getRoundNumber > 7) && (getRoundNumber < 12)){
			roundBonus = 150;
		}
		if(getRoundNumber > 11){
			roundBonus = 200;
		}
		if((time >= 37) && (time <= 50)){
			timeBonus = 200;
		}
		if((time >= 25) && (time <= 36)){
			timeBonus = 150;
		}
		if((time >= 12) && (time <= 24)){
			timeBonus = 100;
		}
		if((time >= 0) && (time <= 11)){
			timeBonus = 50;
		}
	}

	/**
	 * Player gambles. Adds winnings to player's money.
	 * @param players ArrayList contaning all players
	 * @param currPlayer The current player
	 */
	private void gamble(ArrayList<Player> players, int currPlayer){
		int playerValue = (int)players.get(currPlayer).getMoney();
		if(moneyBonus < 251){
			players.get(currPlayer).setMoney(playerValue + moneyBonus);
		}
	}


}