/* 5th version of complex number class: added constructor */

class Complex {
    private double real;
    private double imag;

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

class Complex5 {
    public static void main(String[] args) {
        Complex c = new Complex(10.0, 2.0);
        System.out.println(c);
    }
}

