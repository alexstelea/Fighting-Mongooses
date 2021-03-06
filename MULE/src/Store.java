import java.util.ArrayList;
import java.lang.Math;

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
 * When a Mule is purchased, it must also be configured, so the 
 * following fees are added to the base price.
 *
 * So an energy mule would cost 100 + 50 = 150.
 *
 * @author Geoving Gerard II
 * @version 11 | 21 | 2013
 */
public class Store {

	private int foodQuantity;
	private int energyQuantity;
	private	int smithoreQuantity;
    private int crystiteQuantity;
	private int mulesQuantity;

	private final int FOODPRICE = 30;
	private final int ENERGYPRICE = 25;
	private	final int SMITHOREPRICE = 50;
	private	final int CRYSTITEPRICE = 100; 
	private final int MULESPRICE = 100;

	private final int FOODMULE = 125;
	private final int ENERGYMULE = 150;
	private	final int SMITHOREMULE = 175;
    private final int CRYSTITEMULE = 200;

    private int costOfPurchase;
    private int playerQuantity;
    private int itemCost;

    /**
     * Store sets initial quanitity based on difficulty
     * @param difficulty takes in current game difficulty
     */
	public Store(int difficulty){
        if((difficulty > 0) && (difficulty < 2)){
            this.foodQuantity = 16;
            this.energyQuantity = 16;
            this.smithoreQuantity = 0;
            this.crystiteQuantity = 0;
            this.mulesQuantity = 25;
        }
        else if((difficulty > 1) && (difficulty < 4)) {
            this.foodQuantity = 8;
            this.energyQuantity = 8;
            this.smithoreQuantity = 8;
            this.crystiteQuantity = 0;
            this.mulesQuantity = 14;
        }
	}

