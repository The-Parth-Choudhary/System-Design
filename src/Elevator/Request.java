package Elevator;

public class Request {
    private int floor;
    private RequestType type;

    public Request(int floor, RequestType type){

    }

    public int getFloor(){
        return floor;
    }

    public RequestType getType(){
        return type;
    }
}
