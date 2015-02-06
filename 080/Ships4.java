/* Ship class hierarchy: some classes in the hierarchy should be abstract */

import java.awt.Color;

abstract class Ship {
    public Color color;
    public String name;
}

class SailingBoat extends Ship {
      public int numberOfSails;
}

abstract class MotorShip extends Ship {
    public int enginePower;
}

class Steamboat extends MotorShip {
}

public class Ships4 {
    public static void main(String[] args) {
    }
}