    /**
     * Player buys. Subtracts purchase from player's money.
     *
     * @param players ArrayList contaning all players
     * @param currPlayer The current player.
     * @param item Item currPlayer is purchasing.
     * @param toBuy Number of items currPlayer is purchasing.
     *
     * @return String The string to be outputted unto the menuPanel.
     */
    public String buyItem(ArrayList<Player> players, int currPlayer, String item, int toBuy){
        int buy = toBuy;
        int playerValue = (int)players.get(currPlayer).getMoney();
        if(item.equals("food")){
            if(foodQuantity - buy < 0){
                buy = 0;
                return "noBuy";
            }
            else{
                costOfPurchase = FOODPRICE * buy;
            }
        }
        else if(item.equals("energy")){
            if(energyQuantity - buy < 0){
                buy = 0;
                return "noBuy";
            }
            else{
                costOfPurchase = ENERGYPRICE * buy;
            }
        }
        else if(item.equals("smithore")){
            if(smithoreQuantity - buy < 0){
                buy = 0;
                return "noBuy";
            }
            else{
                costOfPurchase = SMITHOREPRICE * buy;
            }
        }
        else if(item.equals("crystite")){
            if(crystiteQuantity - buy < 0){
                buy = 0;
                return "noBuy";
            }
            else{
                costOfPurchase = CRYSTITEPRICE * buy;
            }
        }
        else if(item.equals("foodMule")){
            if(foodQuantity - buy < 0){
                buy = 0;
                return "noBuy";
            }
            else{
                costOfPurchase = FOODMULE;
            }
        }
        else if(item.equals("energyMule")){
            if(energyQuantity - buy < 0){
                buy = 0;
                return "noBuy";
            }
            else{
                costOfPurchase = ENERGYMULE;
            }
        }
        else if(item.equals("smithoreMule")){
            if(smithoreQuantity - buy < 0){
                buy = 0;
                return "noBuy";
            }
            else{
                costOfPurchase = SMITHOREMULE;
            }
        }
        else if(item.equals("crystiteMule")){
            if(crystiteQuantity - buy < 0){
                buy = 0;
                return "noBuy";
            }
            else{
                costOfPurchase = SMITHOREMULE;
            }
        }
        if((playerValue - costOfPurchase) >= 0){
            if(item.equals("food")){
                if(foodQuantity > 0){
                    if(buy > 0){
                        int pFoodQuantity = players.get(currPlayer).getFood();
                        players.get(currPlayer).setFood(pFoodQuantity + buy);
                        this.foodQuantity = (foodQuantity - buy);
                    }
                    else{
                        return "Store cannot sell a negative amount.";
                    }
                }
                else{
                    buy = 0;
                    return "Store does not have any more Food to sell.";
                }
            }
            else if(item.equals("energy")){
                if(energyQuantity > 0){
                    if(buy > 0){
                        int pEnergyQuantity = players.get(currPlayer).getEnergy();
                        players.get(currPlayer).setEnergy(pEnergyQuantity + buy);
                        this.energyQuantity = (energyQuantity - buy);
                    }
                    else{
                        return "Store cannot sell a negative amount.";
                    }
                }
                else{
                    buy = 0;
                    return "Store does not have any more Energy to sell.";
                    }
            }
            else if(item.equals("smithore")){
                if(smithoreQuantity > 0){
                    if(buy > 0){
                        int pSmithoreQuantity = players.get(currPlayer).getSmithore();
                        players.get(currPlayer).setSmithore(pSmithoreQuantity + buy);
                        this.smithoreQuantity = (smithoreQuantity - buy);
                    }
                    else{
                        buy = 0;
                        return "Store cannot sell a negative amount.";
                    }
                }
                else{
                    buy = 0;
                    return "Store does not have any more Smithore to sell.";
                    }
            }
            else if(item.equals("crystite")){
                if(crystiteQuantity > 0){
                    if(buy > 0){
                        int pCrystiteQuantity = players.get(currPlayer).getCrystite();
                        players.get(currPlayer).setCrystite(pCrystiteQuantity + buy);
                        this.crystiteQuantity = (crystiteQuantity - buy);
                    }
                    else{
                        return "Store cannot sell a negative amount.";
                    }
                }
                else{
                    buy = 0;
                    return "Store does not have any more Crystite to sell.";
                }
            }
            else if(item.equals("foodMule")){
                if((foodQuantity > 0) && (mulesQuantity > 0)){
                    this.foodQuantity--;
                    this.mulesQuantity--;
                    players.get(currPlayer).setMule(true);
                    players.get(currPlayer).setMuleType("FoodMule");
                }
                else{
                    buy = 0;
                    return "Store does not have any more Food Mules to sell.";
                }
            }
            else if(item.equals("energyMule")){
                if((energyQuantity > 0) && (mulesQuantity > 0)){
                    this.energyQuantity--;
                    this.mulesQuantity--;
                    players.get(currPlayer).setMule(true);
                    players.get(currPlayer).setMuleType("EnergyMule");
                }
                else{
                    buy = 0;
                    return "Store does not have any more Energy Mules to sell.";
                    }
            }
            else if(item.equals("smithoreMule")){
                if((smithoreQuantity > 0) && (mulesQuantity > 0)){
                    this.smithoreQuantity--;
                    this.mulesQuantity--;
                    players.get(currPlayer).setMule(true);
                    players.get(currPlayer).setMuleType("SmithoreMule");
                }
                else{
                    buy = 0;
                    return "Store does not have any more Smithore Mules to sell.";
                    }
            }
            else if(item.equals("crystiteMule")){
                if((crystiteQuantity > 0) && (mulesQuantity > 0)){
                    this.crystiteQuantity--;
                    this.mulesQuantity--;
                    players.get(currPlayer).setMule(true);
                    players.get(currPlayer).setMuleType("CrystiteMule");
                }
                else{
                    buy = 0;
                    return "Store does not have any more Crystite Mules to sell.";
                }
            }
            players.get(currPlayer).setMoney(playerValue - costOfPurchase);
        }
        else{
            return "noFunds";
        }
        return "true";
    }

