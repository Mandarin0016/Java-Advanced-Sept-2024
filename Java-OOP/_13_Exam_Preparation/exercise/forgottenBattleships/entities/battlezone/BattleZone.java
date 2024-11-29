package forgottenBattleships.entities.battlezone;

import java.util.Collection;

import forgottenBattleships.entities.battleship.Battleship;

public interface BattleZone {

    String getName();

    int getCapacity();

    void addBattleship(Battleship ship);

    Battleship getBattleshipByName(String battleshipName);

    void removeBattleShip(Battleship ship);

    Collection<Battleship> getShips();


}
