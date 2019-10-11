import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

public class AccountTest {
  private Account account;

  @Before
  public void init() throws Exception {
    account = new Account(1000, 5);
  }


  ///////////////////////////// Depopsit ////////////////////////////////////////
  @Test
  public void depositCastNotAllowedAmountException(){
    assertThrows(AccountExceptions.NotAllowedAmountException.class, () -> {
      account.deposit(-50);
      account.deposit(0);
    });
  }

  @Test
  public void deposit() throws Exception {
    double amount = 50;
    double balance = account.getBalance();
    double expected = amount + balance;
    account.deposit(amount);
    double current = account.getBalance();
    assertEquals(expected, current, 0.01);
  }

  ///////////////////////////// Getters ////////////////////////////////////////

  @Test
  public void getBalance() {
    double expected = 1000;
    double actual = account.getBalance();
    assertEquals(expected, actual, 0.01);
  }

  @Test
  public void getRent() {
    double expected = 5;
    double actual = account.getRent();
    assertEquals(expected, actual, 0.01);
  }

  ///////////////////////////// Constructor ////////////////////////////////////////
  @Test
  public void constructor() {
    double expectedBalance = 1000;
    double expectedRent = 5;
    double actualBalance = account.getBalance();
    double actualRent = account.getRent();
    assertEquals(expectedBalance, actualBalance, 0.01);
    assertEquals(expectedRent, actualRent, 0.01);
  }

  @Test
  public void constructorCastNegativeBalanceException() {
    assertThrows(Exception.class, () -> {
      account = new Account(-1, 5);
    });
  }

  @Test
  public void constructorCastNegativeRentException() {
    assertThrows(Exception.class, () -> {
      account = new Account(1000, -5);
    });
  }
}
