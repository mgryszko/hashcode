class Event implements Comparable<Event>
{
  enum Type { CarBecameAvailable, PickUpRide, RideFinished }

  final int nextTick;
  final Car car;
  final Ride ride;
  final Type type;

  Event(int nextTick, Car car, Ride ride, Type type)
  {
    this.nextTick = nextTick;
    this.car = car;
    this.ride = ride;
    this.type = type;
  }

  @Override
  public int compareTo(Event o)
  {
    return nextTick - o.nextTick;
  }
}
