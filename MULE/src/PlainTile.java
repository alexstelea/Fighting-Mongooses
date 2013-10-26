public class PlainTile extends Tile {

    public PlainTile() {
        super("plain");
    }

    public void collectResources() {
        if (hasMule) {
            owner.changeFood(2);
            owner.changeEnergy(3);
            owner.changeSmithore(1);
        }
    }

    public String image() {
        return null;
    }
}

