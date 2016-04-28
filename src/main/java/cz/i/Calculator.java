package cz.i;

/**
 * @author jan.hadas@i.cz
 */
public class Calculator {
  enum Operation {
    PLUS, MINUS, MULTIPLY, DIVIDE, POWER
  }


  public double compute(double a, double b, Operation operation) {
    if (operation == null) {
      throw new IllegalArgumentException("Missing operation");
    }

    switch (operation) {
      case PLUS:
        return a + b;
      case MINUS:
        return a - b;
      case MULTIPLY:
        return a * b;
      case DIVIDE:
        return a / b;
      case POWER:
        return Math.pow(a, b);
      default:
        throw new IllegalArgumentException("Unknown operation: " + operation.name());
    }
  }

}
