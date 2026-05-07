package FactoryPattern;

public class EnemyShipFactoryProvider {
    public static EnemyShipFactoryInterface getFactory(String type) {
        switch (type) {
            case "U": return new UFOShipFactory();
            case "R": return new RocketShipFactory();
            case "B": return new BigUFOShipFactory();
            default: return null;
        }
    }
}
