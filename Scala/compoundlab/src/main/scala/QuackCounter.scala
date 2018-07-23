class QuackCounter(duck : IQuackable) extends IQuackable {

	def quack : String = {
		QuackCounter.incrementCounter()
		duck.quack + " decorated with a counter"
	}
}

object QuackCounter
{
	private var quackCounter : Int = 0

	def incrementCounter() : Unit = {
		quackCounter += 1
	}

	def getCounter : Int = quackCounter
}
