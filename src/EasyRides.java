import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.*;

public class EasyRides
{
    final Set<Ride> rides = new TreeSet<>();

    public void addRide(Ride ride) {
        rides.add(ride);
    }

    public Ride findClosestTo(Car car, int bonus) {
        Ride bestRide = rides.stream()
          .filter(ride -> car.score(ride, bonus) > 0)
          .findFirst()
          .orElse(null);

        if (bestRide != null) {
            rides.remove(bestRide);
        }

        return bestRide;
    }

    @Override public String toString()
    {
        return new ToStringBuilder(this)
          .append("rides", rides)
          .toString();
    }
}
