import java.util.Random;

public class LandOffice{
/*
The land office buys and sells property. If a player wishes to sell a property 
during their turn, they may enter the land office and offer a property to sell. 
If a mule is on the property when sold, it is lost. The selling price is 400 + random(0-200). 
You may also buy property if any is available from the land office. The buying price is 300 + round * random(0-100).
*/

private Random rand = new Random();
private int low = 0;
private int high = 200;
private int value = rand.nextInt(high-low) + low; 
//random number between 10 (inclusive) and 100 (exclusive)


private int freeProperty;
private int propertyPrice = 400 + value;

	public LandOffice(){


	}


}