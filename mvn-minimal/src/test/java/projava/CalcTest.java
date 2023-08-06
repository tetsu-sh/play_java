package projava;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalcTest {
    @Test
    public void testAdd_正の整数の加算() {
        assertEquals("2 + 2 = 4", 4, new Calc().add(2, 2));
        assertEquals("2 + 2 = 4", 6, new Calc().add(2, 4));
    }
}
