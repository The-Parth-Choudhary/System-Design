package FactoryPattern;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("What type of Ship? (U / R / B)");

        if (userInput.hasNextLine()) {
            String typeOfShip = userInput.nextLine();

            // Client only knows about the provider and the interface
            EnemyShipFactoryInterface factory = EnemyShipFactoryProvider.getFactory(typeOfShip);

            if (factory != null) {
                EnemyShip theEnemy = factory.createShip();
                doStuffEnemy(theEnemy);
            } else {
                System.out.println("Please enter U, R, or B next time");
            }
        }
    }

    public static void doStuffEnemy(EnemyShip enemyShip) {
        enemyShip.displayEnemyShip();
        enemyShip.followHeroShip();
        enemyShip.enemyShipShoots();
    }
}
