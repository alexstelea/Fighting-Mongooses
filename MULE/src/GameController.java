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
    }
}

	public static final int EASY_DIFFICULTY = 1;
	public static final int MEDIUM_DIFFICULTY = 2;
	public static final int HARD_DIFFICULTY = 3;
	public static final int DIFFICULTY_NOT_SET = 0;

	private int difficulty;
	private Renderer renderer;


	public GameController() {
		renderer = new Renderer();
		SaveGame[] savedGames = getSavedGames();
		Model startScreenModel = new StartScreenModel();
		if(savedGames == null) {
			startScreenModel.setIsSavedGameAvailible(true);
		}
		showStartScreen(startScreenModel);
	}

	private void showStartScreen(Model model) {
		renderer.drawStartScreen(model)
	}

	private SaveGame[] getSavedGames() {
		//Query database for saved games
	}

	public int getDifficulty() {
		return difficulty;
	}
}
