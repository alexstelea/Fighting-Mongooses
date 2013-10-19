import java.util.ArrayList;

/**
 * Store allows player to purchase things. The store has a limited 
 * quantity of things, and will run out unless players sell products 
 * to the store. MULE's are produced by ore, so if no one sells 
 * ore to the store, then no mules can be produced after the initial 
 * amount are sold.
 * 
 * To buy something, the player enters the store during their turn 
 * and is presented with a menu of items to buy. The player may buy 
 * whatever they like subject to them having enough money to purchase 
 * the item. If you have a mule, you cannot buy another until you 
 * emplace the one you have.
 *
 * When a Mule is purchased, it must also be configured, so the following fees are added to the base price.
 * So an energy mule would cost 100 + 50 = 150.
*/

public class Store {

	private int foodQuantity;
	private int energyQuantity;
	private	int smithoreQuantity;
	private	int crystiteQuantity;
	private int mulesQuantity;

	private int foodPrice = 30;
	private int energyPrice = 25;
	private	int smithorePrice = 50;
	private	int crystitePrice = 100; 
	private int mulesPrice = 100;

	private int foodFee = 25;
	private int energyFee = 50;
	private	int smithoreFee = 75;
	private	int crystiteFee = 100;

    private int costOfPurchases;

    /**
     * Store sets initial quanitity based on difficulty
     * @param getDifficulty gets current game difficulty
     */
	public Store(int getDifficulty){
		if (getDifficulty == 1) {
			this.foodQuantity = 16;
			this.energyQuantity = 16;
			this.smithoreQuantity = 0;
			this.crystiteQuantity = 0;
			this.mulesQuantity = 25;
		}
		if ((getDifficulty == 2) || (getDifficulty == 3)) {
			this.foodQuantity = 8;
			this.energyQuantity = 8;
			this.smithoreQuantity = 8;
			this.crystiteQuantity = 0;
			this.mulesQuantity = 14;
		}
	}

    /**
     * Player purchases. Subtracts purchase from player's money.
     * @param players ArrayList contaning all players
     * @param currPlayer The current player
     */
    private void purchaseItem(ArrayList<Player> players, int currPlayer){
        int playerValue = (int)players.get(currPlayer).getMoney();
        if((playerValue - costOfPurchases) > 0){
            players.get(currPlayer).setMoney(playerValue - costOfPurchases);
        }
        else{
            System.out.println("Do not have sufficient funds");
        }
    }

    /**
     * Getter method for the store's food quantity
     *
     * @return The store's food quantity
     */
    public int getFoodQuantity() {
        return foodQuantity;
    }

    /**
     * Getter method for the store's energy quantity
     *
     * @return The store's energy quantity
     */
    public int getEnergyQuantity() {
        return energyQuantity;
    }

    /**
     * Getter method for the store's smithore quantity
     *
     * @return The store's smithore quantity
     */
    public int getSmithoreQuantity() {
        return smithoreQuantity;
    }

   	/**
     * Getter method for the store's crystite quantity
     *
     * @return The store's crystite quantity
     */
    public int getCrystiteQuantity() {
        return crystiteQuantity;
    }

    /**
     * Getter method for the store's mules quantity
     *
     * @return The store's mules quantity
     */
    public int getMulesQuantity() {
        return mulesQuantity;
    }

    /**
     * Getter method for the store's food price
     *
     * @return The store's food price
     */
    public int getFoodPrice() {
        return foodPrice;
    }

    /**
     * Getter method for the store's energy price
     *
     * @return The store's energy price
     */
    public int getEnergyPrice() {
        return energyPrice;
    }

    /**
     * Getter method for the store's smithore price
     *
     * @return The store's smithore price
     */
    public int getSmithorePrice() {
        return smithorePrice;
    }

   	/**
     * Getter method for the store's crystite price
     *
     * @return The store's crystite price
     */
    public int getCrystitePrice() {
        return crystitePrice;
    }

    /**
     * Getter method for the store's mules price
     *
     * @return The store's mules price
     */
    public int getMulesPrice() {
        return mulesPrice;
    }

    /**
     * Getter method for the store's food fee
     *
     * @return The store's food fee
     */
    public int getFoodFee() {
        return foodFee;
    }

    /**
     * Getter method for the store's energy fee
     *
     * @return The store's energy fee
     */
    public int getEnergyFee() {
        return energyFee;
    }

    /**
     * Getter method for the store's smithore fee
     *
     * @return The store's smithore fee
     */
    public int getSmithoreFee() {
        return smithoreFee;
    }

   	/**
     * Getter method for the store's crystite fee
     *
     * @return The store's crystite fee
     */
    public int getCrystiteFee() {
        return crystiteFee;
    }

    /**
     * Setter method for the store's food quantity
     *
     * @param foodQuantity The store's new food quantity
     */
    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    /**
     * Setter method for the store's energy quantity
     *
     * @param energyQuantity The store's new energy quantity
     */
    public void setEnergyQuantity(int energyQuantity) {
        this.energyQuantity = energyQuantity;
    }

    /**
     * Setter method for the store's smithore quantity
     *
     * @param smithoreQuantity The store's new smithore quantity
     */
    public void setSmithoreQuantity(int smithoreQuantity) {
        this.smithoreQuantity = smithoreQuantity;
    }

    /**
     * Setter method for the store's crystite quantity
     *
     * @param crystiteQuantity The store's new crystite equantity
     */
    public void setCrystiteQuantity(int crystiteQuantity) {
        this.crystiteQuantity = crystiteQuantity;
    }

    /**
     * Setter method for the store's mules quantity
     *
     * @param mulesQuantity The store's new mules quantity
     */
    public void setMulesQuantity(int mulesQuantity) {
        this.mulesQuantity = mulesQuantity;
    }

    /**
     * Setter method for the store's food price
     *
     * @param foodPrice The store's new food price
     */
    public void setFoodPrice(int foodPrice) {
        this.foodPrice = foodPrice;
    }

    /**
     * Setter method for the store's energy price
     *
     * @param energyPrice The store's new energy price
     */
    public void setEnergyPrice(int energyPrice) {
        this.energyPrice = energyQuantity;
    }

    /**
     * Setter method for the store's smithore price
     *
     * @param smithorePrice The store's new smithore price
     */
    public void setSmithorePrice(int smithorePrice) {
        this.smithorePrice = smithorePrice;
    }

    /**
     * Setter method for the store's crystite price
     *
     * @param crystitePrice The store's new crystite eprice
     */
    public void setCrystitePrice(int crystitePrice) {
        this.crystitePrice = crystitePrice;
    }

    /**
     * Setter method for the store's mules price
     *
     * @param mulesPrice The store's new mules price
     */
    public void setMulesPrice(int mulesPrice) {
        this.mulesPrice = mulesPrice;
    }
}