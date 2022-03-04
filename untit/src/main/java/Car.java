public class Car implements Vehicle{

    float price;

    public Car(float price){
        this.price = price;
    }

    @Override
    public int getWheels() {
        return 4;
    }

    @Override
    public void drive() {
        System.out.println("Car says: honk honk vrooooooom");
    }

    @Override
    public float getPrice() {
        return this.price;
    }
}
