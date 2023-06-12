package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String expectedName;
    private final float expectedPrice;
    private Bun bun;

    public BunTest(String name, float price) {
        this.expectedName = name;
        this.expectedPrice = price;
    }

    @Parameterized.Parameters
    public static Object[][] createBunData() {
        return new Object[][] {
                {"Булка по акции", 0},
                {"Флюоресцентная булка R2-D3", 988},
                {"Краторная булка N-200i", 1255},
                {"Отрицательная булка", -1},
                {null, 1}
        };
    }

    @Before
    public void setUp() {
        bun = new Bun(expectedName, expectedPrice);
    }

    @Test
    public void shouldReturnCorrectPrice() {
        assertEquals(expectedPrice, bun.getPrice(), 0);
    }

    @Test
    public void shouldReturnCorrectName() {
        assertEquals(expectedName, bun.getName());
    }
}