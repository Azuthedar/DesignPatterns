package com.bbd.abstractFactoryPattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void DuckCall()
	{
		IQuackable duckCall = new DuckCall();
		assertEquals("Duck calls", duckCall.quack());
	}

	@Test
	public void MallardDuck() {
    	IQuackable mallardDuck = new MallardDuck();
    	assertEquals("Mallard Duck Quacks", mallardDuck.quack());
	}

	@Test
	public void GooseSnuckIn()
	{
		Goose goose = new Goose();
		IQuackable gooseAdapter = new GooseAdapter(goose);
		assertEquals("Goose honks!", gooseAdapter.quack());
	}

	@Test
	public void TestQuackCounter()
	{
		IQuackable duck = new MallardDuck();
		duck = new QuackCounter(duck);

		duck.quack();
		duck.quack();
		duck.quack();

		assertEquals(3, ((QuackCounter) duck).getQuacks());
	}

	@Test
	public void TestDuckFactory()
	{
		DuckFactory df = new DuckFactory();

		IQuackable mallardDuck = df.createMallardDuck();

		assertTrue(mallardDuck instanceof MallardDuck);
	}

	@Test
	public void TestCountingDuckFactory()
	{
		CountingDuckFactory cdf = new CountingDuckFactory();

		IQuackable redheadDuck = cdf.createRedheadDuck();

		assertTrue(redheadDuck instanceof QuackCounter);
	}

	@Test
	public void TestFlock()
	{
		Flock flock = new Flock();

		flock.add(new MallardDuck());
		flock.add(new GooseAdapter(new Goose()));

		Flock duckFlocks = new Flock();

		duckFlocks.add(new MallardDuck());
		duckFlocks.add(flock);

		StringBuilder sb = new StringBuilder();

		sb.append("Mallard Duck Quacks inside the flock\n");
		sb.append("Mallard Duck Quacks inside the flock\n");
		sb.append("Goose honks! inside the flock\n");
		sb.append(" inside the flock\n");

		System.out.println(duckFlocks.quack());
		assertEquals(sb.toString(), duckFlocks.quack());
	}

	@Test
	public void TestObservers()
	{
		Quackologist quackologist = new Quackologist();
		IQuackObservable mallardDuck = new MallardDuck();
		mallardDuck.registerObserver(quackologist);
		System.out.println(mallardDuck.notifyObservers());

		assertEquals("Quackologist: The duck > Mallard Duck quacked", mallardDuck.notifyObservers());
	}
}
