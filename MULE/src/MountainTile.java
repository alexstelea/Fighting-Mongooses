public class MountainTile extends Tile {

    private int mountainNum;

    public MountainTile(int mountainNum) {
        super("mountain" + mountainNum);
        this.mountainNum = mountainNum;
    }

    public void collectResources(Player player) {
        return;
    }
}

