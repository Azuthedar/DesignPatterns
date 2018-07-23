package com.bbd.abstractFactoryPattern;

public interface IQuackObservable
{
	void registerObserver(IObserver observer);
	String notifyObservers();
	String getName();
}
