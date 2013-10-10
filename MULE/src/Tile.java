public abstract class Tile {

    protected boolean hasMule;
    protected int type;
    protected String owner;

    public abstract int collectResources();

    public boolean addMule() {
        if (hasMule == true && owner != null) {
            System.out.println("Tile already has a MULE!");
            return false;
        }
        hasMule = true;
        return true;
    }

    public boolean removeMule() {
        if (hasMule != true && owner != null) {
            System.out.println("Tile does not have a MULE!");
            return false;
        }
        hasMule = false;
        return true;
    }

    public boolean buyProperty(String owner) {
        if (this.owner != null) {
            System.out.println("This property is already owned!");
            return false;
        }
        this.owner = owner;
        return true;
    }

    public int getType() {
        return type;
    }

    public String getOwner() {
        return owner;
    }
}
