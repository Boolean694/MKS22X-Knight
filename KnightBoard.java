public class KnightBoard {
  private int[][] board;
  public KnightBoard(int rc, int cc) {
    board = new int[rc][cc];
  }
  public String toString() {
    String s = "";
    for(int q = 0; q < board.length; q++) {
      for(int w = 0; w < board[q].length; w++) {
        s += board[q][w];
      }
      s += "\n";
    }
    return s;
  }
  public static void main(String[] args) {

  }
}
