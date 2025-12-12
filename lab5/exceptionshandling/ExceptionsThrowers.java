package lab5.exceptionshandling;

public class ExceptionsThrowers {
    public ExceptionsThrowers() {
    }

    public void watchTheExceptionIfEven(int number) throws Exception {
        System.out.println("I am throwing an exception of type MyExeption if you sent me an even number");
        if (number % 2 == 0)
            throw new MyException("You sent an even number = " +number);
        else
            System.out.println("No exception, input = " + number);
    }

    public void watchTheExceptionIfOdd(int number) {
        System.out.println("I am throwing an exception of type MyExeption if you sent me an odd number");
        if (number % 2 != 0)
            throw new MyException("You sent an odd number = " + number);
        else
            System.out.println("No exception, input = " + number);
    }

    public void watchTheExceptionIfNegative(int number) throws MyException {
        System.out.println("I am throwing an exception of type MyExeption if you sent me a negative number");
        if (number <0)
            throw new MyException("You sent a negative number = " + number);
        else
            System.out.println("No exception, input = " + number);
    }
}
