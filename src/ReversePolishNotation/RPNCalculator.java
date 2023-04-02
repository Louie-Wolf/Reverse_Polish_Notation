package ReversePolishNotation;

import java.util.Arrays;

public abstract class RPNCalculator {

    /**
     * Calculates a mathematical calculation written in reverse polish notation. And prints it to the console.
     *
     * @param tokens specifies the calculation as String.
     * @param stepByStep specifies if the calculation should be done step by step.
     * @return the result string.
     * @throws IllegalArgumentException if the notation was incorrect formatted.
     * @throws InterruptedException if the thread was interrupted.
     */
    public static String calculate(String tokens, boolean stepByStep) throws IllegalArgumentException, InterruptedException {
        //Setup
        int WAITING_TIME = 200;
        String[] splitTokens = tokens.split("");
        System.out.println("Tokens received: " + Arrays.toString(splitTokens));
        Stack stack = new Stack(splitTokens.length);

        //Variables for calculation
        int leftValue, rightValue, intermediateResult;
        String result = "";
        String operand;

        for (int i = 0; i < splitTokens.length; i++) {
            //Pushes into the stack as long as it is no operand
            if (!splitTokens[i].equals("+") && !splitTokens[i].equals("*")){
                stack.push(splitTokens[i]);

                if (stepByStep){
                    System.out.println("Value Token pushed.\n Stack: " + stack);
                    Thread.sleep(WAITING_TIME);
                }

                continue;
            } else {
                operand = splitTokens[i];

                if (stepByStep){
                    System.out.println("Operand Token: " + operand + " occurred.");
                    Thread.sleep(WAITING_TIME);
                }
            }

            //If it is an operand try to pop the last two values
            try {
                leftValue = Integer.parseInt(stack.pop());
                rightValue = Integer.parseInt(stack.pop());

                if (stepByStep){
                    System.out.println("Values: " + leftValue + " and " + rightValue + " popped for operation.");
                    System.out.println("Stack: " + stack);
                    Thread.sleep(WAITING_TIME);
                }
            } catch (RuntimeException e){
                System.err.println("There is no value on the stack left to perform the operation");
                break;
            }


            //Perform math calculation depending on operand
            if (operand.equals("+")){
                intermediateResult = leftValue + rightValue;
                result = String.valueOf(intermediateResult);

                //Pushs back the result into stack
                stack.push(result);

                if (stepByStep){
                    System.out.println("Addition result got pushed back into stack.");
                    System.out.println("Stack: " + stack);
                    Thread.sleep(WAITING_TIME);
                }
            }
            else if (operand.equals("*")){
                intermediateResult = leftValue * rightValue;
                result = String.valueOf(intermediateResult);

                //Pushs back the result into stack
                stack.push(result);

                if (stepByStep){
                    System.out.println("Multiplication result got pushed back into stack.");
                    System.out.println("Stack: " + stack);
                    Thread.sleep(WAITING_TIME);
                }
            }
        }

        //Checks if there is only one number left
        if (stack.getTopIndex() != 1){
            throw new IllegalArgumentException("Too less operands! There is more than one number one the stack!");
        }


        if (stepByStep){
            System.out.println("<==============>");
            System.out.println("Calculation completed!");
            System.out.println("Stack: " + stack);
            Thread.sleep(WAITING_TIME);
        }

        String endResult = stack.pop();
        System.out.println("Result of calculation: " + endResult);
        return endResult;
    }
}
