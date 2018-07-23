class GooseAdapter(goose : Goose, observable: Option[IQuackableObservable] = None) extends IQuackable
{
	private val name = "GooseAdapter"
	private val _goose : Goose = goose
	private val _observable : IQuackableObservable = observable getOrElse new Observable(this)


	override def registerObserver(observer : IObserver) : Unit = {
		this._observable.registerObserver(observer)
	}

	override def notifyObservers: String = {
		this._observable.notifyObservers
	}
	override def quack : String = {
		notifyObservers
		this._goose.honk
	}

	override def getName: String = {
		this.name
	}
}
