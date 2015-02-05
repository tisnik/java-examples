/* 1st version of complex number class: just a data record */

class Complex {
    public double re;
    public double im;
}

class Complex1 {
    public static void main(String[] args) {
        Complex c = new Complex();
        c.re = 10.0;
        c.im = 2.0;
        System.out.println("c="+c.re+"+"+c.im+"i");
    }
}

