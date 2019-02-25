public class KnightBoard {
  private int[][] board;
  private int lrc;
  private int lcc;
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
    return sh(r, c, 1);
  }
  private boolean sh(int r, int c, int mn) {
    if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != 0) { //if knight jumps off the board
      return false;
    }
    else if(mn >= (lrc * lcc)) { //if max num knights reached
      return true;
    }
    else {
      if( //move possible from this spot
      sh(r + 1, c - 2, mn + 1) || //nne
      sh(r + 2, c - 1, mn + 1) || //ene
      sh(r + 2, c + 1, mn + 1) || //ese
      sh(r + 1, c + 2, mn + 1) || //sse
      sh(r - 1, c + 2, mn + 1) || //ssw
      sh(r - 2, c + 1, mn + 1) || //wsw
      sh(r - 2, c - 1, mn + 1) || //wnw
      sh(r - 1, c - 2, mn + 1) //nnw
      ) {
        board[r][c] = mn;
        mn++;
        return true;
      }
      else { //move not possible from this spot
        board[r][c] = 0;
        return false;
      }
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
    KnightBoard test = new KnightBoard(6,6);
    System.out.println(test.solve(0,0));
    System.out.println(test);
  }
}
