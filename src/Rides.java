import java.util.*;

public class Rides {

    int totalRides = 0;
    private final int arbitrarySearchSize = 10;
    final List<Ride>[] rides = new List[10000];

    public void addRide(Ride ride) {
        if(rides[ride.distanceFromStart] == null) {
            rides[ride.distanceFromStart] = new ArrayList<>();
        }

        totalRides++;
        rides[ride.distanceFromStart].add(ride);
    }

    public List<Ride> findClosestTo(Car car) {
        Position position = car.position;
        int distanceFromZero = position.x + position.y;

        int available = 1;
        int index = 0;
        List<Ride> prospectRides = new ArrayList<>();
        while(available > 0) {
            if(distanceFromZero - index > 0 && rides[distanceFromZero - index] != null && !rides[distanceFromZero - index].isEmpty()) {
                prospectRides.addAll(rides[distanceFromZero - index]);
            }

            if(distanceFromZero + index < rides.length && rides[distanceFromZero + index] != null && !rides[distanceFromZero + index].isEmpty()) {
                prospectRides.addAll(rides[distanceFromZero + index]);
            }

            available -= prospectRides.size();
            index++;
        }

        return prospectRides;
    }
}
