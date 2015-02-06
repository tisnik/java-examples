/* Ship class hierarchy: 1st version */

class Ship {
}

class SailingBoat extends Ship {
}

class MotorShip extends Ship {
}

class Steamboat extends MotorShip {
}

public class Ships1 {
    public static void main(String[] args) {
        Ship         o1 = new Ship();
        SailingBoat  o2 = new SailingBoat();
        Steamboat    o3 = new Steamboat();
        System.out.println(o1 instanceof Ship);
        System.out.println(o2 instanceof Ship);
        System.out.println(o2 instanceof SailingBoat);
        System.out.println(o3 instanceof Ship);
        System.out.println(o3 instanceof Steamboat);
    }
}

