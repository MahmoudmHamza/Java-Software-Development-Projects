import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// Class that handles client logic
public class TicTacToeClient 
{
    private JFrame frame = new JFrame("Tic Tac Toe");
    private JLabel messageLabel = new JLabel("");
    private ImageIcon icon;
    private ImageIcon opponentIcon;

    private Square[] board = new Square[9];
    private Square currentSquare;

    private static int PORT = 8901;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    // Constructor for the client that connects him to a server, 
    // laying out the GUI and registering GUI listeners.
    public TicTacToeClient(String serverAddress) throws Exception 
    {
        this.InitializeNetworking();
        this.InitializeGUI();
    }
    
    // Setup networking for clients
    private void InitializeNetworking()
    {
        this.socket = new Socket(serverAddress, PORT);
        this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        this.out = new PrintWriter(this.socket.getOutputStream(), true);    
    }
    
    // Layout client GUI
    private void InitializeGUI()
    {
        this.messageLabel.setBackground(Color.lightGray);
        this.frame.getContentPane().add(this.messageLabel, "South");

        JPanel boardPanel = new JPanel();
        boardPanel.setBackground(Color.black);
        boardPanel.setLayout(new GridLayout(3, 3, 2, 2));
        for (int i = 0; i < board.length; i++) 
        {
            final int j = i;
            board[i] = new Square();
            board[i].addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    currentSquare = board[j];
                    out.println("MOVE " + j);}});
            boardPanel.add(board[i]);
        }
        frame.getContentPane().add(boardPanel, "Center");
    }

    // Handles client's play logic
    public void Play() throws Exception {
        String response;
        try 
        {
            response = this.in.readLine();
            
            if (response.startsWith("WELCOME")) 
            {
                char mark = response.charAt(8);
                this.icon = new ImageIcon(mark == 'X' ? "x.gif" : "o.gif");
                this.opponentIcon  = new ImageIcon(mark == 'X' ? "o.gif" : "x.gif");
                this.frame.setTitle("Tic Tac Toe - Player " + mark);
            }
            
            while (true) 
            {
                response = this.in.readLine();
                if (response.startsWith("VALID_MOVE")) 
                {
                    this.messageLabel.setText("Valid move, please wait");
                    currentSquare.setIcon(this.icon);
                    currentSquare.repaint();
                } 
                else if (response.startsWith("OPPONENT_MOVED")) 
                {
                    int loc = Integer.parseInt(response.substring(15));
                    board[loc].setIcon(this.opponentIcon);
                    board[loc].repaint();
                    this.messageLabel.setText("Opponent moved, your turn");
                } 
                else if (response.startsWith("VICTORY")) 
                {
                    this.messageLabel.setText("You win");
                    break;
                } 
                else if (response.startsWith("DEFEAT")) 
                {
                    this.messageLabel.setText("You lose");
                    break;
                } 
                else if (response.startsWith("TIE")) 
                {
                    this.messageLabel.setText("You tied");
                    break;
                } 
                else if (response.startsWith("MESSAGE")) 
                {
                    this.messageLabel.setText(response.substring(8));
                }
            }
            
            out.println("QUIT");
        }
        finally 
        {
            this.socket.close();
        }
    }

    // Asks the player if he wants to play again
    private boolean WantsToPlayAgain() 
    {
        int response = JOptionPane.showConfirmDialog(frame,
            "Want to play again?",
            "Tic Tac Toe is Fun Fun Fun",
            JOptionPane.YES_NO_OPTION);
            
        frame.dispose();
        
        return response == JOptionPane.YES_OPTION;
    }

    //Graphical square in the client window.  
    static class Square extends JPanel 
    {
        JLabel label = new JLabel((Icon)null);

        public Square() 
        {
            setBackground(Color.white);
            add(label);
        }

        public void setIcon(Icon icon) 
        {
            label.setIcon(icon);
        }
    }

    public static void main(String[] args) throws Exception 
    {
        while (true) 
        {
            String serverAddress = (args.length == 0) ? "localhost" : args[1];
            TicTacToeClient client = new TicTacToeClient(serverAddress);
            client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            client.frame.setSize(240, 160);
            client.frame.setVisible(true);
            client.frame.setResizable(false);
            
            client.Play();
            if (!client.WantsToPlayAgain()) 
            {
                break;
            }
        }
    }
}