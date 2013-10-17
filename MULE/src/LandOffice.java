import java.util.Random;

public class LandOffice{
/*
The land office buys and sells property. If a player wishes to sell a property 
during their turn, they may enter the land office and offer a property to sell. 
If a mule is on the property when sold, it is lost. The selling price is 400 + random(0-200). 
You may also buy property if any is available from the land office. The buying price is 300 + round * random(0-100).
*/

private Random rand = new Random();
private int propertyPrice;
private int buyingPrice;
private int low = 0;
private int shigh = 200;
private int bhigh = 100;
private int sellingRand = rand.nextInt(shigh-low);
private int buyingRand = rand.nextInt(bhigh-low);

	public LandOffice(int getRoundNumber){
		if(getRoundNumber <= 2){
			this.propertyPrice = 0;
		}
		if(getRoundNumber > 2){
			this.propertyPrice  = 300 + (getRoundNumber * buyingRand);
		}
	}

/**
 * Setter method for the buying property price
 * @param propertyPrice The new property price
 */
public void setBuyingPrice(int buyingPrice) {
    this.buyingPrice = buyingPrice;
}

/**
 * Setter method for the property price
 * @param propertyPrice The new property price
 */
public void setPropertyPrice(int propertyPrice) {
    this.propertyPrice = propertyPrice;
}



}