import java.util.List;

class RidesTest
{
  public static void main(String[] args)
  {
    Rides rides = new Rides();

    rides.addRide(new Ride(0, 0, 1, 9, 9, 0, 0));
    rides.addRide(new Ride(1, 0, 1, 9, 9, 0, 0));
    rides.addRide(new Ride(2, 0, 5, 9, 9, 0, 0));
    rides.addRide(new Ride(3, 6, 5, 9, 9, 0, 0));
    rides.addRide(new Ride(4, 16, 15, 9, 9, 0, 0));
    rides.addRide(new Ride(5, 800, 1000, 9, 9, 0, 0));

    rides.sort();

    List<Ride> rides1 = rides.findClosestTo(new Car(0, 0));
    if (rides1.get(0).startPos.x != 0 || rides1.get(0).startPos.y != 1)
    {
      throw new RuntimeException("Fallo Rides 1");
    }

    List<Ride> rides2 = rides.findClosestTo(new Car(700, 700));
    if (rides2.get(0).startPos.x != 800 || rides2.get(0).startPos.y != 1000)
    {
      throw new RuntimeException("Fallo Rides 2");
    }

      List<Ride> rides22 = rides.findClosestTo(new Car(700, 700));
      if (rides22.get(0).startPos.x != 16 || rides22.get(0).startPos.y != 15)
      {
          throw new RuntimeException("Fallo Rides 2.2");
      }

    List<Ride> rides3 = rides.findClosestTo(new Car(3, 2));
    if (rides3.get(0).startPos.x != 0 || rides3.get(0).startPos.y != 5)
    {
      throw new RuntimeException("Fallo Rides 3");
    }
  }
}
