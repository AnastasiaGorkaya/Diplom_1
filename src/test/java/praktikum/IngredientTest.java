package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final String expectedName;
    private final float expectedPrice;
    private final IngredientType expectedType;
    private Ingredient ingredient;

    public IngredientTest(String expectedName, float expectedPrice, IngredientType expectedType) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
        this.expectedType = expectedType;
    }

    @Before
    public void setUp() {
        ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
    }

    @Parameterized.Parameters
    public static Object[][] createIngredientData() {
        return new Object[][] {
                {"Мясо бессмертных моллюсков Protostomia", 1337, IngredientType.FILLING},
                {"Соус Spicy-X", 90, IngredientType.SAUCE},
        };
    }

    @Test
    public void shouldReturnCorrectPrice() {
        assertEquals(expectedPrice, ingredient.getPrice(), 0);
    }
    @Test
    public void shouldReturnCorrectName() {
        assertEquals(expectedName, ingredient.getName());
    }
    @Test
    public void shouldReturnCorrectType() {
        assertEquals(expectedType, ingredient.getType());
    }
}