
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
    private List<Tiles> tiles;

    public Player(String name, String race, String color) {
        this.name = name;
        this.race = race;
        this.color = color;
    }
}
