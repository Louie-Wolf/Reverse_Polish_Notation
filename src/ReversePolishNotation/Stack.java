package ReversePolishNotation;

import java.util.Arrays;

public class Stack {
    private final String[] stack;

    private int topIndex = 0;

    public int getTopIndex() {
        return topIndex;
    }

    /**
     * Constructs a Stack Object containing strings.
     *
     * @param stackSize specifies the size of the stack.
     */
    public Stack(int stackSize) {
        stack = new String[stackSize];
        stack[0] = "$";
        for (int i = 1; i < stack.length; i++) {
            stack[i] = "\0";
        }
    }

    /**
     * Pops the top element from of the stack and returns it.
     *
     * @return the top element.
     */
    public String pop(){
        if (topIndex < 0){
            throw new IllegalArgumentException("Tried to pop an element although stack is empty!");
        }

        String poppedString = stack[topIndex];
        stack[topIndex] = "\0";
        topIndex--;
        return poppedString;
    }

    /**
     * Pushes a new element on top of the stack.
     *
     * @param pushedString specifies the string to be pushed on the stack.
     */
    public void push(String pushedString){
        topIndex++;
        if (topIndex >= stack.length - 1){
            throw new IllegalArgumentException("ReversePolishNotation.Stack is full!");
        }
        stack[topIndex] = pushedString;
    }

    @Override
    public String toString(){
        return Arrays.toString(stack);
    }
}
