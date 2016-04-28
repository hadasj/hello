package cz.i;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static cz.i.Calculator.Operation;

import org.junit.Test;


/**
 * @author jan.hadas@i.cz
 */
public class CalculatorTest {
  private Calculator calculator = new Calculator();


  @Test
  public void should_add_two_numbers() {
    assertEquals(7, calculator.compute(3,4, Operation.PLUS), 0);
  }

  @Test
  public void should_substract_two_numbers() {
    assertEquals(-984, calculator.compute(2, 986, Operation.MINUS), 0);
  }

  @Test
  public void should_multiply_three_numbers() {
    double partialResult = calculator.compute(16, 32, Operation.MULTIPLY);
    assertEquals(32972.8, calculator.compute(partialResult, 64.4, Operation.MULTIPLY), 0);
  }

  @Test
  public void should_divide_by_nonzero() {
    assertEquals(0.037, calculator.compute(1, 27, Operation.DIVIDE), 0.001);
  }
  
  @Test
  public void should_return_infinity_when_dividing_by_zero() {
     assertEquals(Double.POSITIVE_INFINITY, calculator.compute(87, 0, Operation.DIVIDE), 0);
  }
  
  @Test
  public void should_count_power_for_base_number_2 () {
    assertEquals(65536, calculator.compute(2, 16, Operation.POWER), 0);
  }
  
  @Test
  public void should_compute_square() {
    assertEquals(2, calculator.compute(65536, 1/16.0, Operation.POWER), 0);
  }
}
