package com.bbd.abstractFactoryPattern;

import java.util.ArrayList;
import java.util.List;

public class Flock implements IQuackable
{
	private String _name = "Flock";
	private List<IQuackable> flock;
	private IQuackObservable _observable;

	Flock()
	{
		flock = new ArrayList<IQuackable>();
		this._observable = new Observable(this);
	}

	Flock(IQuackObservable observable)
	{
		this._observable = observable;
	}

	public void add(IQuackable duck)
	{
		flock.add(duck);
	}

	@Override
	public void registerObserver(IObserver observer)
	{
		this._observable.registerObserver(observer);
	}

	@Override
	public String notifyObservers()
	{
		return (this._observable.notifyObservers());
	}

	@Override
	public String quack()
	{
		StringBuilder sb = new StringBuilder();
		notifyObservers();
		for (IQuackable duck : flock)
		{
			sb.append(duck.quack() + " inside the flock\n");
		}

		return (sb.toString());
	}

	@Override
	public String getName() { return (this._name);}
}
