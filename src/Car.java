public class Car
{
  Position position;

  public int score(Ride ride)
  {
    int distanceToRide = position.distanceTo(ride.startPos);
    int waitTime = ride.earliestStart - distanceToRide;
    int rideDistance = ride.distance();

    return 0;
  }
}
