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
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.DefaultCaret;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.util.concurrent.locks.*;
import java.util.ArrayList;

public class Renderer {

    private JFrame frame;
    private boolean waiting;
    private String[] states; // keeps track of the state of the GUI
    private ReentrantLock lock;
    protected static final int WIDTH = 9;
    protected static final int HEIGHT = 5;
    protected static final int TILE_SIZE = 100;
    private JButton[] buttons = new JButton[WIDTH + HEIGHT];

    public Renderer() {

        frame = new JFrame("M.U.L.E.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setMinimumSize(new Dimension(950, 750));
        frame.setPreferredSize(new Dimension(950, 750));
        frame.setVisible(true);
        waiting = true;
        lock = new ReentrantLock();
        frame.setLayout(new FlowLayout());
    }

    public String[] drawIntroScreen() {
        
        // declare initial variables
        String action = "";
        states = new String[1];
        states[0] = "new";

        ImagePanel panel = new ImagePanel("/media/startscreen.png");
        panel.setPreferredSize(new Dimension(950, 600));
        panel.setLayout(null);

        ArrayList<JPanel> panels = new ArrayList<JPanel>();
        panels.add(panel);
        changePanel(frame, panels);

        // add buttons
        JButton quitButton = addButtonToPanel(panel, 11, 558, 171, 42, 0, "quit");
        JButton loadButton = addButtonToPanel(panel, 590, 558, 171, 42, 0, "load");
        JButton newButton = addButtonToPanel(panel, 771, 558, 171, 42, 0, "new");

        blockForInput();
        exitSafely();
        return states;
    }

    // States[0] - Action to perform: {"back", "okay"}
    // States[1] - Difficulty: {"1", "2", "3"}
    // States[2] - Number of Players: {"1", "2", "3", "4", "5"}
    public String[] drawSetupScreen() {

        // declare initial variables
        String action = "";
        states = new String[3];
        states[0] = "okay";
        states[1] = "2";
        states[2] = "1";

        ImagePanel panel = new ImagePanel("/media/gamesetup.png");
        panel.setPreferredSize(new Dimension(950, 600));
        panel.setLayout(null);

        JPanel playerPanel = new JPanel();
        playerPanel.setPreferredSize(new Dimension(950, 175));

        for (int i = 0; i < 6; i++) {
            ImagePanel playerBox = new ImagePanel("/media/p" + i + "0.png");
            if (i == 0) {
                playerBox.setPreferredSize(new Dimension(160, 175));
            }
            else {
                playerBox.setPreferredSize(new Dimension(158, 175));
            }
            playerPanel.add(playerBox);
        }

        ImagePanel menuPanel = new ImagePanel("/media/bp0.png");
        menuPanel.setPreferredSize(new Dimension(950, 50));
        menuPanel.setLayout(null);

        ArrayList<JPanel> panels = new ArrayList<JPanel>();
        panels.add(panel);
        //panels.add(playerPanel);
        panels.add(menuPanel);

        changePanel(frame, panels);

        // add buttons
        JButton backButton = addButtonToPanel(menuPanel, 11, 0, 170, 40, 0, "back");
        JButton okayButton = addButtonToPanel(menuPanel, 771, 0, 170, 40, 0, "okay");
        JButton easyButton = addButtonToPanel(panel, 160, 193, 173, 28, 1, "1");
        JButton mediumButton = addButtonToPanel(panel, 407, 193, 173, 38, 1, "2");
        JButton hardButton = addButtonToPanel(panel, 716, 193, 173, 38, 1, "3");
        JButton onePlayer = addButtonToPanel(panel, 191, 464, 24, 40, 2, "1");
        JButton twoPlayer = addButtonToPanel(panel, 329, 464, 24, 40, 2, "2");
        JButton threePlayer = addButtonToPanel(panel, 468, 464, 24, 40, 2, "3");
        JButton fourPlayer = addButtonToPanel(panel, 608, 464, 24, 40, 2, "4");
        JButton fivePlayer = addButtonToPanel(panel, 749, 464, 24, 40, 2, "5");

        blockForInput();
        exitSafely();
        return states;
    }

    // States[0] - Action to perform: {"new", "load", "quit"}
    // States[1] - Map Number: {"1", "2", "3", "4", "5"}
    public String[] drawMapScreen() {

        // declare initial variables
        String action = "";
        states = new String[2];
        states[0] = "okay";
        states[1] = "0";

        ImagePanel panel = new ImagePanel("/media/mapselection.png");
        panel.setPreferredSize(new Dimension(950, 600));
        panel.setLayout(null); 

        JPanel playerPanel = new JPanel();
        playerPanel.setPreferredSize(new Dimension(950, 175));

        for (int i = 0; i < 6; i++) {
            ImagePanel playerBox = new ImagePanel("/media/p" + i + "0.png");
            if (i == 0) {
                playerBox.setPreferredSize(new Dimension(160, 175));
            }
            else {
                playerBox.setPreferredSize(new Dimension(158, 175));
            }
            playerPanel.add(playerBox);
        }

        ImagePanel menuPanel = new ImagePanel("/media/bp0.png");
        menuPanel.setPreferredSize(new Dimension(950, 50));
        menuPanel.setLayout(null);

        ArrayList<JPanel> panels = new ArrayList<JPanel>();
        panels.add(panel);
        //panels.add(playerPanel);
        panels.add(menuPanel);
        changePanel(frame, panels);

        // add buttons
        JButton backButton = addButtonToPanel(menuPanel, 11, 0, 170, 40, 0, "back");
        JButton okayButton = addButtonToPanel(menuPanel, 770, 0, 170, 40, 0, "okay");
        JButton map1Button = addButtonToPanel(panel, 110, 187, 225, 152, 1, "1");
        JButton map2Button = addButtonToPanel(panel, 365, 187, 225, 152, 1, "2");
        JButton map3Button = addButtonToPanel(panel, 615, 187, 225, 152, 1, "3");
        JButton map4Button = addButtonToPanel(panel, 235, 357, 225, 152, 1, "4");
        JButton map5Button = addButtonToPanel(panel, 488, 357, 225, 152, 1, "5");

        blockForInput();
        exitSafely();
        return states;
    }
    public String[] drawMainGameScreen(int mapNumber) {

        String action = "";

        ImagePanel panel = new ImagePanel("/media/map"+mapNumber+".png");
        panel.setLayout(null);

        ArrayList<JPanel> panels = new ArrayList<JPanel>();
        panels.add(panel);
        changePanel(frame, panels);
        exitSafely();
        return states;

    }
    // States[0] - Action to perform: {"new", "load", "quit"}
    // States[1] - Race: {"human", "elephant", "squirrel", "frog", "cat"}
    // States[2] - Player Name
    // States[3] - Color: {"red", "blue", "pink", "green", "orange"}
    public String[] drawCharacterScreen() {

        // declare initial variables
        String action = "";
        states = new String[4];
        states[0] = "okay";
        states[1] = "human";
        states[2] = "default";
        states[3] = "red";

        ImagePanel panel = new ImagePanel("/media/playerselection.png");
        panel.setPreferredSize(new Dimension(950, 600));
        panel.setLayout(null);

        JPanel playerPanel = new JPanel();
        playerPanel.setPreferredSize(new Dimension(950, 175));

        for (int i = 0; i < 6; i++) {
            ImagePanel playerBox = new ImagePanel("/media/p" + i + "0.png");
            if (i == 0) {
                playerBox.setPreferredSize(new Dimension(160, 175));
            }
            else {
                playerBox.setPreferredSize(new Dimension(158, 175));
            }
            playerPanel.add(playerBox);
        }

        ImagePanel menuPanel = new ImagePanel("/media/bp0.png");
        menuPanel.setPreferredSize(new Dimension(950, 50));
        menuPanel.setLayout(null);

        ArrayList<JPanel> panels = new ArrayList<JPanel>();
        panels.add(panel);
        //panels.add(playerPanel);
        panels.add(menuPanel);
        changePanel(frame, panels);

        // add buttons
        JButton backButton = addButtonToPanel(menuPanel, 11, 0, 170, 40, 0, "back");
        JButton okayButton = addButtonToPanel(menuPanel, 771, 0, 170, 40, 0, "okay");
        JButton humanButton = addButtonToPanel(panel, 75, 98, 133, 115, 1, "human");
        JButton elephantButton = addButtonToPanel(panel, 232, 98, 133, 115, 1, "elephant");
        JButton squirrelButton = addButtonToPanel(panel, 413, 98, 133, 115, 1, "squirrel");
        JButton frogButton = addButtonToPanel(panel, 593, 98, 133, 115, 1, "frog");
        JButton catButton = addButtonToPanel(panel, 763, 98, 133, 115, 1, "cat");
        JButton redButton = addButtonToPanel(panel, 100, 300, 130, 200, 3, "red");
        JButton blueButton = addButtonToPanel(panel, 260, 300, 130, 200, 3, "blue");
        JButton pinkButton = addButtonToPanel(panel, 420, 300, 130, 200, 3, "pink");
        JButton greenButton = addButtonToPanel(panel, 580, 300, 130, 200, 3, "green");
        JButton orangeButton = addButtonToPanel(panel, 740, 300, 130, 200, 3, "orange");

        JTextField nameBox = addTextToPanel(panel, 470, 535, 225, 38);

        blockForInputCharacter(panel);
        exitSafely();
        states[2] = nameBox.getText();
        return states;
    }

    public void drawLoadScreen(LoadScreenModel model) {
        return;
    }

    /*
    //(row*width+column)
    private void mapCoordinates(){
        for(int col = 0; col < WIDTH; col++){
            for(int row = 0; row < HEIGHT; row++){
            buttons[row * WIDTH + col] = addButtonToPanel(panel, 25 + 100 * col, 25 + 100 * HEIGHT, 100, 100, 1, "test");
            }
        }
    }
    */
    
    // helper methods

    private void changePanel(JFrame frame, ArrayList<JPanel> panels) {
        frame.getContentPane().removeAll();        
        for (JPanel panel : panels) {
            frame.add(panel);
        }
        frame.pack();
        frame.repaint();
        return;
    }

    private void blockForInput() {
        // wait for a button to be clicked
        boolean waitingSafe = true; // used to avoid race condition
        while (waitingSafe) {
            try {
                lock.lock();
                waitingSafe = waiting;
            }
            finally {
                lock.unlock();
            }
        }
    }

    private JLabel blockForInputCharacter(JPanel panel) {
        // wait for a button to be clicked
        JLabel colors = addLabelToPanel(panel, 70, 300, 804, 200, "/media/" + states[1] + ".png");
        panel.repaint();
        String oldState = states[1];
        boolean waitingSafe = true; // used to avoid race condition
        while (waitingSafe) {
            if (!oldState.equals(states[1])) {
                panel.remove(colors);
                colors = addLabelToPanel(panel, 70, 300, 804, 200, "/media/" + states[1] + ".png");
                panel.repaint();
                oldState = states[1];
            }

            try {
                lock.lock();
                waitingSafe = waiting;
            }
            finally {
                lock.unlock();
            }
        }
        return colors;
    }

    private void exitSafely() {
        try {
            lock.lock();
            waiting = true;
        }
        finally {
            lock.unlock();
        }
    }


    private JButton addButtonToPanel(JPanel panel, int x, int y, int width, int height, 
        final int stateNum, final String stateText) {
        JButton button = new JButton();
        button.setBounds(x, y, width, height);
        panel.add(button);

        button.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                states[stateNum] = stateText; // set the new state
                System.out.println(stateNum + " set to: " + stateText);

                // safely set the value of waiting
                if (stateNum == 0) {
                    try {
                        lock.lock();
                        waiting = false;
                    }
                    finally {
                        lock.unlock();
                    }
                }
            }
        });

        //button.setOpaque(false);
        //button.setContentAreaFilled(false);
        //button.setBorderPainted(false);
        return button;
    }

    private JTextField addTextToPanel(JPanel panel, int x, int y, int width, int height) {
        JTextField text = new JTextField("Enter Name Here");
        text.setBounds(x, y, width, height);
        DefaultCaret c = (DefaultCaret)text.getCaret();
        c.setVisible(true);
        c.setDot(0);
        text.setFont(new Font("Candara", Font.PLAIN, 30));
        text.setHorizontalAlignment(JTextField.LEFT);
        text.setForeground(Color.WHITE);
        text.setBackground(new Color(87, 51, 4));
        text.setOpaque(false);
        text.setCaretColor(Color.WHITE);
        text.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        panel.add(text);
        return text;
    }

    private JLabel addLabelToPanel(JPanel panel, int x, int y, int width, int height, String image) {
        BufferedImage img;
        try {
            img = ImageIO.read(getClass().getResourceAsStream(image));
        }
        catch (Exception e) {
            System.out.println("Caught: " + e);
            return null;
        }

        ImageIcon icon = new ImageIcon(img);
        JLabel label = new JLabel();
        label.setIcon(icon);
        label.setBounds(x, y, width, height);
        panel.add(label);
        return label;
    }
}
