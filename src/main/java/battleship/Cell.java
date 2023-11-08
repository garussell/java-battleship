package battleship;

public class Cell {
  
  private String coordinate;
  private Ship ship;
  private boolean shotFired;
  
  public Cell(String coordinate) {
    this.coordinate = coordinate;
    this.ship = null;
    this.shotFired = false;
  }

  public boolean isEmpty() {
    return ship == null;
  }

  public void placeShip(Ship ship) {
    this.ship = ship;
  }

  public void fireUpon() {
    if (ship != null) {
      ship.hit();
    }
    shotFired = true;
  }

  // Overload method to make view false by default
  public String render() {
    return render(false);
  }

  public String render(boolean view) {
    if (ship != null && ship.isSunk()) {
        return "X";
    } else if (ship != null && shotFired) {
        return "H";
    } else if (ship == null && shotFired) {
        return "M";
    } else if (view && ship != null) {
        return "S";
    } else {
        return ".";
    }
  }

  // Getter methods
  public String getCoordinate() {
    return coordinate;
  }

  public Ship getShip() {
    return ship;
  }

  public boolean getShotFired() {
    return shotFired;
  }
}
