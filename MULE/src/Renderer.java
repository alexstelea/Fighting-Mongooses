import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Renderer implements MouseListener {

	//instance variables
	public static  final String start = "Start";
	public static final String difficulty = "Difficulty";
	public static final String map = "Map";
	public static final String player = "Player";

	private JPanel panel;

	public Renderer() {


		JFrame frame = new JFrame("M.U.L.E.");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.setMinimumSize(new Dimension(950, 600));
	
	    initPaneCreation(frame.getContentPane());
	
	    frame.pack();
	    frame.setVisible(true);

	}

	private void initPaneCreation(Container Pane){

		Container pane = new Container();

		// JPanel CardStart = new ImagePanel();
	 //    JPanel CardDiff = new DifficultyImagePanel();
	 //    JPanel CardMap = new MapImagePanel();
	 //    JPanel CardPlayer = new PlayerImagePanel();

	
	    panel = new JPanel(new CardLayout());
	    // panel.add(CardStart, start);
	    // panel.add(CardDiff, difficulty);
	    // panel.add(CardMap, map);
	    // panel.add(CardPlayer, player);

	
	    Pane.add(panel, BorderLayout.CENTER);
	
	
	    //CardStart
	    // CardStart.setLayout(null);
	    // CardDiff.setLayout(null);
	    // CardMap.setLayout(null);
	    // CardPlayer.setLayout(null);
	    
	
	    //Quit
	    JButton quit = new JButton("Quit");
	    quit.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	System.exit(0);
	        }
	    });
	    quit.setBounds(11, 536, 171, 40);
	    // CardStart.add(quit);
	    
	    //Load
	    JButton load = new JButton("Load");
	    load.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            System.out.println("Load");
	            /*
	            CardLayout cl = (CardLayout) (panel.getLayout());
	            cl.show(panel, Difficulty);
	            */
	        }
	    });
	    load.setBounds(590, 536, 170, 40);
	    // CardStart.add(load);
	    
	    //NewGame
	    JButton newGame = new JButton("New Game");
	    newGame.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            System.out.println("New Game");
	            CardLayout cl = (CardLayout) (panel.getLayout());
	            cl.show(panel, difficulty);
	        }
	    });
	    newGame.setBounds(771, 536, 170, 40);
	    // CardStart.add(newGame);
	    
	    //Go back!
	    JButton goBack = new JButton("Go Back!");
	    goBack.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            CardLayout cl = (CardLayout) (panel.getLayout());
	            cl.show(panel, start);
	        }
	    });
	    goBack.setBounds(11, 536, 170, 40);
	    // CardDiff.add(goBack);
	    
	    //Okay!
	    JButton okay = new JButton("Okay!");
	    okay.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            System.out.println("Okay!");
	            CardLayout cl = (CardLayout) (panel.getLayout());
	            cl.show(panel, map);
	        }
	    });
	    okay.setBounds(771, 536, 170, 40);
	    // CardDiff.add(okay);
	    
	    //Go back! (Map)
	    JButton goBackMap = new JButton("Go Back!");
	    goBackMap.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            CardLayout cl = (CardLayout) (panel.getLayout());
	            cl.show(panel, difficulty);
	        }
	    });
	    goBackMap.setBounds(11, 536, 170, 40);
	    // CardMap.add(goBackMap);
	}
	
	public void drawStartScreen(StartScreenModel model){
		//draw
		//	if (model.isSavedGameAvailable)
		//		enable loadGameButton
		//	else
		//		disable loadGameButton
		//interact
		//	if (quitButton.pressed) ...
		//  if (loadGameButton.pressed)
		//		GameController.showLoadScreen()
		//call action
	}
	
	public void drawLoadScreen(LoadScreenModel model){
		//draw
		//	for each Save s in model.savedGames
		//		showLoadGameSavePartial(s);
		//interact
		//call action
	}
	
	public void difficultyScreen(Model model) {
	
	}
	
	public void playerScreen(Model model) {
	
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
}