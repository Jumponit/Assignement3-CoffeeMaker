/*
 * InventoryTest - JUnit test cases for the Inventory class of CoffeeMaker
 * 
 * @author: Lacie Cochran
 */

package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

public class InventoryTest {
	
	//class variables for comparison
	static int coffee, chocolate, milk, sugar;
	static Recipe r;
	static Inventory i, in;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		coffee = 15;
		chocolate = 15;
		milk = 15;
		sugar = 15;
		
		r = new Recipe();
		r.setAmtChocolate("2");
		r.setAmtCoffee("1");
		r.setAmtMilk("4");
		r.setAmtSugar("1");
		r.setName("Chocolate Latte");
		r.setPrice("5");
		
		in = new Inventory();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		coffee = 0;
		chocolate = 0;
		milk = 0;
		sugar = 0;
		
		r = null;
		
		in = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInventory() {
		i = new Inventory();
		assertEquals(i.getChocolate(), chocolate);
		assertEquals(i.getCoffee(), coffee);
		assertEquals(i.getMilk(), milk);
		assertEquals(i.getSugar(), sugar);
		i = null;
	}

	@Test
	public void testGetChocolate() {
		assertEquals(in.getChocolate(), chocolate);
	}

	@Test
	public void testSetChocolatePositive() {
		in.setChocolate(5);
		assertEquals(in.getChocolate(), 5);
		in.setChocolate(15);
		assertEquals(in.getChocolate(), 15);
	}
	
	@Test
	public void testSetChocolateNegative() {
		in.setChocolate(-1);
		assertEquals(in.getChocolate(), 15);
	}
	
	@Test
	public void testSetChocolateZero() {
		in.setChocolate(0);
		assertEquals(in.getChocolate(), 0);
		in.setChocolate(15);
		assertEquals(in.getChocolate(), 15);
	}

	@Test(expected = InventoryException.class)
	public void testAddChocolateNull() throws InventoryException{
		in.addChocolate(null);
	}
	
	@Test(expected = InventoryException.class)
	public void testAddChocolateNegative() throws InventoryException{
		in.addChocolate("-1");
	}
	
	@Test
	public void testAddChocolatePositive() throws InventoryException{
		in.addChocolate("5");
		assertEquals(in.getChocolate(), 20);
		in.setChocolate(15);
		assertEquals(in.getChocolate(), 15);
	}
	
	@Test
	public void testAddChocolateZero() throws InventoryException{
		in.addChocolate("0");
		assertEquals(in.getChocolate(), 15);
	}

	@Test
	public void testGetCoffee() {
		assertEquals(in.getCoffee(), coffee);
	}

	@Test
	public void testSetCoffeeZero() {
		in.setCoffee(0);
		assertEquals(in.getCoffee(), 0);
		in.setCoffee(15);
		assertEquals(in.getCoffee(), 15);
	}
	
	@Test
	public void testSetCoffeeNegative() {
		in.setCoffee(-1);
		assertEquals(in.getCoffee(), coffee);
	}
	
	@Test
	public void testSetCoffeePositive() {
		in.setCoffee(5);
		assertEquals(in.getCoffee(), 5);
		in.setCoffee(15);
		assertEquals(in.getCoffee(), 15);
	}

	@Test(expected = InventoryException.class)
	public void testAddCoffeeNull() throws InventoryException{
		in.addCoffee(null);
	}
	
	@Test(expected = InventoryException.class)
	public void testAddCoffeeNegative() throws InventoryException{
		in.addCoffee("-1");
	}
	
	@Test
	public void testAddCoffeeZero() throws InventoryException{
		in.addCoffee("0");
		assertEquals(in.getCoffee(), coffee);
	}
	
	@Test
	public void testAddCoffeePositive() throws InventoryException{
		in.addCoffee("5");
		assertEquals(in.getCoffee(), 20);
		in.setCoffee(coffee);
		assertEquals(in.getCoffee(), coffee);
	}

	@Test
	public void testGetMilk() {
		assertEquals(in.getMilk(), milk);
	}

	@Test
	public void testSetMilkNegative() {
		in.setMilk(-1);
		assertEquals(in.getMilk(), milk);
	}
	
	@Test
	public void testSetMilkZero() {
		in.setMilk(0);
		assertEquals(in.getMilk(), 0);
		in.setMilk(milk);
		assertEquals(in.getMilk(), milk);
	}
	
