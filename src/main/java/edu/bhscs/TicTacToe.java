import java.util.Scanner;

public class TicTacToe {
  private char[][] board;
  private char currentPlayer;
  Scanner s = new Scanner(System.in);

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
    System.out.println("Sucess");
    if(!checkWin()){
      playTurn();
    }

  }


  public boolean checkWin(){
    

    if(checkColumn(0,0)){
      System.out.println(currentPlayer + " is the winner! GAME OVER.");
      return true;
    }

    return false;


  }

  public boolean checkRow(int y, int x){  
    if (x == 3){
      System.out.println("ROW WINNER FOUND!!!!!!!!!");
      return true;
    } 
    if (x < 3 && board[y][x] == currentPlayer)checkRow(y, x+1);
    else if(y<2)checkRow(y+1,0);
    return false;
  }

  public boolean checkColumn(int y, int x){
    if(y==3){
      System.out.println("COLLUMN YAYAYAYAYYAAYAY");
      return true;
    }
    if (y < 3 && board[y][x] == currentPlayer)checkRow(y+1, x);
    else if(x<2)checkRow(0,x+1);

    return false;
    
  }


  public boolean checkDiagonal(){
    return false;
  }



  
  
}
