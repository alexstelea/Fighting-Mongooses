/**
 * A subclass of Tile representing a mountain
 **/
public class MountainTile extends Tile {

    private int mountainNum;

    /**
     * A constructor that takes in the number of the mountain we're creating
     *
     * @param mountainNum the type of the mountain we're creating
     **/
    public MountainTile(int mountainNum) {
        super("mountain" + mountainNum);
        this.mountainNum = mountainNum;
    }

    /**
     * Collect resources from this tile
     **/
    public void collectResources() {
        if (hasMule) {
            if (muleType.equals("FoodMule")) {
                owner.changeFood(1);
            }
            else if (muleType.equals("EnergyMule")) {
                owner.changeEnergy(1);
            }
            else if (muleType.equals("SmithoreMule")) {
                owner.changeSmithore(1 + mountainNum);
            }
        }
        return;
    }

    /**
     * return a string representing the image of the mountain
     *
     * @return the image string
     **/
    public String image() {
        return "mount" + mountainNum + ".png";
    }

    /**
     * get the type of this mountain
     *
     * @return the mountain type
     **/
    public int getMountainNum() {
        return mountainNum;
    }
}

