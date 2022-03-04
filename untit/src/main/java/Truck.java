public class Truck implements Vehicle{

    float price;

    public Truck(float price){
        this.price = price;
    }

    @Override
    public int getWheels() {
        return 18;
    }

    @Override
    public void drive() {
        System.out.println("Truck says: LOUD TRUCK NOISES HOOONNKKKKKKKKK!");
    }

    @Override
    public float getPrice() {
        return this.price;
    }
}
