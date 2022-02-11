import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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
}
