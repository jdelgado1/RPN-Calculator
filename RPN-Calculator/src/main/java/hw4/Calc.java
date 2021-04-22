
package hw4;




import java.util.Scanner;  // Import the Scanner class


/**
 * A program for an RPN calculator that uses a stack.
 */
public final class Calc {

  /**
   * all fields needed for project including stack, operations and commands.
   */
  private static LinkedStack<Integer> stack = new LinkedStack<>();
  private static final String PLUS = "+";
  private static final String MINUS = "-";
  private static final String TIMES = "*";
  private static final String DIVIDE = "/";
  private static final String MODULO = "%";
  private static final String QUESTION = "?";
  private static final String DOT = ".";
  private static final String EXCLAMATION = "!";

  /**
   * Checks every character of string to see if its a number.
   *
   * @return if string is a number.
   */
  private static boolean isNumeric(String s) {
    boolean result = true;
    int j = 0;
    if (s.charAt(0) == '-') {
      j = 1;
    }
    for (int i = j; i < s.length(); i++) {
      if (Character.isDigit(s.charAt(i))) {
        continue;
      }
      result = false;
      break;
    }
    if ((s.charAt(0) == '-') && (s.length() == 1)) {
      result = false;
    }
    return result;
  }

  /**
   * Checks if string is an operator.
   *
   * @return if string is an operator.
   */
  private static boolean isOperator(String s) {
    boolean result2 = false;
    if (s.equals(PLUS)) {
      result2 = true;
    }
    if (s.equals(MINUS)) {
      result2 = true;
    }
    if (s.equals(TIMES)) {
      result2 = true;
    }
    if (s.equals(DIVIDE)) {
      result2 = true;
    }
    if (s.equals(MODULO)) {
      result2 = true;
    }
    return result2;
  }

  /**
   * Checks string to see if its a command.
   *
   * @return if string is a command.
   */
  private static boolean isCommand(String s) {
    return s.equals(QUESTION) || s.equals(DOT) || s.equals(EXCLAMATION);
  }

  /**
   * Finds the result from the corresponding operation.
   *
   * @return result of operation.
   */
  private static int getResult(String s, int first, int second) {
    int result = 0;
    if (s.equals(PLUS)) {
      result  = first + second;
    }
    if (s.equals(MINUS)) {
      result  = first - second;
    }
    if (s.equals(TIMES)) {
      result  = first * second;
    }
    if (s.equals(DIVIDE)) {
      result  = first / second;
    }
    if (s.equals(MODULO)) {
      result  = first % second;
    }
    return result;
  }





  /**
   * The main function.
   *
   * @param args Not used.
   */
  public static void main(String[] args) {
    //LinkedStack<Integer> stack = new LinkedStack<>();
    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNext()) {
      String input = scanner.next();
      if (isNumeric(input)) {
        int number = Integer.parseInt(input);
        stack.push(number);
      } else if (isOperator(input)) {

        doOperation(input);


      } else if (isCommand(input)) {
        doCommand(input);

        if (input.equals(EXCLAMATION)) {
          return;
        }


      } else {
        System.err.println("ERROR: bad token");
      }
    }


  }






  /**
   * pops a value and calls doOperationWithB to find answer.
   * @param s2 is the string that represent the operation
   */
  private static void doOperation(String s2) {
    if (stack.empty()) {
      System.err.println("ERROR: Not enough arguments.");
    } else {
      int a = stack.top();
      stack.pop();
      if (stack.empty()) {
        System.err.println("ERROR: Not enough arguments.");
        stack.push(a);
      } else {
        doOperationWithB(s2, a);
      }
    }
  }

  /**
   * pops the 2nd value needed for operation and calls getResult to find answer.
   * @param s2 is the string that represent the operation
   */
  private static void doOperationWithB(String s2, int a) {
    int b = stack.top();
    stack.pop();
    if ((s2.equals(DIVIDE) || s2.equals(MODULO))  && a == 0) {
      System.err.println("ERROR: Can't divide by zero.");
      stack.push(b);
      stack.push(a);
    } else {
      int result = getResult(s2, b, a);
      stack.push(result);
    }
  }

  /**
   * carries out the corresponding command.
   * @param s3 is the string that represent the command
   */
  private static void doCommand(String s3) {
    if (s3.equals(QUESTION)) {
      System.out.println(stack.toString());
    }
    if (s3.equals(DOT)) {
      if (stack.empty()) {
        System.err.println("ERROR: no top value.");
      } else {
        System.out.println(stack.top());
      }
    }
  }

}
