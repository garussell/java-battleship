package battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CellTest {
  
  private Cell cell1;
  private Cell cell2;
  private Ship cruiser;

  @Before
  public void setUp() {
    cell1 = new Cell("B4");
    cell2 = new Cell("C3");
    cruiser = new Ship("Cruiser", 3);
  }

  @Test
  public void testInitialize() {
    assertTrue(cell1 instanceof Cell);
    assertEquals("B4", cell1.getCoordinate());
    assertEquals(null, cell1.getShip());
    assertFalse(cell1.getShotFired());
    assertTrue(cell1.isEmpty());
  }

  @Test
  public void testPlaceShip() {
    cell1.placeShip(cruiser);
    assertEquals(cruiser, cell1.getShip());
    assertFalse(cell1.isEmpty());
  }

  @Test
  public void testFireUpon() {
    cell1.placeShip(cruiser);
    assertFalse(cell1.getShotFired());

    cell1.fireUpon();
    assertTrue(cell1.getShotFired());
    assertEquals(2, cell1.getShip().getHealth());
  }

  @Test
  public void testRender() {
    assertEquals(".", cell1.render(false));
    cell1.fireUpon();
    assertEquals("M", cell1.render(false));
    
    cell2.placeShip(cruiser);
    assertEquals(".", cell2.render(false));
    assertEquals("S", cell2.render(true));
    cell2.fireUpon();
    assertEquals("H", cell2.render(true));
  }

  @Test
  public void testSunk() {
    cell2.placeShip(cruiser);
    assertFalse(cruiser.isSunk());

    cell2.fireUpon();
    cruiser.hit();
    cruiser.hit();

    assertTrue(cruiser.isSunk());
    assertEquals("X", cell2.render());
  }
}
