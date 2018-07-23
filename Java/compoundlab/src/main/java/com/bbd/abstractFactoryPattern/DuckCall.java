package com.bbd.abstractFactoryPattern;


import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class DuckCall implements IQuackable
{
	private String _name = "DuckCall";
	private IQuackObservable _observable;

	DuckCall()
	{
		this._observable = new Observable(this);
	}

	DuckCall(IQuackObservable observable)
	{
		this._observable = observable;
	}

	public String quack()
	{
		notifyObservers();
		return ("Duck calls");
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
