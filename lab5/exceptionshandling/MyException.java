package lab5.exceptionshandling;

import java.util.InputMismatchException;

public class MyException extends InputMismatchException{

    public MyException (String message){
        super(message);
    }
	
}