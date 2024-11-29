package battleShip;

public class Ship {
    private String name;
    private String type;
    private int health;
    private int ammunition;
    private int hitStrength;


    public Ship(String name, String type, int health, int ammunition, int hitStrength) {
        this.name = name;
        this.type = type;
        this.health = health;
        this.ammunition = ammunition;
        this.hitStrength = hitStrength;
    }

    public void attack(Ship ship) {
        this.ammunition -= this.hitStrength;
    }

    public void takeDamage(Ship ship) {
        this.health -= ship.getHitStrength();
    }

    public String getName() {
        return name;
    }


    public String getType() {
        return type;
    }


    public int getHealth() {
        return health;
    }

    public int getAmmunition() {
        return ammunition;
    }



    public int getHitStrength() {
        return hitStrength;
    }


}
