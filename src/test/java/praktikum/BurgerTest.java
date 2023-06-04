package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    Burger burger = new Burger();

    @Test
    public void shouldReturnsCorrectBun() {
        String bunName = "Флюоресцентная булка R2-D3";
        burger.setBuns(bun);
        Mockito.when(bun.getName()).thenReturn(bunName);

        String expected = String.format("(==== Флюоресцентная булка R2-D3 ====)%n") +
                          String.format("(==== Флюоресцентная булка R2-D3 ====)%n") +
                          String.format("%nPrice: 0,000000%n");

        assertEquals("Неправильный текст", expected, burger.getReceipt());
    }

    @Test
    public void shouldAddIngredientSuccess() {
        String ingredientName = "Мясо бессмертных моллюсков Protostomia";
        float ingredientPrice = 1337;

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);

        String expected = String.format("(==== null ====)%n") +
                          String.format("= filling Мясо бессмертных моллюсков Protostomia =%n") +
                          String.format("= filling Мясо бессмертных моллюсков Protostomia =%n") +
                          String.format("(==== null ====)%n") +
                          String.format("%nPrice: 2674,000000%n");

        assertEquals("Неправильный текст", expected, burger.getReceipt());
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void shouldRemoveIngredientSuccess() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        String expected = String.format("(==== null ====)%n") +
                          String.format("(==== null ====)%n") +
                          String.format("%nPrice: 0,000000%n");

        assertEquals("Неправильный текст", expected, burger.getReceipt());
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void shouldMoveIngredientSuccess() {
        Ingredient first = Mockito.mock(Ingredient.class);
        Ingredient second = Mockito.mock(Ingredient.class);
        String ingredientNameFirst = "Мясо бессмертных моллюсков Protostomia";
        String ingredientNameSecond = "Говяжий метеорит (отбивная)";
        String ingredientNameThree = "Биокотлета из марсианской Магнолии";
        float ingredientPriceFirst = 1337;
        float ingredientPriceSecond = 3000;
        float ingredientPriceThree = 424;


        burger.setBuns(bun);
        burger.addIngredient(first);
        burger.addIngredient(second);
        burger.addIngredient(ingredient);


        Mockito.when(first.getName()).thenReturn(ingredientNameFirst);
        Mockito.when(first.getPrice()).thenReturn(ingredientPriceFirst);
        Mockito.when(first.getType()).thenReturn(IngredientType.FILLING);

        Mockito.when(second.getName()).thenReturn(ingredientNameSecond);
        Mockito.when(second.getPrice()).thenReturn(ingredientPriceSecond);
        Mockito.when(second.getType()).thenReturn(IngredientType.FILLING);

        Mockito.when(ingredient.getName()).thenReturn(ingredientNameThree);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPriceThree);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);

        burger.moveIngredient(burger.ingredients.indexOf(ingredient), 0);

        String expected = String.format("(==== null ====)%n") +
                          String.format("= filling Биокотлета из марсианской Магнолии =%n") +
                          String.format("= filling Мясо бессмертных моллюсков Protostomia =%n") +
                          String.format("= filling Говяжий метеорит (отбивная) =%n") +
                          String.format("(==== null ====)%n") +
                          String.format("%nPrice: 4761,000000%n");

        assertEquals("Неправильный текст", expected, burger.getReceipt());
        assertEquals(3, burger.ingredients.size());
        assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void shouldReturnCorrectPrice() {
        float bunPrice = 988;
        float ingredientPrice = 1337;

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        assertEquals((bunPrice * 2) + ingredientPrice, burger.getPrice(), 0);
    }

    @Test
    public void shouldReturnCorrectReceipt() {
        String bunName = "Флюоресцентная булка R2-D3";
        String ingredientName = "Мясо бессмертных моллюсков Protostomia";
        float bunPrice = 988;
        float ingredientPrice = 1337;

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);

        String expected = String.format("(==== Флюоресцентная булка R2-D3 ====)%n") +
                          String.format("= filling Мясо бессмертных моллюсков Protostomia =%n") +
                          String.format("= filling Мясо бессмертных моллюсков Protostomia =%n") +
                          String.format("(==== Флюоресцентная булка R2-D3 ====)%n") +
                          String.format("%nPrice: 4650,000000%n");

        assertEquals("Неправильный текст", expected, burger.getReceipt());
    }
}
