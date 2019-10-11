public class Account {

  private double balance;
  private double rent;

  public Account(double balance, double rent) throws Exception {
    if (balance < 0) {
      throw new AccountException.UnsuportedBalanceException();
    }
    this.balance = balance;
    this.rent = rent;
  }


  public double getBalance() {
    return balance;
  }

  public double getRent() {
    return rent;
  }
}
