package ObserverPattern;

import java.text.DecimalFormat;

public class MainThread implements Runnable{
    private int startTime;
    private String stock;
    private Double price;

    private Subject stockGrabber;

    public MainThread(Subject stockGrabber, int newStartTime, String newStock, Double newPrice){
        this.stockGrabber = stockGrabber;
        startTime = newStartTime;
        stock = newStock;
        price = newPrice;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++){
            try{
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            double randNum = (Math.random() * (.06)) - .03;

            DecimalFormat df = new DecimalFormat("#.##");
            price = Double.valueOf(df.format(price + randNum));

            if (stock == "IBM") ((StockGrabber)stockGrabber).setIbmPrice(price);
            if (stock == "AAP") ((StockGrabber)stockGrabber).setAaplPrice(price);
            if (stock == "GOOG") ((StockGrabber)stockGrabber).setGoogPrice(price);

            System.out.println(stock + ": " + price + " " + df.format(randNum ));
            System.out.println();
        }
    }
}