    /**
     * Player sells. Adds value of sale to player's money.
     *
     * @param players ArrayList contaning all players.
     * @param currPlayer The current player.
     * @param item Item currPlayer is selling.
     * @param toSell number of items currPlayer is selling.
     *
     * @return String The string to be outputted unto the menuPanel.
     */
    public String sellItem(ArrayList<Player> players, int currPlayer, String item, int toSell){
        int playerValue = (int)players.get(currPlayer).getMoney();
        Player player = players.get(currPlayer);

        if(toSell < 0){
            return "Store cannot sell a negative amount.";
        }
        else if(item.equals("food")){
            playerQuantity = (int)players.get(currPlayer).getFood();
            itemCost = FOODPRICE * toSell;
            if(toSell > playerQuantity){
                return "Player selling more than what they own";
            }
            else{
                //increase store quanitity & reduce player quantity
                int pFoodQuantity = players.get(currPlayer).getFood();
                players.get(currPlayer).setFood(pFoodQuantity - toSell);
                this.foodQuantity += toSell;
                players.get(currPlayer).setMoney(playerValue + itemCost);
                return "Player successfully sold " + toSell + " Food";
            }
        }
        else if(item.equals("energy")){
            playerQuantity = (int)players.get(currPlayer).getEnergy();
            itemCost = ENERGYPRICE * toSell;
            if(toSell > playerQuantity){
                return "Player selling more than what they own";
            }
            else{
                //increase store quanitity & reduce player quantity
                int pEnergyQuantity = players.get(currPlayer).getEnergy();
                players.get(currPlayer).setEnergy(pEnergyQuantity - toSell);
                this.energyQuantity += toSell;
                players.get(currPlayer).setMoney(playerValue + itemCost);
                return "Player successfully sold " + toSell + " Energy";
            }
        }
        else if(item.equals("smithore")){
            playerQuantity = (int)players.get(currPlayer).getSmithore();
            itemCost = SMITHOREPRICE * toSell;
            if(toSell > playerQuantity){
                return "Player selling more than what they own";
            }
            else{
                //increase store quanitity & reduce player quantity
                int pSmithoreQuantity = players.get(currPlayer).getSmithore();
                players.get(currPlayer).setSmithore(pSmithoreQuantity - toSell);
                this.smithoreQuantity += toSell;
                this.mulesQuantity += toSell; //Smithore increases store's mule supply
                players.get(currPlayer).setMoney(playerValue + itemCost);
                return "Player successfully sold " + toSell + " Smithore";
            }
        }
        else if(item.equals("crystite")){
            costOfPurchase = (int)players.get(currPlayer).getCrystite();
            itemCost = CRYSTITEPRICE * toSell;
            if(toSell > playerQuantity){
                return "Player selling more than what they own";
            }
            else{
                //increase store quanitity & reduce player quantity
                int pCrystiteQuantity = players.get(currPlayer).getCrystite();
                players.get(currPlayer).setCrystite(pCrystiteQuantity - toSell);
                this.crystiteQuantity += toSell;
                players.get(currPlayer).setMoney(playerValue + itemCost);
                return "Player successfully sold " + toSell + " Crystite";
            }
        }
        else if(item.equals("foodMule")){
            itemCost = (FOODMULE - 10); //no rules for selling mule. liken to selling used car so you get less than msrp
            players.get(currPlayer).setMule(false);
            players.get(currPlayer).setMuleType(null);
            this.foodQuantity += toSell;
            this.mulesQuantity += toSell;
            players.get(currPlayer).setMoney(playerValue + itemCost);
            return "Player successfully sold a Food Mule";
        }
        else if(item.equals("energyMule")){
            itemCost = (ENERGYMULE - 20); //no rules for selling mule. liken to selling used car so you get less than msrp
            players.get(currPlayer).setMule(false);
            players.get(currPlayer).setMuleType(null);
            this.energyQuantity += toSell;
            this.mulesQuantity += toSell;
            players.get(currPlayer).setMoney(playerValue + itemCost);
            return "Player successfully sold an Energy Mule";
        }
        else if(item.equals("smithoreMule")){
            itemCost = (SMITHOREMULE - 30); //no rules for selling mule. liken to selling used car so you get less than msrp
            players.get(currPlayer).setMule(false);
            players.get(currPlayer).setMuleType(null);
            this.smithoreQuantity += toSell;
            this.mulesQuantity += toSell;
            players.get(currPlayer).setMoney(playerValue + itemCost);
            return "Player successfully sold a Smithore Mule";
        }
        else if(item.equals("crystiteMule")){
            itemCost = (SMITHOREMULE - 40); //no rules for selling mule. liken to selling used car so you get less than msrp
            players.get(currPlayer).setMule(false);
            players.get(currPlayer).setMuleType(null);
            this.crystiteQuantity += toSell;
            this.mulesQuantity += toSell;
            players.get(currPlayer).setMoney(playerValue + itemCost);
            return "Player successfully sold Crystite Mule";
        }
        players.get(currPlayer).setMoney(playerValue + itemCost);
        //notify player that sale was successful
        return "Funds successfully added to player";
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
        return FOODPRICE;
    }

    /**
     * Getter method for the store's energy price
     *
     * @return The store's energy price
     */
    public int getEnergyPrice() {
        return ENERGYPRICE;
    }

    /**
     * Getter method for the store's smithore price
     *
     * @return The store's smithore price
     */
    public int getSmithorePrice() {
        return SMITHOREPRICE;
    }

   	/**
     * Getter method for the store's crystite price
     *
     * @return The store's crystite price
     */
    public int getCrystitePrice() {
        return CRYSTITEPRICE;
    }

    /**
     * Getter method for the store's mules price
     *
     * @return The store's mules price
     */
    public int getMulesPrice() {
        return MULESPRICE;
    }

    /**
     * Getter method for the store's food fee
     *
     * @return The store's food fee
     */
    public int getFoodMule() {
        return FOODMULE;
    }

    /**
     * Getter method for the store's energy fee
     *
     * @return The store's energy fee
     */
    public int getEnergyMule() {
        return ENERGYMULE;
    }

    /**
     * Getter method for the store's smithore fee
     *
     * @return The store's smithore fee
     */
    public int getSmithoreMule() {
        return SMITHOREMULE;
    }

   	/**
     * Getter method for the store's crystite fee
     *
     * @return The store's crystite fee
     */
    public int getCrystiteMule() {
        return SMITHOREMULE;
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
}
