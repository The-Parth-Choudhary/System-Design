package DecoratorPattern;

public class PlainPizza implements Pizza  {
    @Override
    public String getDescription() {
        return "Thin Dough";
    }

    @Override
    public Double getCost() {
        return 4.00;
    }
}
