import java.util.ArrayList;
import java.util.List;

class Solution
{
  List<Ride> unassignedRides;

  List<SolutionCar> cars = new ArrayList<>();

  Solution(int cars, List<Ride> unassignedRides)
  {
    this.cars = new ArrayList<>();
    this.unassignedRides = unassignedRides;
  }
}
