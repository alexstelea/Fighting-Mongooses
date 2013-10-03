public class LoadScreenModel extends Model {

	private Save[] saves;
	public LoadScreenModel(){

	}

	public Save[] getSavedGames(){
		return this.saves;
	}

	public void setSavedGames(Save[] saves){
		this.saves = saves;
	}
}