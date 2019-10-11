import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

public class AccountTest {
  private Account account;

  @Before
  public void init(){
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
    double expectedRenta = 5;
    Account a = new Account(expected, 5);
    double actual = a.getBalance();
    assertEquals(expected, actual,.01);
  }




}
