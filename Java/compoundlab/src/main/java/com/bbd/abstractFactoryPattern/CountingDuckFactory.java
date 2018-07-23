package com.bbd.abstractFactoryPattern;

public class CountingDuckFactory extends AbstractDuckFactory
{
	public IQuackable createMallardDuck()
	{
		return (new QuackCounter(new MallardDuck()));
	}

	public IQuackable createRedheadDuck()
	{
		return (new QuackCounter(new RedheadDuck()));
	}

	public IQuackable createDuckCall()
	{
		return (new QuackCounter(new DuckCall()));
	}

	public IQuackable createRubberDuck()
	{
		return (new QuackCounter(new RubberDuck()));
	}
}
