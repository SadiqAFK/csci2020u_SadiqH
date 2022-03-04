public class Motorcycle implements Vehicle{

    float price;

    public Motorcycle(float price){
        this.price = price;
    }

    @Override
    public int getWheels() {
        return 2;
    }

    @Override
    public void drive() {
        System.out.println("Motorcycle says: nyyooooooooooooooom");
    }

    @Override
    public float getPrice() {
        return this.price;
    }
}
