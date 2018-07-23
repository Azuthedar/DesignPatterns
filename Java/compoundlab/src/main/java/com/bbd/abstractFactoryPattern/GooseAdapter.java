package com.bbd.abstractFactoryPattern;

public class GooseAdapter implements IQuackable
{
	private Goose _goose;
	private IQuackObservable _observable;
	private String _name = "Goose";

	GooseAdapter(Goose goose)
	{
		this._goose = goose;
		this._observable = new Observable(this);
	}

	GooseAdapter(Goose goose, IQuackObservable observable)
	{
		this._goose = goose;
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
		notifyObservers();
		return (this._goose.honk());
	}

	@Override
	public String getName() { return  this._name;}
}
