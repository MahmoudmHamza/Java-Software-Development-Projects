import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// This class handles the game's server logic
public class TicTacToeServer 
{
    public static void main(String[] args) throws Exception 
    {
        ServerSocket listener = new ServerSocket(8901);
        System.out.println("Tic Tac Toe Server is Running");
        
        try {
            while (true) 
            {
                Game game = new Game();
                Game.Player playerX = game.new Player(listener.accept(), 'X');
                Game.Player playerO = game.new Player(listener.accept(), 'O');
                playerX.SetOpponent(playerO);
                playerO.SetOpponent(playerX);
                game.currentPlayer = playerX;
                playerX.start();
                playerO.start();
            }
        } 
        finally 
        {
            listener.close();
        }
    }
}

// This class constructs game play's logic
class Game 
{
    // Tic Tac Toe's board consists of 9 squares
    private Player[] board = 
    {
        null, null, null,
        null, null, null,
        null, null, null
    };

    // Indicates the current player
    Player currentPlayer;

    // Determines whether we have a winner or not
    public boolean IsWinnerDecided() 
    {
        return
            (board[0] != null && board[0] == board[1] && board[0] == board[2])
          ||(board[3] != null && board[3] == board[4] && board[3] == board[5])
          ||(board[6] != null && board[6] == board[7] && board[6] == board[8])
          ||(board[0] != null && board[0] == board[3] && board[0] == board[6])
          ||(board[1] != null && board[1] == board[4] && board[1] == board[7])
          ||(board[2] != null && board[2] == board[5] && board[2] == board[8])
          ||(board[0] != null && board[0] == board[4] && board[0] == board[8])
          ||(board[2] != null && board[2] == board[4] && board[2] == board[6]);
    }

    // no empty squares
    public boolean IsBoardFilledUp() 
    {
        for (int i = 0; i < board.length; i++) 
        {
            if (board[i] == null) {
                return false;
            }
        }
        return true;
    }
    
    // thread when player tries a move
    public synchronized boolean IsLegalMove(int location, Player player) 
    {
        if (player == this.currentPlayer && board[location] == null) {
            board[location] = this.currentPlayer;
            this.currentPlayer = this.currentPlayer.opponent;
            this.currentPlayer.OtherPlayerMoved(location);
            return true;
        }
        return false;
    }
    
    // This class handles player's logic
    class Player extends Thread 
    {
        char mark;
        Player opponent;
        Socket socket;
        BufferedReader input;
        PrintWriter output;
        
        // thread handler to initialize stream fields
        public Player(Socket socket, char mark) 
        {
            this.socket = socket;
            this.mark = mark;
            try 
            {
                this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.output = new PrintWriter(socket.getOutputStream(), true);
                this.output.println("WELCOME " + mark);
                this.output.println("MESSAGE Waiting for opponent to connect");
            } 
            catch (IOException e) 
            {
                System.out.println("Player died: " + e);
            }
        }
        
        //Accepts notification of who the opponent is.
        public void SetOpponent(Player opponent) 
        {
            this.opponent = opponent;
        }

         //Handles the otherPlayerMoved message. 
        public void OtherPlayerMoved(int location) 
        {
            output.println("OPPONENT_MOVED " + location);
            output.println(this.IsWinnerDecided() ? "DEFEAT" : this.IsBoardFilledUp() ? "TIE" : "");
        }
    
        public void Run() 
        {
            try 
            {
                // The thread is only started after everyone connects.
                output.println("MESSAGE All players connected");

                // Tell the first player that it is his/her turn.
                if (mark == 'X') 
                {
                    output.println("MESSAGE Your move");
                }

                // Repeatedly get commands from the client and process them.
                while (true) 
                {
                    String command = input.readLine();
                    if (command.startsWith("MOVE")) 
                    {
                        int location = Integer.parseInt(command.substring(5));
                        if (this.IsLegalMove(location, this)) 
                        {
                            output.println("VALID_MOVE");
                            output.println(this.IsWinnerDecided() ? "VICTORY" : this.IsBoardFilledUp() ? "TIE" : "");
                        } 
                        else 
                        {
                            output.println("MESSAGE ?");
                        }
                    } 
                    else if (command.startsWith("QUIT")) 
                    {
                        return;
                    }
                }
            } 
            catch (IOException e) 
            {
                System.out.println("Player died: " + e);
            } 
            finally 
            {
                try 
                {
                    this.socket.close();
                } 
                catch (IOException e) 
                {
                    
                }
            }
        }
    }
}
