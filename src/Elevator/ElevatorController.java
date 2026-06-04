package Elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorController {
    private List<Elevator> elevators = new ArrayList<>();

    public ElevatorController(){

    }

    public boolean requestElevator(int floor, RequestType type){
        if (floor < 0 || floor > 9){
            throw new Error("Not a valid floor");
        }

        Request request = new Request(floor, type);
        Elevator best = requestElevator(request);
        return best.addRequest(request);
    }

    public void Step(){
        for (Elevator e : elevators){
            e.step();
        }
    }

    private Elevator requestElevator(Request request){
        Elevator best = findMovingToward(request);
        if (best != null){
            return best;
        }

        best = findNearestIdle(request);
        if (best != null){
            return best;
        }

        return findNearest(request);
    }

    private Elevator findMovingToward(Request request){
        int floor = request.getFloor();
        Direction direction = request.getType() == RequestType.PICKUP_UP ? Direction.UP : Direction.DOWN;

        Elevator nearest = null;
        int minDistance = Integer.MAX_VALUE;

        for(Elevator e : elevators){
            if (e.getDirection() != direction){
                continue;
            }

            if ((e.getDirection() == Direction.UP && e.getFloor() > floor) ||
                    (e.getDirection() == Direction.DOWN && e.getFloor() < floor)){
                continue;
            }

            int distance = Math.abs(e.getFloor() - floor);
            if (distance < minDistance) {
                minDistance = distance;
                nearest = e;
            }
        }

        return nearest;
    }

    private Elevator findNearestIdle(Request request){
        int floor = request.getFloor();

        Elevator nearest = null;
        int minDistance = Integer.MAX_VALUE;

        for(Elevator e : elevators){
            if (e.getDirection() != Direction.IDLE){
                continue;
            }

            int distance = Math.abs(e.getFloor() - floor);
            if (distance < minDistance) {
                minDistance = distance;
                nearest = e;
            }
        }

        return nearest;
    }

    private Elevator findNearest(Request request){
        int floor = request.getFloor();

        Elevator nearest = null;
        int minDistance = Integer.MAX_VALUE;

        for(Elevator e : elevators){
            int distance = Math.abs(e.getFloor() - floor);
            if (distance < minDistance) {
                minDistance = distance;
                nearest = e;
            }
        }

        return nearest;
    }
}
