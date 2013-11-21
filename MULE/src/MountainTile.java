public class MountainTile extends Tile {

    private int mountainNum;

    public MountainTile(int mountainNum) {
        super("mountain" + mountainNum);
        this.mountainNum = mountainNum;
    }

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

    public String image() {
        return "mount" + mountainNum + ".png";
    }

    public int getMountainNum() {
        return mountainNum;
    }
}

