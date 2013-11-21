/**
 * A subclass of Tile representing a plain
 *
 * @author Kennon Bittick
 * @version 11 | 21 | 2013
 */
public class PlainTile extends Tile {

    /**
     * A constructor, just calls the super constructor
     **/
    public PlainTile() {
        super("plain");
    }

    /**
     * Collect resources from this tile
     **/
    public void collectResources() {
        if (hasMule) {
            if (muleType.equals("FoodMule")) {
                owner.changeFood(2);
            }
            else if (muleType.equals("EnergyMule")) {
                owner.changeEnergy(3);
            }
            else if (muleType.equals("SmithoreMule")) {
                owner.changeSmithore(1);
            }
        }
    }

    /**
     * return a string representing the image string
     *
     * @return always null - uses the background of the map
     **/
    public String image() {
        return null;
    }
}

