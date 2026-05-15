package DecoratorPattern;B

abstract class ToppingDecorator implements Pizza {

    protected Pizza tempPizza;

    public ToppingDecorator(Pizza newPizza){
        tempPizza = newPizza;
    }

    public String getDescription(){
        return tempPizza.getDescription();
    }

    public Double getCost(){
        return tempPizza.getCost();
    }
}
