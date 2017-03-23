package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecipeBookTest {
	
	private RecipeBook recipeBook;
	private Recipe[] recipeArray;
	private Recipe recipe;
	private Recipe newRecipe;

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
		Recipe[] expected = this.recipeArray;
		Recipe[] actual = this.recipeBook.getRecipes();
		assertArrayEquals(expected, actual);
	}

	@Test
	public void testEditRecipe() {
		Recipe[] expected = this.recipeArray;
		Recipe[] actual = this.recipeBook.getRecipes();
		assertArrayEquals(expected, actual);
	}

}
