package com.bbd.abstractFactoryPattern;

public class MallardDuck implements IQuackable
{
	private String _name = "Mallard Duck";
	private IQuackObservable _observable;

	MallardDuck()
	{
		this._observable = new Observable(this);
	}

	MallardDuck(IQuackObservable observable)
	{
		this._observable = observable;
	}

	public String quack()
	{
		notifyObservers();
		return ("Mallard Duck Quacks");
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
