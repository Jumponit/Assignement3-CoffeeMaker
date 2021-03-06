package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RecipeBookTest {
	
	private RecipeBook recipeBook;
	private Recipe[] recipeArray;
	private Recipe recipe;
	private Recipe newRecipe;

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		this.recipeBook = new RecipeBook();
		this.recipeArray = new Recipe[4];
		this.recipe = new Recipe();
		this.recipe.setName("Test Recipe");
		this.newRecipe = new Recipe();
		this.newRecipe.setName("Test New Recipe");
	}

	@After
	public void tearDown() throws Exception {
		this.recipeBook = null;
		this.recipeArray = null;
		this.recipe = null;
		this.newRecipe = null;
	}

	@Test
	public void testRecipeBook() {
		Recipe[] expected = this.recipeArray;
		Recipe[] actual = this.recipeBook.getRecipes();
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testGetRecipes() {
		Recipe[] expected = this.recipeArray;
		Recipe[] actual = this.recipeBook.getRecipes();
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testAddRecipeFirstRecipe() {
		boolean actualBoolean = this.recipeBook.addRecipe(this.recipe);
		this.recipeArray[0] = this.recipe;
		Recipe[] expectedRecipeArray = this.recipeArray;
		Recipe[] actualRecipeArray = this.recipeBook.getRecipes();
		assertTrue(actualBoolean);
		assertArrayEquals(expectedRecipeArray, actualRecipeArray);
	}
	
	@Test
	public void testAddRecipe() {
		this.recipeBook.addRecipe(this.recipe);
		boolean actualBoolean = this.recipeBook.addRecipe(this.newRecipe);
		this.recipeArray[0] = this.recipe;
		this.recipeArray[1] = this.newRecipe;
		Recipe[] expectedRecipeArray = this.recipeArray;
		Recipe[] actualRecipeArray = this.recipeBook.getRecipes();
		assertTrue(actualBoolean);
		assertArrayEquals(expectedRecipeArray, actualRecipeArray);
	}
	
	@Test
	public void testAddRecipeDuplicate() {
		this.recipeBook.addRecipe(this.recipe);
		boolean actualBoolean = this.recipeBook.addRecipe(this.recipe);
		this.recipeArray[0] = this.recipe;
		Recipe[] expectedRecipeArray = this.recipeArray;
		Recipe[] actualRecipeArray = this.recipeBook.getRecipes();
		assertFalse(actualBoolean);
		assertArrayEquals(expectedRecipeArray, actualRecipeArray);
	}
	
	@Test
	public void testAddRecipeExceedsBookSize() {
		Recipe thirdRecipe = new Recipe();
		thirdRecipe.setName("Test Third Recipe");
		Recipe fourthRecipe = new Recipe();
		fourthRecipe.setName("Test Fourth Recipe");
		Recipe extraRecipe = new Recipe();
		extraRecipe.setName("Test Extra Recipe");
		this.recipeBook.addRecipe(this.recipe);
		this.recipeBook.addRecipe(this.newRecipe);
		this.recipeBook.addRecipe(thirdRecipe);
		this.recipeBook.addRecipe(fourthRecipe);
		boolean actualBoolean = this.recipeBook.addRecipe(extraRecipe);
		this.recipeArray[0] = this.recipe;
		this.recipeArray[1] = this.newRecipe;
		this.recipeArray[2] = thirdRecipe;
		this.recipeArray[3] = fourthRecipe;
		Recipe[] expectedRecipeArray = this.recipeArray;
		Recipe[] actualRecipeArray = this.recipeBook.getRecipes();
		assertFalse(actualBoolean);
		assertArrayEquals(expectedRecipeArray, actualRecipeArray);
	}

	@Test
	public void testDeleteRecipe() {
		this.recipeBook.addRecipe(this.recipe);
		String expectedRecipeName = this.recipe.getName();
		String actualRecipeName = this.recipeBook.deleteRecipe(0);
		this.recipeArray[0] = null;
		Recipe[] expectedRecipeArray = this.recipeArray;
		Recipe[] actualRecipeArray = this.recipeBook.getRecipes();
		assertEquals(expectedRecipeName, actualRecipeName);
		assertArrayEquals(expectedRecipeArray, actualRecipeArray);
	}
	
	@Test
	public void testDeleteRecipeInvalid() {
		this.recipeBook.addRecipe(this.recipe);
		String actualRecipeName = this.recipeBook.deleteRecipe(1);
		this.recipeArray[0] = this.recipe;
		Recipe[] expectedRecipeArray = this.recipeArray;
		Recipe[] actualRecipeArray = this.recipeBook.getRecipes();
		assertNull(actualRecipeName);
		assertArrayEquals(expectedRecipeArray, actualRecipeArray);
	}
	
	@Test
	public void testDeleteRecipeIndexOutOfBounds() throws IndexOutOfBoundsException {
		thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage("The index provided is out of bounds of the Recipe array.");
		this.recipeBook.deleteRecipe(4);
	}

	@Test
	public void testEditRecipe() {
		this.recipeBook.addRecipe(this.recipe);
		String expectedRecipeName = this.recipe.getName();
		String actualRecipeName = this.recipeBook.editRecipe(0, this.newRecipe);
		this.recipeArray[0] = this.newRecipe;
		Recipe[] expectedRecipeArray = this.recipeArray;
		Recipe[] actualRecipeArray = this.recipeBook.getRecipes();
		assertEquals(expectedRecipeName, actualRecipeName);
		assertArrayEquals(expectedRecipeArray, actualRecipeArray);
		assertEquals(this.recipeArray[0].getName(), this.recipeBook.getRecipes()[0].getName());
	}
	
	@Test
	public void testEditRecipeInvalid() {
		this.recipeBook.addRecipe(this.recipe);
		String actualRecipeName = this.recipeBook.editRecipe(1, this.newRecipe);
		this.recipeArray[0] = this.recipe;
		Recipe[] expectedRecipeArray = this.recipeArray;
		Recipe[] actualRecipeArray = this.recipeBook.getRecipes();
		assertNull(actualRecipeName);
		assertArrayEquals(expectedRecipeArray, actualRecipeArray);
	}
	
	@Test
	public void testEditRecipeIndexOutOfBounds() throws IndexOutOfBoundsException {
		thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage("The index provided is out of bounds of the Recipe array.");
		this.recipeBook.editRecipe(4, this.newRecipe);
	}

}
