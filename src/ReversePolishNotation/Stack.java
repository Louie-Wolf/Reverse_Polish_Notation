package ReversePolishNotation;

import java.util.Arrays;

public class Stack {
    private final String[] stack;

    public int getTopIndex() {
        return topIndex;
    }

    private int topIndex = 0;

    public Stack(int stackSize) {
        stack = new String[stackSize];
        stack[0] = "$";
        for (int i = 1; i < stack.length; i++) {
            stack[i] = "\0";
        }
    }


    public String pop(){
        if (topIndex < 0){
            throw new IllegalArgumentException("Tried to pop an element although stack is empty!");
        }

        String poppedChar = stack[topIndex];
        stack[topIndex] = "\0";
        topIndex--;
        return poppedChar;
    }

    public void push(String pushedChar){
        topIndex++;
        if (topIndex >= stack.length - 1){
            throw new IllegalArgumentException("ReversePolishNotation.Stack is full!");
        }
        stack[topIndex] = pushedChar;
    }

    @Override
    public String toString(){
        return Arrays.toString(stack);
    }
}
