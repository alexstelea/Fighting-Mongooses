
import java.util.List;
import java.util.ArrayList;

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
        money = 0;
        food = 0;
        energy = 0;
        smithore = 0;
        mules = 0;
        row = 0;
        column = 0;
        tiles = new ArrayList<Tile>();
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public String getColor() {
        return color;
    }

    public int getMoney() {
        return money;
    }

    public int getFood() {
        return food;
    }

    public int getEnergy() {
        return energy;
    }

    public int getSmithore() {
        return smithore;
    }

    public int getMules() {
        return mules;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setSmithore(int smithore) {
        this.smithore = smithore;
    }

    public void setMules(int mules) {
        this.mules = mules;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void addTile(Tile tile) {
        tiles.add(tile);
    }
}
