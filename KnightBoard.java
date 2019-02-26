public class KnightBoard {
  private int[][] board;
  private int lrc;
  private int lcc;
  private int[][] moves = {{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
  public KnightBoard(int rc, int cc) {
    board = new int[rc][cc];
    lrc = rc;
    lcc = cc;
  }
  public String toString() {
    String s = "";
    for(int q = 0; q < board.length; q++) {
      for(int w = 0; w < board[q].length; w++) {
        if(board[q][w] < 10) {
          s += "0";
          s += board[q][w];
          s += " ";
        }
        else {
          s += board[q][w];
          s += " ";
        }
      }
      s += "\n";
    }
    return s;
  }
  public boolean solve(int r, int c) {
    if(bnc()) {
      throw new IllegalStateException("board isn't clear");
    }
    if(r < 0 || c < 0) {
      throw new IllegalArgumentException("row and col params can't be negative");
    }
    if(r >= board.length) {
      throw new IllegalArgumentException("row param exceeds row dimension");
    }
    if(c >= board[0].length) {
      throw new IllegalArgumentException("col param exceeds col dimension");
    }
    return sh(r, c, 1, 0);
  }
  private boolean sh(int r, int c, int mn, int coord) {
    if(mn >= board.length * board[0].length) { //all knights placed
      board[r][c] = mn;
      return true;
    }
    else if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) { //row col out of bounds
      return false;
    }
    else if(board[r][c] != 0) { //knight already placed on spot
      return false;
    }
    else { //spot available
      board[r][c] = mn;
      for(int q = 0; q < moves.length; q++) {
        if(sh(r + moves[q][0], c + moves[q][1], mn+1, q)) {
          return true;
        }
      }
      return false;
    }
  }
  public boolean bnc() {
    for(int q = 0; q < board.length; q++) {
      for(int w = 0; w < board[q].length; w++) {
        if(board[q][w] != 0) {
          return true;
        }
      }
    }
    return false;
  }
  public static void main(String[] args) {
    KnightBoard test = new KnightBoard(5,5);
    System.out.println(test.solve(0,0));
    System.out.println(test);
  }
}
