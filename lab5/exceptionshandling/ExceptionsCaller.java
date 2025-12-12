package lab5.exceptionshandling;

public class ExceptionsCaller {
    public static void main(String[] args) {
        ExceptionsThrowers test = new ExceptionsThrowers();

        try {
            test.watchTheExceptionIfEven(-9);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        /** */

        try {
            test.watchTheExceptionIfOdd(8);
        }
        catch (MyException e){
            e.printStackTrace();
        }
        
        try {
            test.watchTheExceptionIfNegative(6);
        }
        catch (MyException e){
            e.printStackTrace();
        }

        try{
            test.watchTheExceptionIfEven(1);  //  excecuted
            test.watchTheExceptionIfOdd(7); //  excecuted 
            test.watchTheExceptionIfNegative(6); // not excecuted
        }
        catch (MyException e){
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally{
            System.out.println("Caught exceptions");
          //return;
        }
        
        //System.out.println("Alaa");
    }
}
