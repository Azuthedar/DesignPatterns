import scala.collection.mutable.ArrayBuffer

class Flock extends IQuackable {

	val flock : ArrayBuffer[IQuackable] = ArrayBuffer[IQuackable]()

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
}
