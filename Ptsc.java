class Ptsc {

  private int numberOfPlayers;
  private double buyIn;

  public Ptsc(int numberOfPlayers, double buyIn) {
    this.numberOfPlayers = numberOfPlayers;
    this.buyIn = buyIn;
  }

  public static void main(String[] args) {
    Ptsc ptsc = new Ptsc(5, 30);
    ptsc.printPlayerWinnings();
  }

  public void printPlayerWinnings() {
    // Even amount of players
    if (this.numberOfPlayers % 2 == 0) {
      
      for (int i = 1; i < this.numberOfPlayers + 1; i++) {
        if (i <= this.numberOfPlayers / 2) {
          System.out.println("Player " + i + " : Wins $");
        } else if (i > this.numberOfPlayers / 2) {
          System.out.println("Player " + i + " : Loses $");
        }
      }

    }
    // Odd amount of players
    else if (this.numberOfPlayers % 2 == 1) {
      double base  = (double) 100 / this.numberOfPlayers;
      int mid = getMiddleNumber(numberOfPlayers);
      double t = (double) base/(this.numberOfPlayers - mid);
      double pot = this.buyIn * this.numberOfPlayers;
      for (int i = 1; i < this.numberOfPlayers + 1; i++) {
        double percentOfPotWon = (double) (base + ((mid - i) * t))/100;
        System.out.println(pot * percentOfPotWon);
      }
    }

  }

  public static int getMiddleNumber(int n) {
    if (n % 2 == 0) {
      throw new IllegalArgumentException("The input number must be odd.");
    }
    return (n / 2) + 1;
  }

}