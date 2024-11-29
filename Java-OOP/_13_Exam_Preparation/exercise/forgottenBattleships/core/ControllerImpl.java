package forgottenBattleships.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import forgottenBattleships.entities.battleship.Battleship;
import forgottenBattleships.entities.battleship.PirateBattleship;
import forgottenBattleships.entities.battleship.RoyalBattleship;
import forgottenBattleships.entities.battlezone.BattleZone;
import forgottenBattleships.entities.battlezone.BattleZoneImpl;

import static forgottenBattleships.common.ConstantMessages.*;
import static forgottenBattleships.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private Collection<BattleZone> battleZones;

    public ControllerImpl() {
        this.battleZones = new ArrayList<>();
    }

    @Override
    public String addBattleZone(String battleZoneName, int capacity) {

        BattleZone battleZone = getBattleZoneByName(battleZoneName);

        if (battleZone != null) {
            throw new IllegalArgumentException(BATTLE_ZONE_EXISTS);
        }

        battleZone = new BattleZoneImpl(battleZoneName, capacity);
        this.battleZones.add(battleZone);

        return String.format(SUCCESSFULLY_ADDED_BATTLE_ZONE, battleZoneName);
    }

    @Override
    public BattleZone getBattleZoneByName(String battleZoneName) {
        return this.battleZones.stream()
                               .filter(bz -> bz.getName().equals(battleZoneName))
                               .findFirst()
                               .orElse(null);
    }

    @Override
    public String addBattleshipToBattleZone(String battleZoneName,
                                            String shipType,
                                            String shipName,
                                            int health) {

        BattleZone battleZone = getBattleZoneByName(battleZoneName);

        if (battleZone == null) {
            throw new NullPointerException(BATTLE_ZONE_DOES_NOT_EXISTS);
        }

        Battleship ship = battleZone.getBattleshipByName(shipName);

        if (ship != null) {
            throw new IllegalArgumentException(SHIP_EXISTS);
        }

        Battleship battleship = switch (shipType) {
            case "RoyalBattleship" -> new RoyalBattleship(shipName, health);
            case "PirateBattleship" -> new PirateBattleship(shipName, health);
            default -> throw new IllegalArgumentException(INVALID_SHIP_TYPE);
        };

        battleZone.addBattleship(battleship);

        return String.format(SUCCESSFULLY_ADDED_SHIP, shipType, shipName, battleZone.getName());
    }

    @Override
    public String startBattle(String battleZoneName,
                              String attackingShip,
                              String shipUnderAttack) {

        BattleZone battleZone = getBattleZoneByName(battleZoneName);

        Battleship attackShip = battleZone.getBattleshipByName(attackingShip);
        Battleship underAttackShip = battleZone.getBattleshipByName(shipUnderAttack);

        if (attackShip == null || underAttackShip == null) {
            throw new IllegalArgumentException(INSUFFICIENT_COUNT);
        }

        if (attackShip.getClass().getSimpleName().equals(underAttackShip.getClass().getSimpleName())){
            //TODO throw something???
        }

        if (attackShip.getAmmunition() > 0) {
            attackShip.attack(underAttackShip);
            underAttackShip.takeDamage(attackShip);
        }

        if (underAttackShip.getHealth() <= 0) {
            battleZone.removeBattleShip(underAttackShip);
        }

        List<String> shipNames = battleZone.getShips()
                                           .stream()
                                           .map(Battleship::getName)
                                           .toList();

        return BATTLE_CONTINUES.formatted(battleZone.getName()) + String.join(", ", shipNames);
    }

    @Override
    public String getStatistics() {

        StringBuilder sb = new StringBuilder();

        this.battleZones.forEach(battleZone -> {
            sb.append(SHIPS_IN_BATTLE_ZONE.formatted(battleZone.getName()));

            if (battleZone.getShips().size() == 1) {
                Battleship battleship = battleZone.getShips().iterator().next();
                sb.append(System.lineSeparator());
                sb.append(SHIP_WINS.formatted(battleship.getName()));
            }else {
                battleZone.getShips().forEach(ship -> {
                    sb.append(System.lineSeparator());
                    sb.append(SHIP_INFO.formatted(ship.getName(), ship.getHealth(), ship.getAmmunition()));
                });
            }

            sb.append(System.lineSeparator());
        });


        return sb.toString().trim();
    }
}

