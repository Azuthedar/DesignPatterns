package com.bbd.abstractFactoryPattern;

public class QuackCounter implements IQuackable
{
	private IQuackable _duck;
	private IQuackObservable _observable;
	private static int counter = 0;

	QuackCounter(IQuackable duck)
	{
		this._duck = duck;
		this._observable = this;
	}

	QuackCounter(IQuackable duck, Observable observable)
	{
		this._duck = duck;
		this._observable = observable;
	}

	public void registerObserver(IObserver observer)
	{
		this._observable.registerObserver(observer);
	}

	public String notifyObservers()
	{
		return (this._observable.notifyObservers());
	}

	public String quack()
	{
		counter++;
		return (this._duck.quack() + " Decorator Counter quacks!");
	}

	public static int getQuacks()
	{
		return (counter);
	}

	@Override
	public String getName() { return (this._duck.getName()); }
}
