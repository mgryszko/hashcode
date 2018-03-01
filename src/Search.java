import java.util.Arrays;
import java.util.List;

public class Search
{
  public static void main(String[] args)
  {
    Configuration config = new Configuration(3, 4, 2, 3, 2, 10);

    List<Ride> rides = Arrays.asList(
      new Ride(0, 0, 0, 1, 3, 2, 9),
      new Ride(1, 1, 2, 1, 0, 0, 9),
      new Ride(2, 2, 0, 2, 2, 0, 9)
    );

    Solution start = new Solution(config.vehicles, rides);

    System.out.println(search(start, config));
  }

  private static Solution search(Solution start, Configuration config)
  {
    return null;
  }
}
