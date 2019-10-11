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

  ///////////////////////////// Calculate Interest ////////////////////////////////////////

  @Test
  public void calculateInterestWithZeroValues() throws Exception {
    account = new Account(0, 0);
    double interestRateExpected = account.getBalance() * (account.getRent() / 100);   // 0
    double interestRateActual = account.calculateInterest();
    assertEquals(interestRateExpected, interestRateActual, 0.01);/
  }

  @Test
  public void calculateInterest() throws Exception {
    double interestRateExpected = account.getBalance() * (account.getRent() / 100);   // 50
    double interestRateActual = account.calculateInterest();
    assertEquals(interestRateExpected, interestRateActual, 0.01);
  }

  ///////////////////////////// Transfer ////////////////////////////////////////
  @Test
  public void transferReceive() throws Exception {
    Account target = new Account(0, 0);
    double balance = target.getBalance();
    double amount = 10;
    boolean transaction = account.transfer(target, amount);
    double expected = balance + amount;
    double actual = target.getBalance();
    assertEquals(expected, actual, 0.01);
  }

  @Test
  public void transferSend() throws Exception {
    Account target = new Account(0, 0);
    double balance = account.getBalance();
    double amount = 10;
    boolean transaction = account.transfer(target, amount);
    double expected = balance - amount;
    double actual = account.getBalance();
    assertEquals(expected, actual, 0.01);
  }

  @Test
  public void transferCastNullPointerException() throws Exception {
    assertThrows(NullPointerException.class, () -> {
      account.transfer(null, 100);
    });
  }

  @Test
  public void transferCastNotAllowedAmountException() throws Exception {
    Account target = new Account(0, 0);
    assertThrows(AccountExceptions.NotAllowedAmountException.class, () -> {
      account.transfer(target, -1);
    });
  }

  @Test
  public void transferCastAmountExceedsAllowedMaxException() throws Exception {
    Account target = new Account(0, 0);
    assertThrows(AccountExceptions.AmountExceedsAllowedMaxException.class, () -> {
      account.transfer(target, 2000);
    });
  }

  @Test
  public void transfer() throws Exception {
    Account target = new Account(0, 0);
    boolean transaction = account.transfer(target, 10);
    assertEquals(true, transaction);
  }

  ///////////////////////////// Withdraw ////////////////////////////////////////
  @Test
  public void withdrawCastAmountExceedsAllowedMaxException() {
    assertThrows(AccountExceptions.AmountExceedsAllowedMaxException.class, () -> {
      account.withdraw(2000);
    });
  }

  @Test
  public void withdrawCastNotAllowedAmountException() {
    assertThrows(AccountExceptions.NotAllowedAmountException.class, () -> {
      account.withdraw(-50);
      account.withdraw(0);
    });
  }

  @Test
  public void withdraw() throws Exception {
    double amount = 50;
    double balance = account.getBalance();
    double expected = balance - amount;
    account.withdraw(amount);
    double current = account.getBalance();
    assertEquals(expected, current, 0.01);
  }

  ///////////////////////////// Deposit ////////////////////////////////////////
  @Test
  public void depositCastNotAllowedAmountException() {
    assertThrows(AccountExceptions.NotAllowedAmountException.class, () -> {
      account.deposit(-50);
      account.deposit(0);
    });
  }

  @Test
  public void deposit() throws Exception {
    double amount = 50;
    double balance = account.getBalance();
    double expected = balance + amount;
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
