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
	static final String start = "Start";
	static final String setup = "Setup";
	static final String map = "Map";
	static final String player = "Player";

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
	    // JPanel CardSetup = new SetupImagePanel();
	    // JPanel CardMap = new MapImagePanel();
	    // JPanel CardPlayer = new PlayerImagePanel();
	    // JPanel CardMainScreen = ;

	
	    panel = new JPanel(new CardLayout());
	    // panel.add(CardStart, start);
	    // panel.add(CardSetup, setup);
	    // panel.add(CardMap, map);
	    // panel.add(CardPlayer, player);
	    // panel.add(CardMainScreen, mainScreen);
	
	    Pane.add(panel, BorderLayout.CENTER);
	
	    // CardStart
	    // CardStart.setLayout(null);
	    // CardSetup.setLayout(null);
	    // CardMap.setLayout(null);
	    // CardPlayer.setLayout(null);
	    // CardMainScreen.setLayout(null);
	   
	    //Quit
	    JButton quit = new JButton("");
	    quit.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	System.exit(0);
	        }
	    });
	    quit.setOpaque(false);
	    quit.setContentAreaFilled(false);
	    quit.setBorderPainted(false);
	    quit.setBounds(11, 536, 171, 40);
	    // CardStart.add(quit);
	    
	    //Load
	    JButton load = new JButton("");
	    load.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            System.out.println("Load");
	            /*
	            CardLayout cl = (CardLayout) (panel.getLayout());
	            cl.show(panel, Setup);
	            */
	        }
	    });
	    load.setOpaque(false);
	    load.setContentAreaFilled(false);
	    load.setBorderPainted(false);
	    load.setBounds(590, 536, 170, 40);
	    // CardStart.add(load);
	    
	    //NewGame
	    JButton newGame = new JButton("");
	    newGame.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            CardLayout cl = (CardLayout) (panel.getLayout());
	            cl.show(panel, setup);
	        }
	    });
	    newGame.setOpaque(false);
	    newGame.setContentAreaFilled(false);
	    newGame.setBorderPainted(false);
	    newGame.setBounds(771, 536, 170, 40);
	    // CardStart.add(newGame);
	    
	    //Go back! (Setup Page)
	    JButton goBack = new JButton("");
	    goBack.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            CardLayout cl = (CardLayout) (panel.getLayout());
	            cl.show(panel, start);
	        }
	    });
	    goBack.setOpaque(false);
	    goBack.setContentAreaFilled(false);
	    goBack.setBorderPainted(false);
	    goBack.setBounds(11, 536, 170, 40);
	    // CardSetup.add(goBack);
	    
	    //Okay! (Setup Page)
	    JButton okay = new JButton("");
	    okay.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            CardLayout cl = (CardLayout) (panel.getLayout());
	            cl.show(panel, map);
	        }
	    });
	    okay.setOpaque(false);
	    okay.setContentAreaFilled(false);
	    okay.setBorderPainted(false);
	    okay.setBounds(771, 536, 170, 40);
	    // CardSetup.add(okay);
	    
	    //Go back! (Map Page)
	    JButton goBackMap = new JButton("");
	    goBackMap.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            CardLayout cl = (CardLayout) (panel.getLayout());
	            cl.show(panel, setup);
	        }
	    });
	    goBackMap.setOpaque(false);
	    goBackMap.setContentAreaFilled(false);
	    goBackMap.setBorderPainted(false);
	    goBackMap.setBounds(11, 536, 170, 40);
	    // CardMap.add(goBackMap);

	   	//Okay! (Map Page)
	    JButton okayMap = new JButton("");
	    okayMap.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            CardLayout cl = (CardLayout) (panel.getLayout());
	            cl.show(panel, player);
	        }
	    });
	    okayMap.setOpaque(false);
	    okayMap.setContentAreaFilled(false);
	    okayMap.setBorderPainted(false);
	    okayMap.setBounds(771, 536, 170, 40);
	    //CardMap.add(okayMap);

	    //Go back! (Player Page)
	    JButton goBackPlayer = new JButton("");
	    goBackPlayer.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            CardLayout cl = (CardLayout) (panel.getLayout());
	            cl.show(panel, map);
	        }
	    });
	    goBackPlayer.setOpaque(false);
	    goBackPlayer.setContentAreaFilled(false);
	    goBackPlayer.setBorderPainted(false);
	    goBackPlayer.setBounds(11, 536, 170, 40);
	    //CardPlayer.add(goBackPlayer);

	    //Okay! (Player Page)
	    JButton okayPlayer = new JButton("");
	    okayPlayer .addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	/*
	            System.out.println("Okay!");
	            CardLayout cl = (CardLayout) (panel.getLayout());
	            cl.show(panel, mainScreen);
	        	 */
	    	System.out.println("Okay!");
	        }
	    });
	    okayPlayer.setOpaque(false);
	    okayPlayer.setContentAreaFilled(false);
	    okayPlayer.setBorderPainted(false);
	    okayPlayer.setBounds(771, 536, 170, 40);
	    //CardPlayer.add(okayPlayer);
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
	
	public void setupScreen(Model model) {
	
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