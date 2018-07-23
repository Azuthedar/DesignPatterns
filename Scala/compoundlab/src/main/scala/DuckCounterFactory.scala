class DuckCounterFactory extends IDuckFactory {
	override def createDuckCall: IQuackable = {
		new QuackCounter(new DuckCall)
	}

	override def createMallardDuck: IQuackable = {
		new QuackCounter(new MallardDuck)
	}

	override def createRedheadDuck: IQuackable = {
		new QuackCounter(new RedheadDuck)
	}

	override def createRubberDuck: IQuackable = {
		new QuackCounter(new RubberDuck)
	}
}
