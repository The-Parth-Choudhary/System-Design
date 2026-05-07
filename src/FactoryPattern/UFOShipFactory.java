package FactoryPattern;

public class UFOShipFactory implements EnemyShipFactoryInterface {
    public EnemyShip createShip() {
        return new UFOEnemyShip();
    }
}
