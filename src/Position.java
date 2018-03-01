import org.apache.commons.lang3.builder.ToStringBuilder;

class Position
{
  int x;
  int y;

  Position(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  int distanceTo(Position destination)
  {
    return Math.abs(destination.x - x) + Math.abs(destination.y - y);
  }

  @Override public String toString()
  {
    return "[" + x + "," + y + "]";
  }
}
