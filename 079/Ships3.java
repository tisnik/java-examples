/* Ship class hierarchy: basic RTTI (Runtime Type Identification) */

import java.awt.Color;

class Ship {
    public Color color;
    public String name;
}

class SailingBoat extends Ship {
      public int numberOfSails;
}

class MotorShip extends Ship {
    public int enginePower;
}

class Steamboat extends MotorShip {
}

public class Ships3 {
    public static void main(String[] args) {
        Ship o1 = new SailingBoat();
        Ship o2 = new Steamboat();
        Ship o3 = new Ship();
        System.out.println(o1.getClass().getName());
        System.out.println(o2.getClass().getName());
        System.out.println(o3.getClass().getName());
    }
}

