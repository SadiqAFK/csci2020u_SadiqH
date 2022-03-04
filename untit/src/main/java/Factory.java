public class Factory {

    /**
     * @param wheels : Input to decide which vehicle is needed by user
     * @return -> a vehicle object matching the requirements given by user
     */
    public Vehicle getVehicle(int wheels){

        //Motorcycle condition
        if(wheels == 2){
            return new Motorcycle(2450);
        }
        //Car condition
        else if(wheels == 4){
            return new Car(7500);
        }
        //Truck condition
        else if(wheels == 18){
            return new Truck(78000);
        }
        //Default
        else{
            return null;
        }

    }
}
