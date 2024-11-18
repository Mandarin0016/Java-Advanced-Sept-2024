package org.example;

public class Axe {

    private int attackPoints;
    private int durabilityPoints;

    public Axe(int attack, int durability) {
        this.attackPoints = attack;
        this.durabilityPoints = durability;
    }

    public int getAttackPoints() {
        return this.attackPoints;
    }

    public int getDurabilityPoints() {
        return this.durabilityPoints;
    }

    // Ще тествам:
    // 1. Ако имам брадва с 10 точки издръжливост и атакувам - точките ще станат 9
    // 2. Ако имам брадва с 0 точки издръжливост и атакувам - получавам грешка
    public void attack(Dummy target) {
        if (this.durabilityPoints <= 0) {
            throw new IllegalStateException("Axe is broken.");
        }

        target.takeAttack(this.attackPoints);
        this.durabilityPoints -= 1;
    }
}
