import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Collection;

class Ride implements Comparable<Ride> {
  final int id;
  final Position startPos;
  final Position endPos;
  final int earliestStart;
  final int latestFinish;
  final int distanceFromStart;

  Ride(int id, int startX, int startY, int endX, int endY, int earliestStart, int latestFinish)
  {
    this.id = id;
    startPos = new Position(startX, startY);
    endPos = new Position(endX, endY);
    this.earliestStart = earliestStart;
    this.latestFinish = latestFinish;
    distanceFromStart = startX + startY;
  }

  @Override
  public String toString()
  {
    return new ToStringBuilder(this)
      .append("id", id)
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

  @Override
  public int compareTo(Ride o) {
    if(distanceFromStart < o.distanceFromStart) {
      return -1;
    } else if(distanceFromStart > o.distanceFromStart) {
      return 1;
    }

    return 0;
  }
}
