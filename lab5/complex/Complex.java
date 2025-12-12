package lab5.complex;


public class Complex <T extends Number> {

    private T real;
    private T imag;


    public Complex(T real , T imag){
        this.real=real;
        this.imag = imag;
    }

    public Complex<Double> add (Complex<T > Other ){
        double r = this.real.doubleValue() + Other.getReal().doubleValue();//why ----+ WHY t 
        double i = this.imag.doubleValue() + Other.getImag().doubleValue();
        return new Complex<Double>(r, i);

    }

    public Complex<Double> subtract (Complex<T > Other ){
        double r = this.real.doubleValue() - Other.getReal().doubleValue();
        double i = this.imag.doubleValue() - Other.getImag().doubleValue();
        return new Complex<Double>(r, i);

    }

    public Complex<Double> multiply (Complex<T > Other ){
        double r = (this.real.doubleValue() * Other.getReal().doubleValue())
                - (this.imag.doubleValue() * Other.getImag().doubleValue());
        double i = (this.real.doubleValue() * Other.getImag().doubleValue())
                + (this.imag.doubleValue() * Other.getReal().doubleValue());
        return new Complex<Double>(r, i);

    }
    
    public T getReal() {return real;}
    public T getImag() {return imag;}
    
}
