package FactoryPattern;

public class RocketShipFactory implements EnemyShipFactoryInterface {
    public EnemyShip createShip() {
        return new RocketEnemyShip();
    }
}
