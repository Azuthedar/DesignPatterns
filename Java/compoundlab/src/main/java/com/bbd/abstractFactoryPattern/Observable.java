package com.bbd.abstractFactoryPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Observable implements IQuackObservable
{
	IQuackObservable _observable;
	ArrayList<IObserver> observers = new ArrayList<>();

	Observable(IQuackObservable observable)
	{
		this._observable = observable;
	}

	public void registerObserver(IObserver observer)
	{
		observers.add(observer);
	}

	public String notifyObservers()
	{
		StringBuilder sb = new StringBuilder();
		for (IObserver observer : observers)
		{
			sb.append(observer.update(this._observable) + "\n");
		}
		return sb.toString().trim();
	}

	public String getName() { return ""; }
}
