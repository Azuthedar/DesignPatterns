package com.bbd.abstractFactoryPattern;

import java.util.ArrayList;
import java.util.List;

public class Quackologist implements IObserver
{
	private List<IQuackObservable> observers = new ArrayList<>();

	public String update(IQuackObservable duck)
	{
		return ("Quackologist: The duck > " + duck.getName() + " quacked");
	}
}
