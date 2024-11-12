package barracksWars.models.units;

public class Gunner extends AbstractUnit {

    private static final int HEALTH = 20;
    private static final int DAMAGE = 20;

    protected Gunner() {
        super(HEALTH, DAMAGE);
    }
}
