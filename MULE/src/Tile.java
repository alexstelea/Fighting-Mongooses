/**
 * A class representing a tile object
 * This would be abstract, but our serialization library complains
 *
 * @author Kennon Bittick
 * @version 11 | 21 | 2013
 */
public class Tile {

    protected boolean hasMule;
    protected Player owner;
    protected String type;
    protected String muleType;

    /**
     * A constructor that takes in the type of tile we're creating
     *
     * @param type the type of tile to be created
     **/
    public Tile(String type) {
        this.type = type;
        hasMule = false;
        muleType = "";
    }

    /**
     * A quasi-abstract method that will be implemented in subclasses to collect resources from the tile
     **/
    public void collectResources() {

    }

    /**
     * return the image string of the tile
     *
     * @return always null - the abstract tile has no image
     **/
    public String image() {
        return null;
    }

    /**
     * A method to add a mule to the tile
     *
     * @return true if placed successfully, false otherwise
     **/
    public boolean addMule() {

        if (hasMule == true && owner != null) {
            System.out.println("Tile already has a MULE!");
            return false;
        }
        hasMule = true;
        return true;
    }

    /**
     * A method to remove the mule from the tile
     *
     * @return true if removed successfully, false otherwise
     **/
    public boolean removeMule() {
        if (hasMule != true) {
            System.out.println("Tile does not have a MULE!");
            return false;
        }
        System.out.println("Mule removed!");
        muleType = "";
        hasMule = false;
        return true;
    }

    /**
     * A method to set the owner of the tile to the provided player
     *
     * @param player the new owner
     *
     * @return true if owner was successfully set, false otherwise
     **/
    public boolean buyProperty(Player owner) {
        if (this.owner != null) {
            System.out.println("This property is already owned!");
            return false;
        }
        this.owner = owner;
        return true;
    }

    /**
     * Set the owner of the tile to null
     **/
    public void sellProperty() {
        owner = null;
    }


    /**
     * A getter method for the owner of the tile
     *
     * @return the owner of the tile
     **/
    public Player getOwner() {
        return owner;
    }

    /**
     * A getter method for whether or not the tile has a mule
     *
     * @return whether or not the tile has a mule
     **/
    public boolean hasMule() {
        return hasMule;
    }

    /**
     * A getter method for the type of the tile
     *
     * @return the tile type
     **/
    public String getType() {
        return type;
    }

    /**
     * A getter method for the type of mule on the tile
     * 
     * @return the mule type
     **/
    public String getMuleType() {
        return muleType;
    }

    /**
     * A setter method for the type of mule on the tile
     *
     * @param muleType the mule type to place on the tile
     **/
    public void setMuleType(String muleType) {
        this.muleType = muleType;
    }

    /**
     * Returns whether or not the mule type is valid
     *
     * @param muleType the mule to test
     *
     * @return whether or not the mule is valid.  Currently always returns true
     **/
    public boolean muleIsValid(String muleType) {
        return true;
    }
}
