package FactoryPattern;

public class BigUFOShipFactory implements EnemyShipFactoryInterface {
    public EnemyShip createShip() {
        return new BigUFOEnemyShip();
    }
}
