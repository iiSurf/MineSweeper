# Minesweeper Hint Generator
A clean, efficient Java algorithm that parses Minesweeper maps and calculates the number of adjacent mines for every empty cell. It processes multiple fields in a single execution and supports input from both standard input (`System.in`) and external text files.
---## 📋 The Problem
The goal of the game is to find where all the mines are located within an \(M \times N\) field. To help you, the game shows a number in a square which tells you how many mines there are adjacent to that square. For instance, suppose a \(4 \times 4\) field with \(2\) mines (represented by an `*` character):
```text
*...
....
.*..
....
```

If we represent the same field placing the hint numbers described above, we end up with:
```text
*100
2210
1*10
1110
```

Each square has at most \(8\) adjacent squares (horizontal, vertical, and diagonal).
---## 📥 The Input
The input consists of an arbitrary number of fields:
1. The first line of each field contains two integers: `n` and `m` (\(0 < n, m \le 100\)) which stand for the number of lines and columns of the field respectively.
2. The next `n` lines contain exactly `m` characters and represent the field.
3. Each safe square is represented by a `.` character and each mine square is represented by an `*` character.
4. The first field line where `n = m = 0` represents the end of input and is not processed.
   ---## 📤 The Output
   For each field, the program prints the following message in a line alone:`Field #x:` (Where `x` stands for the number of the field, starting from 1).

The next `n` lines contain the field with the `.` characters replaced by the number of adjacent mines to that square. There is a mandatory empty line between field outputs.
### 📝 Sample Match Case#### Sample Input```text
4 4
*...
....
.*..
....
3 5
**...
.....
.*...
0 0
```
#### Sample Output```text
Field #1:
*100
2210
1*10
1110

Field #2:
**100
33200
1*100
```
---## 🛠️ How to Compile and Run### 1. Compile the ProgramOpen your terminal inside the project directory and compile the Java source file:```bash
javac Minesweeper.java
```
### 2. Run with an Input File (Recommended)Pass the path of your data file as a command-line argument:```bash
java Minesweeper input.txt
```
### 3. Run with Standard Console InputRun the program directly and paste your map data into the terminal stream:```bash
java Minesweeper
```
---## 📝 Code Architecture Summary* **`main()`**: Manages file streams, validates arguments, tracks active field loops, and terminates on `0 0`.
* **`readBoard()`**: Efficiently converts raw string rows into a localized 2D character map array (`char[][]`).
* **`gameBoard()`**: Iterates through coordinates, identifies safe cells vs. mines, and manages the custom console logging layouts.
* **`neighbors()`**: Evaluates local grid safe spaces by checking the 8 cardinal and diagonal vector slots against array index boundaries.