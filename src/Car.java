class Car
{
  Position position;

  int score(Ride ride, int rideBonus)
  {
    int distanceToRide = position.distanceTo(ride.startPos);
    int rideDistance = ride.distance();

    boolean unableToFinish = distanceToRide + rideDistance > ride.latestFinish;
    if (unableToFinish) return Integer.MIN_VALUE;

    boolean canEarnBonus = distanceToRide <= ride.earliestStart;
    int points = rideDistance + (canEarnBonus ? rideBonus : 0);

    int waitTime = ride.earliestStart - distanceToRide;
    int cost = distanceToRide + waitTime;

    return points - cost;
  }
}
