package com.bbd.abstractFactoryPattern;

public class DuckFactory extends AbstractDuckFactory
{
	public IQuackable createMallardDuck()
	{
		return (new MallardDuck());
	}

	public IQuackable createRedheadDuck()
	{
		return (new RedheadDuck());
	}

	public IQuackable createDuckCall()
	{
		return (new DuckCall());
	}

	public IQuackable createRubberDuck()
	{
		return (new RubberDuck());
	}
}
