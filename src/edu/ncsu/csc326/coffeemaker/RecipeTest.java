package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class RecipeTest
{

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
    }

    @Test
    public void testHashCode()
    {
        Recipe recipe = new Recipe();
        recipe.setName("Bobby's Chicken");
        int x = recipe.hashCode();
        int y = recipe.hashCode();
        assertTrue("Bad hash", (x == y && x >= 0));
    }

    @Test
    public void testRecipe()
    {
        Recipe recipe = new Recipe();
        assertNotNull("Object should not be null, but is.", recipe);
    }

    @Test
    public void testGetAmtChocolate()
    {
        Recipe recipe = new Recipe();
        assertEquals("Amount not correct, chocolate", recipe.getAmtChocolate(), 0);
    }

    @Test
    public void testSetAmtChocolate()
    {
        Recipe recipe = new Recipe();
        try {
            recipe.setAmtChocolate("5");
        }
        catch (RecipeException e) {
            fail("RecipeException thrown");
        }
        assertEquals("Amount not correct, chocolate", recipe.getAmtChocolate(), 5);
    }
    
    @Test (expected = RecipeException.class)
    public void testSetAmtChocolateBadNumber() throws RecipeException
    {
        Recipe recipe = new Recipe();
        recipe.setAmtChocolate("Bob");
    }
    
    @Test (expected = RecipeException.class)
    public void testSetAmtChocolateLessThanZero() throws RecipeException
    {
        Recipe recipe = new Recipe();
        recipe.setAmtChocolate("-5");
    }

    @Test
    public void testGetAmtCoffee()
    {
        Recipe recipe = new Recipe();
        assertEquals("Amount not correct, coffee", recipe.getAmtCoffee(), 0);
    }

    @Test
    public void testSetAmtCoffee()
    {
        Recipe recipe = new Recipe();
        try {
            recipe.setAmtCoffee("5");
        }
        catch (RecipeException e) {
            fail("RecipeException thrown");
        }
        assertEquals("Amount not correct, coffee", recipe.getAmtCoffee(), 5);
    }
    
    @Test (expected = RecipeException.class)
    public void testSetAmtCoffeeBadNumber() throws RecipeException
    {
        Recipe recipe = new Recipe();
        recipe.setAmtCoffee("Bob");
    }
    
    @Test (expected = RecipeException.class)
    public void testSetAmtCoffeeLessThanZero() throws RecipeException
    {
        Recipe recipe = new Recipe();
        recipe.setAmtCoffee("-5");
    }

    @Test
    public void testGetAmtMilk()
    {
        Recipe recipe = new Recipe();
        assertEquals("Amount not correct, milk", recipe.getAmtMilk(), 0);
    }

    @Test
    public void testSetAmtMilk()
    {
        Recipe recipe = new Recipe();
        try {
            recipe.setAmtMilk("5");
        }
        catch (RecipeException e) {
            fail("RecipeException thrown");
        }
        assertEquals("Amount not correct, milk", recipe.getAmtMilk(), 5);
    }
    
    @Test (expected = RecipeException.class)
    public void testSetAmtMilkBadNumber() throws RecipeException
    {
        Recipe recipe = new Recipe();
        recipe.setAmtMilk("Bob");
    }
    
    @Test (expected = RecipeException.class)
    public void testSetAmtMilkLessThanZero() throws RecipeException
    {
        Recipe recipe = new Recipe();
        recipe.setAmtMilk("-5");
    }

    @Test
    public void testGetAmtSugar()
    {
        Recipe recipe = new Recipe();
        assertEquals("Amount not correct, sugar", recipe.getAmtSugar(), 0);
    }

    @Test
    public void testSetAmtSugar()
    {
        Recipe recipe = new Recipe();
        try {
            recipe.setAmtSugar("5");
        }
        catch (RecipeException e) {
            fail("RecipeException thrown");
        }
        assertEquals("Amount not correct, sugar", recipe.getAmtSugar(), 5);
    }
    
    @Test (expected = RecipeException.class)
    public void testSetAmtSugarBadNumber() throws RecipeException
    {
        Recipe recipe = new Recipe();
        recipe.setAmtSugar("Bob");
    }
    
    @Test (expected = RecipeException.class)
    public void testSetAmtSugarLessThanZero() throws RecipeException
    {
        Recipe recipe = new Recipe();
        recipe.setAmtSugar("-5");
    }

    @Test
    public void testGetName()
    {
        Recipe recipe = new Recipe();
        assertEquals("Name not correct", recipe.getName(), "");
    }

    @Test
    public void testSetName()
    {
        Recipe recipe = new Recipe();
        recipe.setName("Test Recipe");
        assertEquals("Name not correct", recipe.getName(), "Test Recipe");
    }

    @Test
    public void testGetPrice()
    {
        Recipe recipe = new Recipe();
        assertEquals("Amount not correct, price", recipe.getPrice(), 0);
    }

    @Test
    public void testSetPrice()
    {
        Recipe recipe = new Recipe();
        try {
            recipe.setPrice("20");
        }
        catch (RecipeException e) {
            fail("RecipeException thrown");
        }
        assertEquals("Amount not correct, price", recipe.getPrice(), 20);
    }
    
    @Test (expected = RecipeException.class)
    public void testSetPriceBadNumber() throws RecipeException
    {
        Recipe recipe = new Recipe();
        recipe.setPrice("Bob");
    }
    
    @Test (expected = RecipeException.class)
    public void testSetPriceLessThanZero() throws RecipeException
    {
        Recipe recipe = new Recipe();
        recipe.setPrice("-5");
    }

    @Test
    public void testToString()
    {
        Recipe recipe = new Recipe();
        recipe.setName("Test Recipe");
        assertEquals("Name not correct", recipe.toString(), "Test Recipe");
    }

    @Test
    public void testEqualsObject()
    {
        Recipe recipe = new Recipe();
        Recipe dummy_recipe = null;
        assertFalse("Recipe should be null", recipe.equals(dummy_recipe));
        Integer x = 5;
        assertFalse("Object is not a recipe, should be false", recipe.equals(x));
        dummy_recipe = new Recipe();
        assertTrue("Recipes should both be initialized to empty values", recipe.equals(dummy_recipe));
        dummy_recipe = recipe;
        assertTrue("Recipes should be equal", recipe.equals(dummy_recipe));
        
    }
}
