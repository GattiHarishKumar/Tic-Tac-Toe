
# 🎮 Tic Tac Toe - Console Based (Java OOP)

A simple **console-based Tic Tac Toe** game for **two players**, built using **Java** and Object-Oriented Programming (OOP) principles. This project showcases clean code structure, class responsibilities, input validation, and a basic game loop.

---

## 🧠 Features

- Two-player mode (Player X and Player O)
- Clear, interactive console UI
- Input validation (prevents invalid or already occupied moves)
- Win and draw detection logic
- Clean OOP design using Java classes: `Board`, `Player`, and `Game`


---

## ▶️ How to Run

1. Clone the repository or copy the code into a file named `TicTacToe.java`.

2. Open terminal in the directory containing the file.

3. Compile the program:
   ```bash
   javac TicTacToe.java
````

4. Run the game:

   ```bash
   java TicTacToe
   ```

---

## 🛠 Classes Overview

* **Board**: Handles board initialization, display, win/draw detection, and move validation.
* **Player**: Represents each player with a name and symbol (`X` or `O`).
* **Game**: Controls the game loop, player turns, and interaction with the board.
* **TicTacToe (main)**: Launches the game.

---

## 📸 Sample Gameplay

```
Welcome to Tic Tac Toe!
Enter name for Player 1 (X): Alice
Enter name for Player 2 (O): Bob

Current Board:
   |   |  
---+---+---
   |   |  
---+---+---
   |   |  

Alice's turn (X)
Enter row (0-2): 1
Enter column (0-2): 1

... [continues until win or draw]
```

---

## 📚 Concepts Used

* Object-Oriented Programming (Encapsulation, Classes, Methods)
* 2D Arrays
* Input validation
* Game logic and state handling
* Java Console I/O

---

