package ReversePolishNotation;

import java.util.Arrays;

public abstract class RPNCalculator {

    public static String calculate(String tokens, boolean stepByStep) throws RuntimeException{
        //SETUP
        String[] splitTokens = tokens.split("");
        System.out.println("Tokens received: " + Arrays.toString(splitTokens));
        Stack stack = new Stack();

        //VARS
        int leftValue, rightValue, intermediateResult;
        String result = "";
        String operand;

        for (int i = 0; i < splitTokens.length; i++) {
            //Pushes into the stack as long as it is no operand
            if (!splitTokens[i].equals("+") && !splitTokens[i].equals("*")){
                stack.push(splitTokens[i]);
                continue;
            } else {
                operand = splitTokens[i];
            }

            //If it is an operand try to pop the last two values
            try {
                leftValue = Integer.parseInt(stack.pop());
                rightValue = Integer.parseInt(stack.pop());
            } catch (RuntimeException e){
                System.err.println("There is no value on the stack left to perform the operation");
                break;
            }


            //Perform math calculation depending on operand
            if (operand.equals("+")){
                intermediateResult = leftValue + rightValue;
                result = String.valueOf(intermediateResult);
                //Push back result into stack
                stack.push(result);
            }
            else if (operand.equals("*")){
                intermediateResult = leftValue * rightValue;
                result = String.valueOf(intermediateResult);
                stack.push(result);
            }
        }
        String endResult = stack.pop();
        System.out.println(endResult);
        return endResult;
    }
}
