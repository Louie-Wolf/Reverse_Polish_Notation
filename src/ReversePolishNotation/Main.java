package ReversePolishNotation;

public class Main {
    public static void main(String[] args) {
        try {
            RPNCalculator.calculate("987+", true);
        } catch (InterruptedException e ){
            System.err.println("Thread got interrupted!");
        } catch (IllegalArgumentException f){
            System.err.println("Notation is invalid!");
        }

    }
}
