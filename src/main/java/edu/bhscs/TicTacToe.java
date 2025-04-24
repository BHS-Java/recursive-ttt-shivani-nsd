import java.util.Scanner;

public class TicTacToe {
  private char[][] board;
  private char currentPlayer;
  Scanner s = new Scanner(System.in);
  boolean gameOver = false;

  public TicTacToe() {
      board = new char[3][3];
      currentPlayer = 'X';
      for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
              board[i][j] = ' ';
          }
      }
  }

  public void playGame() {
      playTurn();
  }

  public void printBoard() {
    System.out.println("-------------------------------");
    for(int y = 0; y<3; y++){
      String b = "";
      for(int x = 0; x<3; x++){
        b = b + "["+board[y][x]+"]";
      }
      System.out.println(b);

    }
  }


  public void playTurn(){
    printBoard();
    if(currentPlayer=='X')currentPlayer='O';
    else currentPlayer='X';
    System.out.println("Player " +currentPlayer+ " choose coordinates");
    int x = s.nextInt();
    int y = s.nextInt();
    board[y][x]=currentPlayer;
    if(!checkWin()){
      System.out.println("No winner!");
      playTurn();
    }

  }


  public boolean checkWin(){
    
    checkRow(0,0);
    checkColumn(0,0);
    checkDiagonal(0,0);
    checkDiagonalB(2,2);

    if(gameOver){
      System.out.println(currentPlayer + " is the winner! GAME OVER.");
      return true;
    }

    return false;


  }

  public void checkRow(int y, int x){  
    if (x == 3){
      System.out.println("!!!!!!ROW WINNER FOUND!!!!!!!!!");
      gameOver = true;
      return;
    } 
    if (x < 3 && board[y][x] == currentPlayer)checkRow(y, x+1);
    else if(y<2)checkRow(y+1,0);
  }

  public void checkColumn(int y, int x){
    if(y==3){
      System.out.println("!!!!!!!!!!COLLUMN YAYAYAYAYYAAYAY!!!!!!!!!!!!");
      gameOver = true;
      return;
    }
    if (y < 3 && board[y][x] == currentPlayer)checkColumn(y+1, x);
    else if(x<2)checkColumn(0,x+1);
  }


  public void checkDiagonal(int y, int x){
    if(y==3){
      System.out.println("!!!!!!!!DIAGONAL WINNER FOUND!!!!!!!!!!");
      gameOver = true;
    }
    if (y < 3 && board[y][x] == currentPlayer)checkDiagonal(y+1, x+1);


    

    
  }


  public void checkDiagonalB(int y, int x){
    if(y==-1){
      System.out.println("!!!!!!!!DIAGONAL WINNER FOUND!!!!!!!!!!");
      gameOver = true;
    }
    if (y < 3 && board[y][x] == currentPlayer)checkDiagonalB(y-1, x-1);


    

    
  }



  
  
}
