public abstract class Tile {

    protected boolean hasMule;
    protected int type;

    public abstract int collectResources();

    public boolean addMule() {
        if (hasMule == true) {
            System.out.println("Tile already has a MULE!");
            return false;
        }
        hasMule = true;
        return true;
    }

    public boolean removeMule() {
        if (hasMule != true) {
            System.out.println("Tile does not have a MULE!");
            return false;
        }
        hasMule = false;
        return true;
    }

    public int getType() {
        return type;
    }
}
