
import java.util.List;

public class Player {

    // instance variables
    private String name;
    private String race;
    private String color;
    private int money;
    private int food;
    private int energy;
    private int smithore;
    private int mules;
    private int row;
    private int column;
    private List<Tile> tiles;

    public Player(String name, String race, String color) {

        // sanity check on parameters
        if (name == null || race == null || color == null) {
            throw new NullPointerException("One of the parameters in the Player constructor was null");
        }

        if (name.length() <= 2 || name.length() > 100) {
            throw new IllegalArgumentException("Please ensure name is between 3 and 100 characters long");
        }

        if (!(color.equals("Red") || color.equals("Blue") || color.equals("Pink") || color.equals("Green") ||
            color.equals("Orange"))) {
            throw new IllegalArgumentException("Invalid color");
        }

        if (!(race.equals("Human") || race.equals("Flapper") || race.equals("Bonzoid") || race.equals("Ugaite") || 
            race.equals("Buzzite"))) {
            throw new IllegalArgumentException("Invalid race");
        }

        // set instance variables
        this.name = name;
        this.race = race;
        this.color = color;
    }
}
