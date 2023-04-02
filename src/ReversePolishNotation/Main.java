package ReversePolishNotation;

public class Main {
    public static void main(String[] args) {
        try {
            RPNCalculator.calculate("31+78+987+1214++7++++++", true);
        } catch (InterruptedException e){
            System.err.println("Thread got interrupted!");
        }

    }
}
