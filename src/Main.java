import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static Map<Car, List<Ride>> carRides = new HashMap<>();
    static EasyRides rides = new EasyRides();

    public static void main(String[] args) throws IOException
    {
        String configurationLine = openFile(args[0]).findFirst().get();
        Configuration configuration = parseConfig(configurationLine);

        AtomicInteger rideId = new AtomicInteger(-1);

        openFile(args[0])
          .skip(1)
          .peek(line -> rideId.incrementAndGet())
          .forEach(line -> rides.addRide(parseRide(line, rideId)));

        System.out.println(configuration);
        System.out.println(rides);

        List<Car> cars = new ArrayList<>(configuration.vehicles);
        PriorityQueue<Event> events = new PriorityQueue<>();

        for (int i = 0; i < configuration.vehicles; i++)
        {
            Car car = new Car(0, 0);
            cars.add(car);
            events.add(new Event(0, car, null, Event.Type.CarBecameAvailable));
        }

        int tick = 0;
        while (events.size() > 0 && tick < configuration.steps)
        {
            Event event = events.poll();
            tick = event.nextTick;
            events.add(process(event));
        }

      for (List<Ride> entry : carRides.values())
      {
        System.out.println(entry.size() + " " + entry.stream().map(ride -> String.valueOf(ride.id)).collect(Collectors.joining(" ")));
      }
    }

    private static Event process(Event event)
    {
        switch (event.type) {
            case CarBecameAvailable:
              Ride ride = rides.findClosestTo(event.car);
              if (ride != null)
              {
                int nextTick = Math.max(event.nextTick + event.car.distanceTo(ride), ride.earliestStart);
                return new Event(nextTick, event.car, ride, Event.Type.PickUpRide);
              }
              else {
                return new Event(Integer.MAX_VALUE, event.car, null, Event.Type.CarBecameAvailable);
              }
            case PickUpRide:
                return new Event(event.nextTick + event.ride.distance(), event.car, event.ride, Event.Type.RideFinished);
            case RideFinished:
                carRides.computeIfAbsent(event.car, car -> new ArrayList<>());
                carRides.computeIfPresent(event.car, (car, rides) -> {
                  rides.add(event.ride);
                  return rides;
                });
                return new Event(event.nextTick, event.car, null, Event.Type.CarBecameAvailable);
        }
        throw new IllegalArgumentException("Event not recognized: " + event);
    }

    private static Stream<String> openFile(String fileName) throws IOException
    {
        return Files.lines(Paths.get(fileName));
    }

    private static Configuration parseConfig(String line)
    {
        String[] fields = line.split(" ");
        int rows = Integer.parseInt(fields[0]);
        int columns = Integer.parseInt(fields[1]);
        int vehicles = Integer.parseInt(fields[2]);
        int rides = Integer.parseInt(fields[3]);
        int bonus = Integer.parseInt(fields[4]);
        int steps = Integer.parseInt(fields[5]);
        return new Configuration(rows, columns, vehicles, rides, bonus, steps);
    }

    private static Ride parseRide(String line, AtomicInteger rideId)
    {
        String[] fields = line.split(" ");
        int startX = Integer.parseInt(fields[0]);
        int startY = Integer.parseInt(fields[1]);
        int endX = Integer.parseInt(fields[2]);
        int endY = Integer.parseInt(fields[3]);
        int earliestStart = Integer.parseInt(fields[4]);
        int latestFinish = Integer.parseInt(fields[5]);
        return new Ride(rideId.get(), startX, startY, endX, endY, earliestStart, latestFinish);
    }
}
