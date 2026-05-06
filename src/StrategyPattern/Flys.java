package StratergyPattern;

public interface Flys {

    String fly();
}

class ItFlys implements Flys{

    @Override
    public String fly() {
        return "Flying high";
    }
}

class CantFlys implements Flys{

    @Override
    public String fly() {
        return "I can't fly";
    }
}
