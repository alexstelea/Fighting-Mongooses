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
		showStartScreen();
	}

	private void showStartScreen() {
		Save[] savedGames = getSavedGames();
		StartScreenModel model = new StartScreenModel();
		if(savedGames == null || savedGames.length == 0) {
			model.setIsSavedGameAvailable(true);
		}
        System.out.println("Entering intro screen");
		String action = renderer.drawIntroScreen();
        System.out.println("Leaving intro screen");
        if (action.equals("Quit"))
        {
            System.exit(0);
        }
        else if (action.equals("Load"))
        {
            System.out.println("Load");
            System.exit(0);
        }

        // New Game
        System.out.println("New");
        System.out.println("Entering difficulty screen");
        renderer.drawDifficultyScreen();
        System.out.println("Leaving difficulty screen");

        String difficulty = action.substring(0, action.indexOf(':'));
        action = action.substring(action.indexOf(':'));
        int numPlayers = Integer.parseInt(action.substring(0, action.indexOf(':')));
        action = action.substring(action.indexOf(':'));

        if (action.equals("Back"))
        {
            System.exit(0);
        }

        System.out.println(action);
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
