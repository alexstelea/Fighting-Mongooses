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
		renderer.drawStartScreen(model);
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