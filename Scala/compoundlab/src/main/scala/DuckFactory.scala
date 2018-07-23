class DuckFactory extends IDuckFactory {
	override def createMallardDuck : IQuackable = {
		new MallardDuck
	}

	override def createRedheadDuck : IQuackable = {
		new RedheadDuck
	}

	override def createDuckCall : IQuackable = {
		new DuckCall
	}

	override def createRubberDuck : IQuackable = {
		new RubberDuck
	}
}
