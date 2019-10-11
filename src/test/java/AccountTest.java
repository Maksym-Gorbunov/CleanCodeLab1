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
    double expected = 100;
    Account a = new Account(expected, 5);
    double actual = a.getBalance();
    assertEquals(expected, actual,2);
  }


}
