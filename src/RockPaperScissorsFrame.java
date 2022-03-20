import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    JPanel mainPnl;
    JPanel displayPnl;
    JPanel buttonPnl;
    JPanel statsPnl;
    JLabel playerWinLbl;
    JLabel computerWinLbl;
    JLabel gameTieLbl;
    JTextArea rpsTA;
    JScrollPane scroller;

    JTextField playerWinCount;
    JTextField tieCount;
    JTextField compWinCount;

    JButton rockBtn;
    JButton paperBtn;
    JButton scissorsBtn;
    JButton quitBtn;

    int computerWin;
    int playerWin;
    int gameTie;
    String computerMove;
    int chooseStrat;
    String move;
    String compMove;

    Random rnd = new Random();

    Icon rock = new ImageIcon("C:\\Users\\vicer\\IdeaProjects\\Rock_Paper_Scissors\\src\\Rock.png");
    Icon paper = new ImageIcon("C:\\Users\\vicer\\IdeaProjects\\Rock_Paper_Scissors\\src\\Paper.jpg");
    Icon scissors = new ImageIcon("C:\\Users\\vicer\\IdeaProjects\\Rock_Paper_Scissors\\src\\Scissors.png");

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
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
    private void createButtonPnl() {
        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout(2,3));
        buttonPnl.setBorder(new TitledBorder(new EtchedBorder(),""));

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

        compWinCount = new JTextField(String.valueOf(computerWin));
        playerWinCount = new JTextField(String.valueOf(playerWin));
        tieCount = new JTextField(String.valueOf(gameTie));

        statsPnl.add(playerWinLbl);
        statsPnl.add(computerWinLbl);
        statsPnl.add(gameTieLbl);
        statsPnl.add(playerWinCount);
        statsPnl.add(compWinCount);
        statsPnl.add(tieCount);

    }
    private void createDisplayArea() {
        displayPnl = new JPanel();
        rpsTA = new JTextArea(12,25);
        rpsTA.setEditable(false);
        scroller = new JScrollPane(rpsTA);
        displayPnl.add(scroller);

    }

    private String computerPlay(String playerMove) {
        chooseStrat = rnd.nextInt(3);
        switch (chooseStrat) {
            case 0:
                computerMove = "Scissors";
                break;
            case 1:
                computerMove = "Paper";
                break;
            case 2:
                computerMove = "Rock";
                break;
        }
        return computerMove;
    }
    private void calculateWinner(String compMove, String playerMove) {
        if (compMove.equals("Scissors") && playerMove.equals("Scissors")) {
            rpsTA.append("Scissors & Scissors... It's a tie!\n");
            gameTie++;
            tieCount.setText(String.valueOf(gameTie));
        }
        else if (compMove.equals("Paper") && playerMove.equals("Paper")) {
            rpsTA.append("Paper & Paper... It's a tie!\n");
            gameTie++;
            tieCount.setText(String.valueOf(gameTie));
        }
        else if (compMove.equals("Rock") && playerMove.equals("Rock")) {
            rpsTA.append("Rock & Rock... It's a tie!\n");
            gameTie++;
            tieCount.setText(String.valueOf(gameTie));
        }
        else if (compMove.equals("Rock") && playerMove.equals("Paper")) {
            rpsTA.append("Paper Covers Rock (Player Wins!)\n");
            playerWin++;
            playerWinCount.setText(String.valueOf(playerWin));
        }
        else if (compMove.equals("Rock") && playerMove.equals("Scissors")) {
            rpsTA.append("Rock Crushes Scissors (Computer Wins!)\n");
            computerWin++;
            compWinCount.setText(String.valueOf(computerWin));
        }
        else if (compMove.equals("Paper") && playerMove.equals("Rock")) {
            rpsTA.append("Paper Covers Rock (Computer Wins!)\n");
            computerWin++;
            compWinCount.setText(String.valueOf(computerWin));
        }
        else if (compMove.equals("Paper") && playerMove.equals("Scissors")) {
            rpsTA.append("Scissors Cuts Paper (Player Wins!)\n");
            playerWin++;
            playerWinCount.setText(String.valueOf(playerWin));
        }
        else if (compMove.equals("Scissors")  && playerMove.equals("Rock")) {
            rpsTA.append("Rock Crushes Scissors (Player Wins!)\n");
            playerWin++;
            playerWinCount.setText(String.valueOf(playerWin));
        }
        else if (compMove.equals("Scissors") && playerMove.equals("Paper")) {
            rpsTA.append("Scissors Cuts Paper (Computer Wins!)\n");
            computerWin++;
            compWinCount.setText(String.valueOf(computerWin));
        }
    }
}
