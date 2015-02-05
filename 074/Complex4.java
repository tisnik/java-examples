/* 4th version of complex number class: toString method is overrided */

class Complex {
    private double real;
    private double imag;

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

class Complex4 {
    public static void main(String[] args) {
        Complex c = new Complex();
        c.setReal(10.0);
        c.setImag(2.0);
        System.out.println(c);
    }
}

