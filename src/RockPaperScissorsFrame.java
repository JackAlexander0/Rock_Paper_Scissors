import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    JPanel mainPnl;
    JPanel displayPnl;
    JPanel buttonPnl;
    JPanel statsPnl;
    JLabel titleLbl;
    JLabel playerWinLbl;
    JLabel computerWinLbl;
    JLabel gameTieLbl;
    JTextArea rpsTA;
    JScrollPane scroller;
    ImageIcon rockIcon;
    ImageIcon paperIcon;
    ImageIcon scissorsIcon;

    JButton rockBtn;
    JButton paperBtn;
    JButton scissorsBtn;
    JButton quitBtn;

    int computerWin;
    int playerWin;
    int gameTie;
    String playerMove;
    String computerMove;
    int chooseStrat;
    int randomMove;
    String move;
    String compMove;

    Random rnd = new Random();

    Icon rock = new ImageIcon("\\Rock.png");
    Icon paper = new ImageIcon("\\Paper.jpg");
    Icon scissors = new ImageIcon("\\Scissors.png");

    public RockPaperScissorsFrame() {
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createButtonPnl();
        mainPnl.add(buttonPnl, BorderLayout.SOUTH);

        createStatPanel();
        mainPnl.add(statsPnl, BorderLayout.CENTER);

        createDisplayArea();
        mainPnl.add(displayPnl, BorderLayout.NORTH);

        add(mainPnl);
        //might need to change size
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    private void createButtonPnl() {
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(2,3));

        rockBtn = new JButton("Rock", rock);
        paperBtn = new JButton("Paper", paper);
        scissorsBtn = new JButton("Scissors", scissors);
        quitBtn = new JButton("Quit");

        //add in action listeners
        rockBtn.addActionListener((ActionEvent ae) -> {
            move = "Rock";
            compMove = computerPlay(move);
            calculateWinner(compMove, move);
        });

        paperBtn.addActionListener((ActionEvent ae) -> {
            move = "Paper";
            compMove = computerPlay(move);
            calculateWinner(compMove, move);
        });

        scissorsBtn.addActionListener((ActionEvent ae) -> {
            move = "Scissors";
            compMove = computerPlay(move);
            calculateWinner(compMove, move);
        });

        quitBtn.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });

        buttonPnl.add(rockBtn);
        buttonPnl.add(paperBtn);
        buttonPnl.add(scissorsBtn);
        buttonPnl.add(new JLabel(""));
        buttonPnl.add(quitBtn);

    }
    private void createStatPanel() {
        statsPnl = new JPanel();
        statsPnl.setLayout(new GridLayout(2,3));

        playerWinLbl = new JLabel("Player Wins");
        playerWinLbl.setVerticalTextPosition(JLabel.CENTER);
        playerWinLbl.setHorizontalTextPosition(JLabel.CENTER);

        computerWinLbl = new JLabel("Computer Wins");
        computerWinLbl.setVerticalTextPosition(JLabel.CENTER);
        computerWinLbl.setHorizontalTextPosition(JLabel.CENTER);

        gameTieLbl = new JLabel("Ties");
        gameTieLbl.setVerticalTextPosition(JLabel.CENTER);
        gameTieLbl.setHorizontalTextPosition(JLabel.CENTER);

        statsPnl.add(playerWinLbl);
        statsPnl.add(computerWinLbl);
        statsPnl.add(gameTieLbl);
        statsPnl.add(new JLabel(String.valueOf(playerWin)));
        statsPnl.add(new JLabel(String.valueOf(computerWin)));
        statsPnl.add(new JLabel(String.valueOf(gameTie)));

    }
    private void createDisplayArea() {
        displayPnl = new JPanel();
        rpsTA = new JTextArea(12,25);
        rpsTA.setEditable(false);
        scroller = new JScrollPane(rpsTA);
        displayPnl.add(scroller);

    }

    private String computerPlay(String playerMove) {
        chooseStrat = rnd.nextInt(9);
        switch (chooseStrat) {
            case 0:
                if (playerMove == "Scissors") {
                    computerMove = "Rock";
                }
                else if (playerMove == "Rock") {
                    computerMove = "Paper";
                }
                else {
                    computerMove = "Scissors";
                }
                break;
            case 1:
            case 2:
                //least
                break;
            case 3:
            case 4:
                //most
                break;
            case 5:
            case 6:
                //last
                break;
            case 7:
            case 8:
            case 9:
                randomMove = rnd.nextInt(2);
                if (randomMove == 0) {
                    computerMove = "Scissors";
                }
                else if (randomMove == 1) {
                    computerMove = "Paper";
                }
                else {
                    computerMove = "Rock";
                }
                break;
        }
        return computerMove;
    }
    private void calculateWinner(String compMove, String playerMove) {
        if (compMove.equals("Scissors") && playerMove.equals("Scissors")) {
            //tie
        }
        else if (compMove.equals("Paper") && playerMove.equals("Paper")) {
            //tie
        }
        else if (compMove.equals("Rock") && playerMove.equals("Rock")) {
            //tie
        }
        else if (compMove.equals("Rock") && playerMove.equals("Paper")) {
            //player win
        }
        else if (compMove.equals("Rock") && playerMove.equals("Scissors")) {
            //comp win
        }
        else if (compMove.equals("Paper") && playerMove.equals("Rock")) {
            //comp win
        }
        else if (compMove.equals("Paper") && playerMove.equals("Sicssors")) {
            //player win
        }
        else if (compMove.equals("Scissors")  && playerMove.equals("Rock")) {
            //player win
        }
        else if (compMove.equals("Scissors") && playerMove.equals("Paper")) {
            //comp win
        }
    }
    private void awardPoints() {

    }
}
