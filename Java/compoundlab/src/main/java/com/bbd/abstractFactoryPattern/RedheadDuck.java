package com.bbd.abstractFactoryPattern;

public class RedheadDuck implements IQuackable
{
	IQuackObservable _observable;
	private String _name = "Red Head Duck";

	RedheadDuck()
	{
		this._observable = new Observable(this);
	}

	RedheadDuck(IQuackObservable observable)
	{
		this._observable = observable;
	}

	public String quack()
	{
		notifyObservers();
		return ("Red head duck quacks");
	}

	public void registerObserver(IObserver observer)
	{
		this._observable.registerObserver(observer);
	}

	public String notifyObservers()
	{
		return (this._observable.notifyObservers());
	}

	@Override
	public String getName() { return  this._name;}
}
