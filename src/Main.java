import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException
    {
        String configurationLine = openFile(args[0]).findFirst().get();
        Configuration configuration = parseConfig(configurationLine);
        List<Ride> rides = openFile(args[0]).skip(1)
          .map(Main::parseRide)
          .collect(Collectors.toList());

        System.out.println(configuration);
        System.out.println(rides);

        for (int step = 0; step < configuration.steps; step++)
        {

        }
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

    private static Ride parseRide(String line)
    {
        String[] fields = line.split(" ");
        int startX = Integer.parseInt(fields[0]);
        int startY = Integer.parseInt(fields[1]);
        int endX = Integer.parseInt(fields[2]);
        int endY = Integer.parseInt(fields[3]);
        int earliestStart = Integer.parseInt(fields[4]);
        int latestFinish = Integer.parseInt(fields[5]);
        return new Ride(startX, startY, endX, endY, earliestStart, latestFinish);
    }
}
