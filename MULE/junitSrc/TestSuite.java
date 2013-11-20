
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runner.Result;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class TestSuite {

    /* done by Kennon Bittick */
    @Test
    public void testMap() {
        /* test the default map */
        Map map = new Map(1);
        assertNotNull("Map object", map);
        Tile[] tiles = map.getTiles();
        assertNotNull("Tiles in map", tiles);
    }

}
