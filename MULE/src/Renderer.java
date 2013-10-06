import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;
import java.awt.font.*;

import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.DefaultCaret;

public class Renderer implements MouseListener, ActionListener {

//instance variables
	static final String start = "Start";
	static final String setup = "Setup";
	static final String map = "Map";
	static final String player = "Player";
	//static final String mainScreen = "Main Screen";
	final Font font1 = new Font("Candara", Font.PLAIN, 30);
	private JPanel panel;

	public Renderer() {

		JFrame frame = new JFrame("M.U.L.E.");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.setMinimumSize(new Dimension(950, 600));
		
	    initPaneCreation(frame.getContentPane());
	
	    frame.pack();
	    frame.repaint();
		frame.validate();
	    frame.setVisible(true);
	}

	private void initPaneCreation(Container Pane){

	    JPanel CardStart = new ImagePanel("/media/startscreen.png");
	    JPanel CardSetup = new ImagePanel("/media/gamesetup.png");
	    JPanel CardMap = new ImagePanel("/media/mapselection.png");
	    JPanel CardPlayer = new ImagePanel("/media/playerselection.png");

	    panel = new JPanel(new CardLayout());
	    panel.add(CardStart, start);
	    panel.add(CardSetup, setup);
	    panel.add(CardMap, map);
	    panel.add(CardPlayer, player);
	    //panel.add(CardMainScreen, mainScreen);
	
	    Pane.add(panel, BorderLayout.CENTER);
	
    //CardStart
	    CardStart.setLayout(null);
	    CardSetup.setLayout(null);
	    CardMap.setLayout(null);
	    CardPlayer.setLayout(null);
	    //CardMainScreen.setLayout(null);
	   
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
	    CardStart.add(quit);
	    
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
	    CardStart.add(load);
	    
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
	    CardStart.add(newGame);
	    	    
    //Easy (Setup Page)
	    JButton easy = new JButton("");
	    easy.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            /*Enter code for Easy difficulty here.
	             * 
	             * 
	             */
	        }
	    });
	    easy.setOpaque(false);
	    easy.setContentAreaFilled(false);
	    easy.setBorderPainted(false);
	    easy.setBounds(160, 163, 73, 28);
	    CardSetup.add(easy);
	    
    //Medium (Setup Page)
	    JButton medium = new JButton("");
	    medium.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            /*Enter code for Medium difficulty here.
	             * 
	             * 
	             */
	        }
	    });
	    medium.setOpaque(false);
	    medium.setContentAreaFilled(false);
	    medium.setBorderPainted(false);
	    medium.setBounds(407, 163, 137, 28);
	    CardSetup.add(medium);
	    
    //Hard (Setup Page)
	    JButton hard = new JButton("");
	    hard.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            /*Enter code for Hard difficulty here.
	             * 
	             * 
	             */
	        }
	    });
	    hard.setOpaque(false);
	    hard.setContentAreaFilled(false);
	    hard.setBorderPainted(false);
	    hard.setBounds(716, 163, 78, 28);
	    CardSetup.add(hard);
	    
    //1 (Setup Page)
	    JButton p1 = new JButton("");
	    p1.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            /*Enter code for 1 Player only here.
	             * 
	             * 
	             */
	        }
	    });
	    p1.setOpaque(false);
	    p1.setContentAreaFilled(false);
	    p1.setBorderPainted(false);
	    p1.setBounds(191, 394, 14, 30);
	    CardSetup.add(p1);
	    
    //2 (Setup Page)
	    JButton p2 = new JButton("");
	    p2.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            /*Enter code for 2 Players here.
	             * 
	             * 
	             */
	        }
	    });
	    p2.setOpaque(false);
	    p2.setContentAreaFilled(false);
	    p2.setBorderPainted(false);
	    p2.setBounds(329, 394, 14, 30);
	    CardSetup.add(p2);
	    
    //3 (Setup Page)
	    JButton p3 = new JButton("");
	    p3.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	/*Enter code for 3 Players here.
	             * 
	             * 
	             */
	        }
	    });
	    p3.setOpaque(false);
	    p3.setContentAreaFilled(false);
	    p3.setBorderPainted(false);
	    p3.setBounds(468, 394, 15, 30);
	    CardSetup.add(p3);
	    
    //4 (Setup Page)
	    JButton p4 = new JButton("");
	    p4.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	/*Enter code for 4 Players here.
	             * 
	             * 
	             */
	        }
	    });
	    p4.setOpaque(false);
	    p4.setContentAreaFilled(false);
	    p4.setBorderPainted(false);
	    p4.setBounds(608, 394, 16, 30);
	    CardSetup.add(p4);
	    
    //5 (Setup Page)
	    JButton p5 = new JButton("");
	    p5.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	/*Enter code for 5 Players here.
	             * 
	             * 
	             */
	        }
	    });
	    p5.setOpaque(false);
	    p5.setContentAreaFilled(false);
	    p5.setBorderPainted(false);
	    p5.setBounds(749, 394, 15, 30);
	    CardSetup.add(p5);

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
	    CardSetup.add(goBack);
	    
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
	    CardSetup.add(okay);

	//Map 1 (Map Page)
	    JButton m1 = new JButton("Map 1");
	    m1.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	/*Enter code for Map 1 here.
	             * 
	             * 
	             */
	        }
	    });
	    //m1.setOpaque(false);
	    //m1.setContentAreaFilled(false);
	    //m1.setBorderPainted(false);
	    m1.setBounds(110, 157, 225, 122);
	    CardMap.add(m1);
	    
    //Map 2 (Map Page)
	    JButton m2 = new JButton("Map 2");
	    p2.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	/*Enter code for Map 2 here.
	             * 
	             * 
	             */
	        }
	    });
	    //m2.setOpaque(false);
	    //m2.setContentAreaFilled(false);
	    //m2.setBorderPainted(false);
	    m2.setBounds(365, 157, 225, 122);
	    CardMap.add(m2);
	    
    //Map 3 (Map Page)
	    JButton m3 = new JButton("Map 3");
	    p3.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	/*Enter code for Map 3 here.
	             * 
	             * 
	             */
	        }
	    });
	    //m3.setOpaque(false);
	    //m3.setContentAreaFilled(false);
	    //m3.setBorderPainted(false);
	    m3.setBounds(615, 157, 225, 122);
	    CardMap.add(m3);
	    
    //Map 4 (Map Page)
	    JButton m4 = new JButton("Map 4");
	    m4.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	/*Enter code for Map 4 here.
	             * 
	             * 
	             */
	        }
	    });
	    //m4.setOpaque(false);
	    //m4.setContentAreaFilled(false);
	    //m4.setBorderPainted(false);
	    m4.setBounds(235, 307, 225, 122);
	    CardMap.add(m4);
	    
    //Map 5 (Map Page)
	    JButton m5 = new JButton("Map 5");
	    m5.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	/*Enter code for Map 5 here.
	             *
	             * 
	             */
	        }
	    });
	    //m5.setOpaque(false);
	    //m5.setContentAreaFilled(false);
	    //m5.setBorderPainted(false);
	    m5.setBounds(488, 307, 225, 122);
	    CardMap.add(m5);
  
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
	    CardMap.add(goBackMap);

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
	    CardMap.add(okayMap);

	    //Human (Player Page)
	    JButton human = new JButton("");
	    human.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	//ImageIcon one = new ImageIcon("/media/human.png");
	        	//setBounds(109, 284, 750, 156);
	        	System.out.println("Human!");
	        	/*Enter code to display human color options on screen here
	             *Record player type
	             * 
	             */
	        }
	    });
	    human.setOpaque(false);
	    human.setContentAreaFilled(false);
	    human.setBorderPainted(false);
	    human.setBounds(75, 78, 133, 115);
	    CardPlayer.add(human);
	    
	    //Elephant (Player Page)
	    JButton elephant = new JButton("");
	    elephant.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	//ImageIcon one = new ImageIcon("/media/elephant.png");
	        	//setBounds(109, 284, 750, 156);
	        	System.out.println("Elephant!");
	        	/*Enter code to display elephant color options on screen here
	             *Record player type
	             * 
	             */
	        }
	    });
	    elephant.setOpaque(false);
	    elephant.setContentAreaFilled(false);
	    elephant.setBorderPainted(false);
	    elephant.setBounds(232, 80, 152, 107);
	    CardPlayer.add(elephant);
	    
	    //Squirrel (Player Page)
	    JButton squirrel = new JButton("");
	    squirrel.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	//ImageIcon one = new ImageIcon("/media/squirrel.png");
	        	//setBounds(109, 284, 750, 156);
	        	System.out.println("Squirrel!");
	        	/*Enter code to display squirrel color options on screen here
	             *Record player type
	             * 
	             */
	        }
	    });
	    squirrel.setOpaque(false);
	    squirrel.setContentAreaFilled(false);
	    squirrel.setBorderPainted(false);
	    squirrel.setBounds(413, 87, 123, 100);
	    CardPlayer.add(squirrel);
	    
	    //Frog (Player Page)
	    JButton frog = new JButton("");
	    frog.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	//ImageIcon one = new ImageIcon("/media/frog.png");
	        	//setBounds(109, 284, 750, 156);
	        	System.out.println("Frog!");
	        	/*Enter code to display frog color options on screen here
	             *Record player type
	             * 
	             */
	        }
	    });
	    frog.setOpaque(false);
	    frog.setContentAreaFilled(false);
	    frog.setBorderPainted(false);
	    frog.setBounds(593, 80, 98, 107);
	    CardPlayer.add(frog);
	    
	    
	    //Cat (Player Page)
	    JButton cat = new JButton("");
	    cat.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	//ImageIcon one = new ImageIcon("/media/cat.png");
	        	//setBounds(109, 284, 750, 156);
	        	System.out.println("Cat!");
	        	/*Enter code to display cat color options on screen here
	             *Record player type
	             * 
	             */
	        }
	    });
	    cat.setOpaque(false);
	    cat.setContentAreaFilled(false);
	    cat.setBorderPainted(false);
	    cat.setBounds(763 ,75, 95, 110);
	    CardPlayer.add(cat);

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
	    CardPlayer.add(goBackPlayer);

    //Name (Player Page)
	    final JTextField name = new JTextField("", 10);
	    final Color color = new Color(87, 51, 4);
	    DefaultCaret c = (DefaultCaret)name.getCaret();
		c.setVisible(true); //allows caret to be shown regardless of focus
		//c.setBlinkRate(0); //turns off blinking
		c.setDot(0); //sets caret position
	    name.setBounds(468, 533, 225, 38);
	    name.setFont(font1);
	    name.setHorizontalAlignment(JTextField.LEFT);
	    name.setForeground(Color.WHITE);
	    name.setBackground(color);
	    name.setOpaque(false);
	    name.setCaretColor(Color.WHITE);
	    name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
	    name.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String playerName = name.getText();
				System.out.println(playerName);
			}
	    });
	    CardPlayer.add(name);

    //Okay! (Player Page)
	    JButton okayPlayer = new JButton("");
	    okayPlayer .addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	        	/*
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
	    CardPlayer.add(okayPlayer);
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

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}