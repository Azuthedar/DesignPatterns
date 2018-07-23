

class DuckCall(observable: Option[IQuackableObservable] = None) extends IQuackable {

	private val name = "Duck Call"
	private val _observable : IQuackableObservable = observable getOrElse new Observable(this)

	override def registerObserver(observer : IObserver) : Unit = {
		this._observable.registerObserver(observer)
	}

	override def notifyObservers: String = {
		this._observable.notifyObservers
	}

	override def quack : String = {
		notifyObservers
		"Duck called"
	}

	override def getName: String = {
		this.name
	}
}
