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

        // Introduction Screen
		String action = renderer.drawIntroScreen();

        if (action.equals("Quit"))
        {
            System.exit(0);
        }
        else if (action.equals("Load"))
        {
            System.out.println("Load");
            System.exit(0);
        }

        // Difficulty Screen
        action = renderer.drawDifficultyScreen();

        String difficulty = action.substring(0, action.indexOf(':'));
        action = action.substring(action.indexOf(':') + 1);
        int numPlayers = Integer.parseInt(action.substring(0, action.indexOf(':')));
        System.out.println("Diffculty: " + difficulty + ", numPlayers: " + numPlayers);
        action = action.substring(action.indexOf(':') + 1);

        if (action.equals("Back"))
        {
            System.exit(0);
        }

        // Map Selection Screen
        action = renderer.drawMapSelectionScreen();
        System.out.println(action);

        int mapNum = Integer.parseInt(action.substring(0, action.indexOf(':')));
        action = action.substring(action.indexOf(':') + 1);

        if (action.equals("Back"))
        {
            System.exit(0);
        }

        // Character Selection Screen
        try {
            Thread.sleep(100); // find out why this is needed
        }
        catch (Exception e) {
        }

        action = renderer.drawCharacterSelectionScreen();
        System.out.println("Done");
        System.exit(0);


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
