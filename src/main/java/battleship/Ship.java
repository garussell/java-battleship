package battleship;

public class Ship {
  
  private String name;
  private int length;
  private int health;

  public Ship(String name, int length) {
    this.name = name;
    this.length = length;
    this.health = length;
  }

  public boolean isSunk() {
    return health == 0;
  }

  public void hit() {
    if (health > 0) {
      health--;
    }
  }

  public String getName() {
    return name;
  }

  public int getLength() {
    return length;
  }

  public int getHealth() {
    return health;
  }
}
