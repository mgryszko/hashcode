import java.util.*;

public class Rides {

    ArrayList<Ride> rides = new ArrayList<>();

    public void addRide(Ride ride) {
        rides.add(ride);
    }

    public void sort() {
        Collections.sort(rides);
    }

    public Ride findClosestTo(Car car) {
        int distance = 1000000000;
        Ride prospectRide = null;
        for (Ride ride: rides) {
            int newDist = Math.abs(car.position.x - ride.startPos.x) + Math.abs(car.position.y - ride.startPos.y);
            if(newDist < distance) {
                distance = newDist;
                prospectRide = ride;
            }
        }

        rides.remove(prospectRide);
        return prospectRide;
    }
}
