package com.bbd.abstractFactoryPattern;

public class RubberDuck implements IQuackable
{
	private String _name = "Rubber Duck";
	IQuackObservable _observable;

	RubberDuck()
	{
		this._observable = new Observable(this);
	}

	RubberDuck(IQuackObservable observable)
	{
		this._observable = observable;
	}

	public String quack()
	{
		notifyObservers();
		return ("Rubber duck quacks");
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
