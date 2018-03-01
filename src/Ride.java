import org.apache.commons.lang3.builder.ToStringBuilder;

class Ride
{
  final Position startPos;
  final Position endPos;
  final int earliestStart;
  final int latestFinish;
  final int distanceFromStart;

  Ride(int startX, int startY, int endX, int endY, int earliestStart, int latestFinish)
  {
    startPos = new Position(startX, startY);
    endPos = new Position(endX, endY);
    this.earliestStart = earliestStart;
    this.latestFinish = latestFinish;
    distanceFromStart = startX + startY;
  }

  @Override public String toString()
  {
    return new ToStringBuilder(this)
      .append("startPos", startPos)
      .append("endPos", endPos)
      .append("earliestStart", earliestStart)
      .append("latestFinish", latestFinish)
      .toString();
  }

  public int distance()
  {
    return startPos.distanceTo(endPos);
  }
}
