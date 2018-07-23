class QuackCounter(duck : IQuackable, observable : Option[IQuackableObservable] = None) extends IQuackable {

	private val name = duck.getName + " counter"
	private val _observable = observable getOrElse new Observable(this)

	def quack : String = {
		QuackCounter.incrementCounter()
		notifyObservers
		duck.quack + " decorated with a counter"
	}

	override def getName: String = {
		this.name
	}

	override def registerObserver(observer: IObserver): Unit = {
		this._observable.registerObserver(observer)
	}

	override def notifyObservers: String = {
		this._observable.notifyObservers
	}
}

object QuackCounter
{
	private var quackCounter : Int = 0

	def incrementCounter() : Unit = {
		quackCounter += 1
	}

	def counterToZero() : Unit = quackCounter = 0
	def getCounter : Int = quackCounter

}
