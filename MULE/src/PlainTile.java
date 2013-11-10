public class PlainTile extends Tile {

    public PlainTile() {
        super("plain");
    }

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

    public String image() {
        return null;
    }
}

