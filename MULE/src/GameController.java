
import java.util.ArrayList;

public class GameController {
    /**
     * Main method of the MULE game
     * Initializes the environment and starts the game
     *
     * Currently a stub method 
     *
     * @param args command line arguments - currently don't do anything
     */
    public static void main(String[] args) {
        System.out.println("Main Method!");
        GameController game = new GameController();
    }
	
	public static final int EASY_DIFFICULTY = 1;
	public static final int MEDIUM_DIFFICULTY = 2;
	public static final int HARD_DIFFICULTY = 3;
	public static final int DIFFICULTY_NOT_SET = 0;

	private int difficulty;
	private Renderer renderer;


	public GameController() {
		renderer = new Renderer();
        //renderer.drawTest();
        playGame();
	}

    private void playGame() {
        startGame();
        initializeMap();
    }

	private void startGame() {

        String state = "intro";
        boolean initializing = true;

        // variables we are collecting
        int difficulty = 0;
        int numPlayers = 1;
        Map map = null;
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<String> takenColors = new ArrayList<String>();

        while(initializing) {

            System.out.println("State: " + state);
            // Introduction Screen
            if (state.equals("intro")) {
                String action = renderer.drawIntroScreen()[0];
                if (action.equals("quit")) {
                    state = "quit";
                }
                else if (action.equals("load")) {
                    state = "load";
                }
                else {
                    state = "setup";
                }
            }

            // Setup Screen
            else if (state.equals("setup")) {
               String[] results = renderer.drawSetupScreen();
               String action = results[0];
               difficulty = Integer.parseInt(results[1]);
               numPlayers = Integer.parseInt(results[2]);
               if (action.equals("okay")) {
                   state = "map";
               }
               else {
                   state = "intro";
               }
            }

            // Map Screen
            else if (state.equals("map")) {
                String[] results = renderer.drawMapScreen();
                String action = results[0];
                map = new Map(Integer.parseInt(results[1]));
                System.out.println("Map created with num " + Integer.parseInt(results[1]));
                if (action.equals("okay")) {
                    state = "player";
                }
                else {
                    state = "setup";
                }
            }

            // Character selection screen
            else if (state.equals("player")) {
                String[] results = renderer.drawCharacterScreen();
                String action = results[0];
                if (action.equals("back")) {
                    state = "map";
                }
                else {
                    if (takenColors.contains(results[3])) {
                        System.out.println("That color is taken!");
                        continue;
                    }
                    takenColors.add(results[3]);

                    try {
                        players.add(new Player(results[2], results[1], results[3], difficulty));
                    }
                    catch (Exception exception) {
                        System.out.println(exception);
                        continue;
                    }

                    // only move on if we have all the players
                    if (--numPlayers == 0) {
                        state = "game";
                    }
                }
            }


            else if (state.equals("game")){
                String[] results = renderer.drawMainGameScreen(map);
                int tileSelection = Integer.parseInt(results[0]);
                if (map.getTiles()[tileSelection].getType().equals("town")) {
                    state = "town";
                }
            }

            else if (state.equals("town")) {
                String[] results = renderer.drawTownScreen();
                
                state = "game";
            }

            // quit state
            else {
                System.out.println("State: " + state);
                initializing = false;
            }
        }
        numPlayers = players.size();
        System.out.println("Difficulty: " + difficulty);
        System.out.println("NumPlayers: " + numPlayers);
        System.out.println("Map: " + map.getMapNum());
        for (Player p : players) {
            System.out.println(p);
        }
	}

    private void initializeMap() {

    }
	
	private void showLoadGameSavePartial(Save savedGame){
		
	}
	
	private void showLoadScreen(){
		Save[] savedGames = getSavedGames();
		LoadScreenModel model = new LoadScreenModel();
		model.setSavedGames(savedGames);
		renderer.drawLoadScreen(model);
	}

	private Save[] getSavedGames() {
		return null;
		//Query database for saved games
	}

	public int getDifficulty() {
		return difficulty;
	}
}
