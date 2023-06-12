package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType ingredientType;
    private final String type;

    public IngredientTypeTest(IngredientType ingredientType, String type) {
        this.ingredientType = ingredientType;
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] createIngredientTypeData() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"},
        };
    }

    @Test
    public void checkIngredientType() {
        assertEquals(ingredientType, IngredientType.valueOf(type));
    }
}