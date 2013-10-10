public class MountainTile extends ResourceTile {

    private int mountainNum;

    public MountainTile(int mountainNum) {
        super("mountain" + mountainNum);
        this.mountainNum = mountainNum;
    }

    public void collectResources(Player player) {
        return;
    }
}

