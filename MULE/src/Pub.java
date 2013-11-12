import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;

/**
 * Pub is where a player can gamble, a way to get a money bonus for unused time in their turn. 
 * The formula is: Money Bonus = Round Bonus * random between 0 and Time Bonus. [---error?]
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
	private int buyingRand = rand.nextInt(101) + 1; //101 exclusive
	private int roundBonus;
	private int timeBonus;
	
	/**
	 * Pub sets roundBonus and timeBonus
	 * @param getRoundNumber gets current round number
	 * @param time gets current time
	 */
	public Pub(int getRoundNumber, int timeRemaining){
		if(getRoundNumber < 4){
			this.roundBonus = 50;
		}
		else if((getRoundNumber > 3) && (getRoundNumber < 8)){
			this.roundBonus = 100;
		}
		else if((getRoundNumber > 7) && (getRoundNumber < 12)){
			this.roundBonus = 150;
		}
		else if(getRoundNumber > 11){
			this.roundBonus = 200;
		}

		if((timeRemaining > 37) && (timeRemaining < 51)){
			this.timeBonus = 200;
		}
		else if((timeRemaining > 25) && (timeRemaining < 37)){
			this.timeBonus = 150;
		}
		else if((timeRemaining > 12) && (timeRemaining < 25)){
			this.timeBonus = 100;
		}
		else if((timeRemaining > 0) && (timeRemaining < 12)){
			this.timeBonus = 50;
		} else {
			this.timeBonus = 1;
		}
	}

	/**
	 * Player gambles. Adds winnings to player's money.
	 * @param players ArrayList contaning all players
	 * @param currPlayer The current player
	 */
	public String gamble(ArrayList<Player> players, int currPlayer){
		int abs = Math.abs(timeBonus);
		int bonusRand = rand.nextInt(abs);
		int playerValue = (int)players.get(currPlayer).getMoney();
		int moneyBonus = roundBonus + bonusRand;
		if(moneyBonus < 251){
			players.get(currPlayer).setMoney(playerValue + moneyBonus);
			int newPlayerValue = (int)players.get(currPlayer).getMoney();
			return "Player made " + (newPlayerValue - playerValue) + " dollars gambling.";
		}
		else{
			players.get(currPlayer).setMoney(playerValue + 250);
			return "Player made " + (250) + " dollars gambling.";
		}
	}


}