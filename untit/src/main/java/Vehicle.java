/**
 * This interface is used to create a template for a variety of vehicles with similar features
 */
public interface Vehicle {

    //Return how many wheels the vehicle has
    int getWheels();

    //Re-enact the driving sounds of given vehicle
    void drive();

    //Give price of vehicle
    float getPrice();
}
