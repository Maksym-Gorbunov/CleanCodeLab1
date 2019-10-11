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

  @Test
  public void getBalance(){
    double expected = 1000;
    double actual = account.getBalance();
    assertEquals(expected, actual,.01);
  }

  @Test
  public void getRent(){
    double expected = 5;
    double actual = account.getRent();
    assertEquals(expected, actual,.01);
  }

  @Test
  public void constructor(){
    double expectedBalance = 1000;
    double expectedRent = 5;
    double actualBalance = account.getBalance();
    double actualRent = account.getRent();
    assertEquals(expectedBalance, actualBalance,0.01);
    assertEquals(expectedRent, actualRent,0.01);
  }

  @Test
  public void constructorCastNegativBalanceException(){
    assertThrows(Exception.class, () -> {
      account = new Account(-1, 5);
    });
  }

  @Test
  public void constructorCastNegativRentException(){
    assertThrows(Exception.class, () -> {
      account = new Account(1000, -5);
    });
  }


}
