package Elevator;

import java.util.Set;

public class Elevator {
    private int floor;
    private Direction direction;
    private Set<Request> requests;

    public Elevator(){

    }

    public boolean addRequest(Request request){
        requests.add(request);
        return true;
    }

    public void step(){
        if (requests.isEmpty()){
            direction = Direction.IDLE;
            return;
        }

        if (direction == Direction.IDLE){
            Request nearest = findNearestRequest();
            direction = nearest.getFloor() > floor ? Direction.UP : Direction.DOWN;
        }

        RequestType type = direction == Direction.UP ? RequestType.PICKUP_UP : RequestType.PICKUP_DOWN;
        Request hallCallRequest = new Request(floor, type);
        Request destinationRequest = new Request(floor, RequestType.DESTINATION);

        if (requests.contains(hallCallRequest) || requests.contains(destinationRequest)){
            requests.remove(hallCallRequest);
            requests.remove(destinationRequest);
            stop();
            return;
        }

        if (!hasRequestAhead(direction)){
            direction = direction == Direction.UP ? Direction.DOWN : Direction.UP;
        }

        if (direction == Direction.UP) {
            floor++;
        }
        else {
            floor--;
        }
    }

    public int getFloor(){
        return floor;
    }

    public Direction getDirection(){
        return direction;
    }

    private boolean hasRequestAhead(Direction direction){
        for (Request req : requests){
            if (direction == Direction.UP && req.getFloor() > floor){
                return true;
            }
            if (direction == Direction.DOWN && req.getFloor() < floor){
                return true;
            }
        }

        return false;
    }

    private Request findNearestRequest() {
        Request nearest = null;
        int minDistance = Integer.MAX_VALUE;

        for (Request req : requests){
            int distance = Math.abs(req.getFloor() - floor);
            if (distance < minDistance) {
                minDistance = distance;
                nearest = req;
            }
        }

        return nearest;
    }

    private void stop(){
    }
}
