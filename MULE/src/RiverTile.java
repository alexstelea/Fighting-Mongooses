public class RiverTile extends Tile {

    public RiverTile() {
        super("river");
    }

    public void collectResources() {
        if (hasMule) {
            owner.changeFood(4);
            owner.changeEnergy(2);
        }
    }

    public String image() {
        return null;
    }
}

