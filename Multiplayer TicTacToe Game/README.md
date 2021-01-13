>**Brief**

Tic Tac Toe is multiplayer game for two players, X and O, who take turns marking the spaces in a 3×3 grid. The player who succeeds in placing three of their marks in a diagonal, horizontal, or vertical row is the winner. This project respresents a client server model which depends mainly on message transmission between clients and server. Each move made by a player will be sent in a message to the server to be processed. After that the server will return the result as response to both clients based on the sent message.

>**Project Concept**

The main thread of the client will listen for messages from the server. When the client starts, The first message will be a **WELCOME** message in which we receive our mark, then we go into a loop listening for messages and handling each message appropriately such as:
* **VALID_MOVE**: Player made a correct move.
* **OPPONENT_MOVED**: Opponent's turn is finished.
* **VICTORY**: Player who recieves this message wins.
* **DEFEAT**: Player who recieves this message loses.
* **OPPONENT_QUIT**: Opponent quits the game.
* **MESSAGE**: Send a specific message to players.
When this loop breaks or exits, the server will send **QUIT** message and will be terminated.

>**How To Play**

First you need to start the server by running **TicTacToeServer.java** script, then you need to start the client for each player by running **TicTacToeCleint.java**.

**Note**: This game is designed to be played through LAN (Local Area Network) only. 
