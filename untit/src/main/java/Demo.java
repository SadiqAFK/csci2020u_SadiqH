public class Demo {

    public static void main (String[] args){

        //Creating a factory that will make all our vehicles
        Factory toyota = new Factory();

        //creating every vehicle type available
        Vehicle car = toyota.getVehicle(4);

        Vehicle semiTruck = toyota.getVehicle(18);

        Vehicle motorcycle = toyota.getVehicle(2);


        //Testing drive() to show objects are instances of different classes
        car.drive();
        semiTruck.drive();
        motorcycle.drive();
    }
}
