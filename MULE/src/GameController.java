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
        startGame();
	}

	private void startGame() {

        String state = "intro";
        boolean initializing = true;

        // variables we are collecting
        String difficulty;
        int numPlayers;

        while(initializing) {

            // Introduction Screen
            if (state.equals("intro")) {
                System.out.println("State: " + state);
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
                System.out.println("State: " + state);
               String[] results = renderer.drawSetupScreen();
               String action = results[0];
               difficulty = results[1];
               numPlayers = Integer.parseInt(results[2]);
               if (action.equals("okay")) {
                   state = "map";
               }
               else {
                   state = "intro";
               }
            }

            // quit state
            else {
                System.out.println("State: " + state);
                System.exit(0);
            }
        }
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
