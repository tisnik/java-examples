/* Ship class hierarchy: some classes in the hierarchy should be abstract */

import java.awt.Color;

interface Drawable {
    public void draw();
}

abstract class Ship implements Drawable {
    public Color color;
    public String name;
}

class SailingBoat extends Ship {
      public int numberOfSails;

      public void draw() {
          System.out.println("SailingBoat with " + numberOfSails + " sails");
      }
}

abstract class MotorShip extends Ship {
    public int enginePower;

    public void draw() {
        System.out.println("Motor ship with power " + enginePower + " kW");
    }
}

class Steamboat extends MotorShip {
}

public class Ships6 {
    public static void main(String[] args) {
        Ship[] convoy = {
            new SailingBoat(),
            new Steamboat(),
            new SailingBoat(),
        };
        for (Ship ship : convoy) {
            ship.draw();
        }
    }
}

