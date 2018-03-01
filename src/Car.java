class Car
{
  Position position;

  Car(int x, int y)
  {
    position = new Position(x, y);
  }

  int score(Ride ride, int rideBonus)
  {
    int distanceToRide = distanceTo(ride);
    int rideDistance = ride.distance();

    boolean unableToFinish = distanceToRide + rideDistance > ride.latestFinish;
    if (unableToFinish) return Integer.MIN_VALUE;

    boolean canEarnBonus = distanceToRide <= ride.earliestStart;
    int points = rideDistance + (canEarnBonus ? rideBonus : 0);

    int cost = distanceToRide + waitTimeFor(ride);

    return points - cost;
  }

  int distanceTo(Ride ride)
  {
    return position.distanceTo(ride.startPos);
  }

  private int waitTimeFor(Ride ride)
  {
    return ride.earliestStart - distanceTo(ride);
  }
}
