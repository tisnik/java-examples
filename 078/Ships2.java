/* Ship class hierarchy: common attributes added */

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

public class Ships2 {
    public static void main(String[] args) {
        Ship o1 = new SailingBoat();
        Ship o2 = new Steamboat();
        o1.color = Color.RED;
        o2.color = Color.BLUE;
        if (o1 instanceof SailingBoat)
            ((SailingBoat)o1).numberOfSails = 2;
        if (o2 instanceof MotorShip)
            ((MotorShip)o2).enginePower = 3000;
    }
}


