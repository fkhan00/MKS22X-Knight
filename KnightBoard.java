public class KnightBoard{
  public int[][] board;
  public KnightBoard(int startingRow, int startingCol){
    counter = 0;
    solutions = 0;
    board = new int[startingRow][startingCol];}

  public String toString(){
    String output = "";
    if(board.length * board.length < 10){
      for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board.length; j++){
          output += board[i][j];
        }
        output += "\n";}
      return output;}
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board.length; j++){
        if(board[i][j] < 10){
          output += " " + board[i][j];}
        else{
          output += board[i][j];}
      }
    output += "\n";}
    return output;}

  public boolean solve(int startingRow, int startingCol){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board.length; j++){
        if(board[i][j] != 0){
          throw new IllegalStateException("please give an empty board");
        }
        if(startingRow < 0 || startingCol < 0){
          throw new IllegalArgumentException("please enter non negative parameters");}}}
    return solveH( startingRow, startingCol, 0, 0);}

  public boolean valid(int r, int c){
    return r >= 0 && c >= 0 && r < board.length && c < board.length && board[r][c] == 0;}

  public boolean filled(int[][] ary){
    for(int i = 0; i < ary.length; i++){
      for(int j = 0; j < ary.length; j++){
        if(ary[i][j] == 0){
          return false;}}}
    return true;}

  public int counter;
  public int solutions;
  public boolean solveH( int r, int c, int incR, int incC){
    if(filled(board)){
      return true;}
      System.out.println(toString());
    if(! valid (r, c)){
      counter ++;
      if(counter == 8){
        board[r - incR][c - incC] = 0;}
      return false;}
    board[r][c] = 1;
     return solveH( r + 1, c + 2, 1, 2) || solveH( r + 2, c + 1, 2, 1) || solveH( r + 2, c - 1, 2, -1) ||
     solveH( r - 1, c + 2, -1, 2) ||
     solveH( r - 2, c + 1, -2, 1) ||  solveH( r - 1, c - 2, -1, -2) || solveH( r - 2, c - 1, -2, -1) ||
      solveH( r  + 1, c - 2,1, -2);
}
  public int countSolutions(int r, int c){
    return countSolutionsH(r, c, 0, 0);}
    
  public int countSolutionsH(int r, int c, int incR, int incC){
    System.out.println(toString());
    if(filled(board)){
      return 1;}
    if(! valid(r, c)){
      counter ++;
      if(counter == 8){
        board[r - incR][c - incC] = 0;}
      return 0;}
    board[r][c] = 1;
    return countSolutionsH( r + 1, c + 2, 1, 2) + countSolutionsH( r + 2, c + 1, 2, 1)  + countSolutionsH( r + 2, c - 1, 2, -1)
     + countSolutionsH( r - 1, c + 2, -1, 2)  + countSolutionsH( r - 2, c + 1, -2, 1)  + countSolutionsH( r - 1, c - 2, -1, -2)+
      countSolutionsH( r - 2, c - 1, -2, -1)  + countSolutionsH( r  + 1, c - 2, 1, -2);
  }
}
