public class Account {

  private double balance;
  private double rent;

  public Account(double balance, double rent) throws Exception {
    if (balance < 0) {
      throw new AccountExceptions.NegativeBalanceException();
    }
    if(rent < 0) {
      throw new AccountExceptions.NegativeRentException();
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

  public void deposit(double amount) throws Exception {
    if(amount <= 0){
      throw new AccountExceptions.NotAllowedAmountException();
    }
    balance += amount;
  }

  public void withdraw(double amount) throws Exception {
    if(amount > balance){
      throw new AccountExceptions.AmountExceedsAllowedMaxException();
    }
    if(amount <= 0){
      throw new AccountExceptions.NotAllowedAmountException();
    }
    balance -= amount;
  }

  public boolean transfer(Account target, int amount) throws Exception {
    if(amount > balance){
      throw new AccountExceptions.AmountExceedsAllowedMaxException();
    }
    return true;
  }
}
