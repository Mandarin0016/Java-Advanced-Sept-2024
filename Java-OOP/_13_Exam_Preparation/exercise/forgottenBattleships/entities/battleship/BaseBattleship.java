package forgottenBattleships.entities.battleship;

import static forgottenBattleships.common.ExceptionMessages.SHIP_NAME_NULL_OR_EMPTY;

public abstract class BaseBattleship implements Battleship {

    private String name;
    private int health;
    private int ammunition;
    private int hitStrength;
    /*
          ammunition – int
       the ammunition amount of the ship. If it drops below 0 (zero) set it to 0 (zero).

          hitStrength – int
       the amount of damage the ship inflicts.

     */

    public BaseBattleship(String name, int health, int ammunition, int hitStrength) {
        this.setName(name);
        this.setHealth(health);
        this.setAmmunition(ammunition);
        this.hitStrength = hitStrength;
    }

    @Override
    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(SHIP_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        if (health <= 0) {
            health = 0;
        }
        this.health = health;
    }

    @Override
    public int getAmmunition() {
        return ammunition;
    }

    private void setAmmunition(int ammunition) {
        if (ammunition <= 0) {
            ammunition = 0;
        }
        this.ammunition = ammunition;
    }

    @Override
    public int getHitStrength() {
        return hitStrength;
    }

    private void setHitStrength(int hitStrength) {
        this.hitStrength = hitStrength;
    }

    @Override
    public void attack(Battleship attackedShip) {
        this.setAmmunition(this.ammunition - this.hitStrength);
//        attackedShip.takeDamage(this);
    }

    @Override
    public void takeDamage(Battleship enemy) {
        this.setHealth(this.health - enemy.getHitStrength());
    }
}
