import scala.collection.mutable.ArrayBuffer

class Observable(observable : IQuackableObservable) extends IQuackableObservable {
	private val observers : ArrayBuffer[IObserver] = ArrayBuffer[IObserver]()
	private val name = "Observable"

	override def registerObserver(newObserver : IObserver) : Unit = {
		observers.append(newObserver)
	}

	override def notifyObservers : String = {
		val sb = new StringBuilder

		observers.foreach(observer => {
			sb.append(observer.update(observable) + "\n")
		})
		sb.toString.trim
	}

	override def getName: String = {
		this.name
	}
}
