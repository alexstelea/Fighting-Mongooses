public class MountainTile extends Tile {

    private int mountainNum;

    public MountainTile(int mountainNum) {
        super("mountain" + mountainNum);
        this.mountainNum = mountainNum;
    }

    public void collectResources() {
        if (hasMule) {
            owner.changeFood(1);
            owner.changeEnergy(1);
            owner.changeSmithore(1 + mountainNum);
        }
        return;
    }

    public String image() {
        return "mount" + mountainNum + ".png";
    }
}

