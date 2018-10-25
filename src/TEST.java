import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TEST {

    private ApartmentList list;

    private boolean isEmpty() {
        return list.size() == 0;
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    // Zero
    @Test
    public void testCreation() {
        assertTrue(list !=null);
    }

    @Test
    public void testEmptyWhenCreate() {

    }

    @Test
    public void testNotFullWhenCreate() {
        //assertFalse();
    }

}
