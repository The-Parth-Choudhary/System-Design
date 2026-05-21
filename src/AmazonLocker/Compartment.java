package AmazonLocker;

public class Compartment {
    private Size size;
    private boolean isOccupied;

    public boolean isOccupied(){
        return this.isOccupied;
    }

    public void markOccupied(){
        this.isOccupied = true;
    }

    public void markFree(){
        this.isOccupied = false;
    }

    public void open(){

    }

    public Size getSize(){
        return this.size;
    }
}
