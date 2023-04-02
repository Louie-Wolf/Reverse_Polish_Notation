import java.util.Arrays;

public abstract class RPNCalculator {

    public static void calculate(String tokens, boolean stepByStep){
        String[] splitTokens = tokens.split("");
        System.out.println("Tokens: " + Arrays.toString(splitTokens));
        Stack stack = new Stack();

        int leftValue, rightValue, intermediateResult;
        String result = "";
        String operand;

        for (int i = 0; i < splitTokens.length; i++) {
            if (!splitTokens[i].equals("+") && !splitTokens[i].equals("*")){
                stack.push(splitTokens[i]);
                continue;
            } else {
                operand = splitTokens[i];
            }

            leftValue = Integer.parseInt(stack.pop());
            rightValue = Integer.parseInt(stack.pop());

            if (operand.equals("+")){
                intermediateResult = leftValue + rightValue;
                result = String.valueOf(intermediateResult);
                stack.push(result);
            }
            else if (operand.equals("*")){
                intermediateResult = leftValue * rightValue;
                result = String.valueOf(intermediateResult);
                stack.push(result);
            }
        }

        System.out.println(stack.pop());
    }
}
