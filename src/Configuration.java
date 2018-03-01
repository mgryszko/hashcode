import org.apache.commons.lang3.builder.ToStringBuilder;

public class Configuration
{
  final int rows;
  final int columns;
  final int vehicles;
  final int rides;
  final int bonus;
  final int steps;

  public Configuration(int rows, int columns, int vehicles, int rides, int bonus, int steps)
  {
    this.rows = rows;
    this.columns = columns;
    this.vehicles = vehicles;
    this.rides = rides;
    this.bonus = bonus;
    this.steps = steps;
  }

  @Override public String toString()
  {
    return new ToStringBuilder(this)
      .append("rows", rows)
      .append("columns", columns)
      .append("vehicles", vehicles)
      .append("rides", rides)
      .append("bonus", bonus)
      .append("steps", steps)
      .toString();
  }
}
