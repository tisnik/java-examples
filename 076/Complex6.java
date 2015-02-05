/* 6th version of complex number class: constructor overloading */

class Complex {
    private double real;
    private double imag;

    public Complex() {
        this(0.0);
    }

    public Complex(double real) {
        this(real, 0.0);
    }

    public Complex(double real, double imag) {
        setReal(real);
        setImag(imag);
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public double getReal() {
        return this.real;
    }

    public double getImag() {
        return this.imag;
    }

    @Override
    public String toString() {
        return "c=" + getReal() + "+" + getImag() +"i";
    }
}

class Complex6 {
    public static void main(String[] args) {
        Complex c = new Complex(10.0, 2.0);
        System.out.println(c);
    }
}

