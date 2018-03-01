import java.util.Collection;
import java.util.List;

class RidesTest {
    public static void main(String[] args) {
        Rides rides = new Rides();

        rides.addRide(new Ride(0, 1, 9,9, 0, 0));
        rides.addRide(new Ride(0, 1, 9,9, 0, 0));
        rides.addRide(new Ride(0, 5, 9,9, 0, 0));
        rides.addRide(new Ride(6, 5, 9,9, 0, 0));
        rides.addRide(new Ride(16, 15, 9,9, 0, 0));
        rides.addRide(new Ride(800, 1000, 9,9, 0, 0));

        List<Ride> rides1 = rides.findClosestTo(new Car(new Position(0, 0)));
        if(rides1.get(0).startPos.x != 0 || rides1.get(0).startPos.y != 1) {
            throw new RuntimeException("Fallo Rides 1");
        }
        if(rides1.get(1).startPos.x != 0 || rides1.get(1).startPos.y != 1) {
            throw new RuntimeException("Fallo Rides 1");
        }



        List<Ride> rides2 = rides.findClosestTo(new Car(new Position(700, 700)));
        if(rides2.get(0).startPos.x != 800 || rides2.get(0).startPos.y != 1000) {
            throw new RuntimeException("Fallo Rides 2");
        }



        List<Ride> rides3 = rides.findClosestTo(new Car(new Position(3, 2)));
        if(rides3.get(0).startPos.x != 0 || rides3.get(0).startPos.y != 5) {
            throw new RuntimeException("Fallo Rides 3");
        }
    }
}
