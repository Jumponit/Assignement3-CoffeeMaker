package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

public class CoffeeMakerTest2 {
	
	private Recipe recipe;
	private Recipe[] recipeArray;
	private Inventory inventory;
	private CoffeeMaker coffeeMaker;
	
	@Before
	public void setUp() throws Exception {
		this.recipeArray = new Recipe[4];
		this.recipe = new Recipe();
		this.recipe.setName("Test Recipe");
		this.recipe.setPrice("4");
		this.recipe.setAmtCoffee("5");
		this.recipe.setAmtMilk("5");
		this.recipe.setAmtSugar("5");
		this.recipeArray[0] = this.recipe;
		this.inventory = new Inventory();
		this.coffeeMaker = new CoffeeMaker();
		this.coffeeMaker.addRecipe(recipe);
	}

	@After
	public void tearDown() throws Exception {
		this.recipeArray = null;
		this.recipe = null;
		this.inventory = null;
		this.coffeeMaker = null;
	}

	@Test
	public void testCoffeeMaker() {
		Recipe[] expectedRecipeArray = this.recipeArray;
		Recipe[] actualRecipeArray = this.coffeeMaker.getRecipes();
		String expectedInventoryString = this.inventory.toString();
		String actualInventoryString = this.coffeeMaker.checkInventory();
		assertArrayEquals(expectedRecipeArray, actualRecipeArray);
		assertEquals(expectedInventoryString, actualInventoryString);
	}

	@Test
	public void testAddRecipe() {
		this.coffeeMaker.addRecipe(recipe);
		Recipe[] expectedRecipeArray = this.recipeArray;
		Recipe[] actualRecipeArray = this.coffeeMaker.getRecipes();
		assertArrayEquals(expectedRecipeArray, actualRecipeArray);
	}

	@Test
	public void testDeleteRecipe() {
		String expectedRecipeName = this.recipeArray[0].getName();
		String actualRecipeName = this.coffeeMaker.deleteRecipe(0);
		this.recipeArray[0] = new Recipe();
		Recipe[] expectedRecipeArray = this.recipeArray;
		Recipe[] actualRecipeArray = this.coffeeMaker.getRecipes();
		assertEquals(expectedRecipeName, actualRecipeName);
		assertArrayEquals(expectedRecipeArray, actualRecipeArray);
	}

	@Test
	public void testEditRecipe() {
		Recipe newRecipe = new Recipe();
		newRecipe.setName("Test New Recipe");
		String expectedRecipeName = this.recipeArray[0].getName();
		String actualRecipeName = this.coffeeMaker.editRecipe(0, newRecipe);
		// ASK ABOUT THIS !!!!!!!!!!!!
		
		this.recipeArray[0] = newRecipe;
		Recipe[] expectedRecipeArray = this.recipeArray;
		Recipe[] actualRecipeArray = this.coffeeMaker.getRecipes();
		assertEquals(expectedRecipeName, actualRecipeName);
		assertArrayEquals(expectedRecipeArray, actualRecipeArray);
	}

	@Test
	public void testAddInventory() {
		try {
			this.coffeeMaker.addInventory("15", "15", "15", "15");
		} catch (InventoryException e) {
			e.printStackTrace();
			fail();
		}
		try {
			this.inventory.addCoffee("15");
			this.inventory.addMilk("15");
			this.inventory.addSugar("15");
			this.inventory.addChocolate("15");
		} catch (InventoryException e) {
			fail();
		}
		// ASK ABOUT THIS ONE !!!!!!!!!!!!
		String expectedInventoryString = this.inventory.toString();
		String actualInventoryString = this.coffeeMaker.checkInventory();
		assertEquals(expectedInventoryString, actualInventoryString);
	}

	@Test
	public void testCheckInventory() {
		String expectedInventoryString = this.inventory.toString();
		String actualInventoryString = this.coffeeMaker.checkInventory();
		assertEquals(expectedInventoryString, actualInventoryString);
	}

	@Test
	public void testMakeCoffee() {
		int expectedInt = 1;
		int actualInt = this.coffeeMaker.makeCoffee(0, 5);
		this.inventory.setCoffee(10);
		this.inventory.setMilk(10);
		this.inventory.setSugar(10);
		String expectedInventoryString = this.inventory.toString();
		String actualInventoryString = this.coffeeMaker.checkInventory();
		// ASK ABOUT THIS ONE TOO FAM !!!!!!!!!!!
		assertEquals(expectedInt, actualInt);
		assertEquals(expectedInventoryString, actualInventoryString);
	}
	
	@Test
	public void testMakeCoffeeInvalidIndex() {
		int expected = 4;
		int actual = this.coffeeMaker.makeCoffee(1, 4);
		assertEquals(expected, actual);
	}

	@Test
	public void testMakeCoffeeInvalidAmtPaid() {
		int expected = 2;
		int actual = this.coffeeMaker.makeCoffee(0, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetRecipes() {
		Recipe[] expected = this.recipeArray;
		Recipe[] actual = this.coffeeMaker.getRecipes();
		assertArrayEquals(expected, actual);
	}

}
