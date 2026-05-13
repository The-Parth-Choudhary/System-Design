package BuilderPattern;

public interface RobotBuilder {

    void buildRobotHead();

    void buildRobotArms();

    void buildRobotTorso();

    void buildRobotLegs();

    Robot getRobot();
}