	@Test
	public void testSetMilkPositive() {
		in.setMilk(5);
		assertEquals(in.getMilk(), 5);
		in.setMilk(milk);
		assertEquals(in.getMilk(), milk);
	}

	@Test(expected = InventoryException.class)
	public void testAddMilkNull() throws InventoryException{
		in.addMilk(null);
	}
	
	@Test(expected = InventoryException.class)
	public void testAddMilkNegative() throws InventoryException{
		in.addMilk("-1");
	}
	
	@Test
	public void testAddMilkZero() throws InventoryException{
		in.addMilk("0");
		assertEquals(in.getMilk(), milk);
	}
	
	@Test
	public void testAddMilkPositive() throws InventoryException{
		in.addMilk("5");
		assertEquals(in.getMilk(), 20);
		in.setMilk(milk);
		assertEquals(in.getMilk(), milk);
	}

	@Test
	public void testGetSugar() {
		assertEquals(in.getSugar(), sugar);
	}

	@Test
	public void testSetSugarNegative() {
		in.setSugar(-1);
		assertEquals(in.getSugar(), sugar);
	}
	
	@Test
	public void testSetSugarZero() {
		in.setSugar(0);
		assertEquals(in.getSugar(), 0);
		in.setSugar(sugar);
		assertEquals(in.getSugar(), sugar);
	}
	
	@Test
	public void testSetSugarPositive() {
		in.setSugar(5);
		assertEquals(in.getSugar(), 5);
		in.setSugar(sugar);
		assertEquals(in.getSugar(), sugar);
	}

	@Test(expected = InventoryException.class)
	public void testAddSugarNull() throws InventoryException{
		in.addSugar(null);
	}
	
	//results in a failure, related to line 182
	@Test(expected = InventoryException.class)
	public void testAddSugarNegative() throws InventoryException{
		in.addSugar("-1");
	}
	
	//results in a failure, related to line 182
	@Test
	public void testAddSugarZero() throws InventoryException{
		in.addSugar("0");
		assertEquals(in.getSugar(), sugar);
	}
	
	//results in a error, related to line 182
	@Test
	public void testAddSugarPositive() throws InventoryException{
		in.addSugar("5");
		assertEquals(in.getSugar(), 20);
		in.setSugar(sugar);
		assertEquals(in.getSugar(), sugar);
	}

	@Test
	public void testEnoughIngredientsTrue() {
		assertTrue(in.enoughIngredients(r));
	}
	
	@Test
	public void testEnoughIngredientsFalseCoffee() {
		in.setCoffee(0);
		assertFalse(in.enoughIngredients(r));
		in.setCoffee(coffee);
	}
	
	@Test
	public void testEnoughIngredientsFalseMilk() {
		in.setMilk(3);
		assertFalse(in.enoughIngredients(r));
		in.setMilk(milk);
	}
	
	@Test
	public void testEnoughIngredientsFalseSugar() {
		in.setSugar(0);
		assertFalse(in.enoughIngredients(r));
		in.setSugar(sugar);
	}
	
	@Test
	public void testEnoughIngredientsFalseChocolate() {
		in.setChocolate(1);
		assertFalse(in.enoughIngredients(r));
		in.setChocolate(chocolate);
	}

	//generates failure at coffee += amount, should change to coffee -=
	@Test
	public void testUseIngredientsTrue() {
		assertTrue(in.useIngredients(r));
		
		//check amounts
		assertEquals(in.getCoffee(), coffee - r.getAmtCoffee());
		assertEquals(in.getChocolate(), chocolate - r.getAmtChocolate());
		assertEquals(in.getMilk(), milk - r.getAmtMilk());
		assertEquals(in.getSugar(), sugar - r.getAmtSugar());
		
		in.setMilk(milk);
		in.setChocolate(chocolate);
		in.setCoffee(coffee);
		in.setSugar(sugar);
	}
	
	@Test
	public void testUseIngredientsFalse() {
		in.setMilk(1);
		assertFalse(in.useIngredients(r));
		in.setMilk(milk);
		in.setChocolate(chocolate);
		in.setCoffee(coffee);
		in.setSugar(sugar);
	}

	@Test
	public void testToString() {
		assertEquals(in.toString(), "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n");
	}

}
