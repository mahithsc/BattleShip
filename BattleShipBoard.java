package com.company;
/* BattleShipBoard.java
 * Alex Rabines and Simon Donkor
 * Java II Programming
 * Mr. Blondin
 * 1/7/2021
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
public class BattleShipBoard
        extends JFrame implements ActionListener{

    // storage variables
    int button1 = -1;
    int button2 = -1;
    String image1;
    String image2;

    // counter variables
    int gameCounter = 1;
    int hitsCounter = 0;
    // JPanels
    JPanel backgroundPnl = new JPanel ();
    JPanel titlePnl = new JPanel ();
    JPanel messagePnl = new JPanel ();
    JPanel gamePnl = new JPanel ();
    JPanel scorePnl = new JPanel ();
    JPanel shipPnl = new JPanel ();

    // JLabels
    JLabel titleLbl = new JLabel("BattleShip");
    JLabel messageLbl = new JLabel("Can you sink all the ships?");
    JLabel gameLbl = new JLabel("Games: " + gameCounter);
    JLabel matchLbl = new JLabel("Hits: " + hitsCounter);
    JLabel shipLbl = new JLabel("Sunk: " + hitsCounter);


    // JButtons
    JButton[] gameButtons = new JButton[100];
    JButton startButton = new JButton("Restart");
    JButton stopButton = new JButton("Stop");

    // image icons
    ImageIcon original = new ImageIcon("images/imageOriginal.gif");

    // images
    ArrayList<String> images = new ArrayList<String>();
    ArrayList<ImageIcon> gameImages = new ArrayList<ImageIcon>();


    // constructor
    public BattleShipBoard() {
        super("BattleShip");
        setSize(1500, 800);

        // add ActionListener to the start and stop buttons
        startButton.addActionListener(this);
        stopButton.addActionListener(this);

        backgroundPnl.setLayout(new BorderLayout());

        // title Panel (NORTH)
        titlePnl.setBackground(Color.CYAN);
        titlePnl.add(titleLbl);
        backgroundPnl.add(titlePnl, BorderLayout.NORTH);

        // message Panel (SOUTH)
        messagePnl.setBackground(Color.CYAN);
        messagePnl.add(messageLbl);
        backgroundPnl.add(messagePnl, BorderLayout.SOUTH);

        // game Panel (CENTER)
        gamePnl.setBackground(Color.ORANGE);
        gamePnl.setLayout(new GridLayout(10,5,2,2));
        // make JButtons
        makeGameButtons();
        // add JButtons
        backgroundPnl.add(gamePnl, BorderLayout.CENTER);

        // score panel (EAST)
        scorePnl.add(startButton);
        scorePnl.add(stopButton);
        scorePnl.add(gameLbl);
        scorePnl.add(matchLbl);
        scorePnl.setLayout(new GridLayout(5,1,2,2));
        backgroundPnl.add(scorePnl, BorderLayout.EAST);

        // Ship status panel (WEST)
        scorePnl.add(shipLbl);
        shipPnl.setLayout(new GridLayout(5,1,2,2));
        backgroundPnl.add(shipLbl, BorderLayout.WEST);

        // add the backgroundPnl
        add(backgroundPnl);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }


    public void makeGameButtons() {
        for (int i = 0; i<gameButtons.length; i++){
            // put the original image on all the buttons
            gameButtons[i] = new JButton(original);
            // add ActionListener to the buttons
            gameButtons[i].addActionListener(this);
            gamePnl.add(gameButtons[i]);
        }
    }

    public void resetGameButtons() {
        for (int i = 0; i<gameButtons.length; i++){
            // reset the image and enable all the buttons
            gameButtons[i].setIcon(original);
            gameButtons[i].setEnabled(true);
        }
    }


    public void resetBoard() {
        images.clear();
        gameImages.clear();
        // resetGameButtons
        resetGameButtons();
        // reset all the storage variables
        button1 = -1;
        button2 = -1;
        image1 = null;
        image2 = null;
        // add to the gameCounter and reset all the other counters
        gameCounter++;
        gameLbl.setText("Games: " + gameCounter);
        hitsCounter = 0;
        matchLbl.setText("Hits: " + hitsCounter);

    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        // check if the source is start or start
        if(source == startButton) {
            resetBoard();
        }
        if(source == stopButton) {
            // stop the program
            System.exit(1);
        }
    }
    
   
    public static void main(String [] args){
    	battleShipBoard = new battleShipBoard();
    }
} // end class BattleShipBoard