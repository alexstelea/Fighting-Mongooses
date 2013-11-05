public abstract class Tile {

    protected boolean hasMule;
    protected Player owner;
    protected String type;
    protected String muleType;

    public Tile(String type) {
        this.type = type;
        hasMule = false;
        muleType = "";
    }

    public void collectResources() {

    }

    // return the String of the image to draw at this location, or null if we don't need to draw anything
    public abstract String image();

    public boolean addMule() {

        if (hasMule == true && owner != null) {
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
        System.out.println("Mule removed!");
        hasMule = false;
        return true;
    }

    public boolean buyProperty(Player owner) {
        if (this.owner != null) {
            System.out.println("This property is already owned!");
            return false;
        }
        this.owner = owner;
        return true;
    }

    public Player getOwner() {
        return owner;
    }

    public boolean hasMule() {
        return hasMule;
    }

    public String getType() {
        return type;
    }

    public String getMuleType() {
        return muleType;
    }

    public void setMuleType(String muleType) {
        this.muleType = muleType;
    }

    public boolean muleIsValid(String muleType) {
        System.out.println("Comparing " + type + " and " + muleType);
        if (type.equals("river") && muleType.equals("FoodMule"))
            return true;
        else if (type.length() > 8 && type.substring(0, 8).equals("mountain") && muleType.equals("SmithoreMule"))
            return true;
        else if (type.equals("plain") && muleType.equals("EnergyMule")) 
            return true;
        else
            return false;
    }
}
