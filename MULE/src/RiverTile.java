public class RiverTile extends Tile {

    public RiverTile() {
        super("river");
    }

    public void collectResources() {
        if (hasMule) {
            if (muleType.equals("FoodMule")) {
                owner.changeFood(4);
            }
            else if (muleType.equals("EnergyMule")) {
                owner.changeEnergy(2);
            }
        }
    }

    public String image() {
        return null;
    }
}

