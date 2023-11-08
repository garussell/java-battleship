package battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ShipTest {

    private Ship cruiser;

    @Before
    public void setUp() {
        cruiser = new Ship("Cruiser", 3);
    }

    @Test
    public void testExists() {
        assertTrue(cruiser instanceof Ship);
        assertEquals("Cruiser", cruiser.getName());
        assertEquals(3, cruiser.getLength());
    }

    @Test
    public void testHealth() {
        assertEquals(3, cruiser.getHealth());
    }

    @Test
    public void testSunk() {
        assertFalse(cruiser.isSunk());
    }

    @Test
    public void testHit() {
        cruiser.hit();
        assertEquals(2, cruiser.getHealth());
        cruiser.hit();
        assertEquals(1, cruiser.getHealth());
        cruiser.hit();
        assertEquals(0, cruiser.getHealth());
        assertTrue(cruiser.isSunk());
    }
}
