import scala.collection.mutable.ArrayBuffer

class Flock extends IQuackable {

	private var name = "Flock"
	private val flock : ArrayBuffer[IQuackable] = ArrayBuffer[IQuackable]()

	override def registerObserver(observer: IObserver): Unit = {
		flock.foreach(duck => {
			duck.registerObserver(observer)
		})
	}

	override def notifyObservers: String = {
		val sb : StringBuilder = new StringBuilder
		flock.foreach(duck => {
			sb.append(duck.notifyObservers + "\n")
		})
		sb.toString().trim
	}

	def add(duck : IQuackable) : Unit = {
		flock.append(duck)
	}

	def quack : String = {
		val sb = new StringBuilder

		flock.foreach(flock => {
			sb.append(flock.quack + " from a flock\n")
		})

		sb.toString()
	}

	override def getName: String = {
		this.name
	}
}
