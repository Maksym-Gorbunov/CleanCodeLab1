public class AccountException extends Exception{

  public static class UnsuportedBalanceException extends Exception{
    public UnsuportedBalanceException(){
      super("Balance value not valid, can't be below zero.");
    }
  }

}
