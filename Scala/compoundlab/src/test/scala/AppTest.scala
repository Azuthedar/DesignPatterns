import org.scalatest.FlatSpec

class AppTest extends FlatSpec {

	var goose : Goose = new Goose
	var gooseAdapter : GooseAdapter = new GooseAdapter(goose)

	var mallardDuck : MallardDuck = new MallardDuck
	var redHeadDuck : RedheadDuck = new RedheadDuck
	var rubberDuck : RubberDuck = new RubberDuck
	var duckCall : DuckCall = new DuckCall

	var mallardCounterDuck : QuackCounter = new QuackCounter(mallardDuck)

	val duckFactory : DuckFactory = new DuckFactory
	val duckCounterFactory : DuckCounterFactory = new DuckCounterFactory

	var flock : Flock = new Flock()

	val quackologist : Quackologist = new Quackologist

	"A duck" should "quack properly" in {
		assert("Mallard duck quacked" == mallardDuck.quack)
	}

	"Different ducks".should("not have the same quack") in {
		assert(redHeadDuck.quack != rubberDuck.quack)
	}

	"An adapter".should("allow another type to quack").in {
		assert("Goose honked" == gooseAdapter.quack)
	}

	"Decorator".should("wrap around a duck").in {
		val decorator : QuackCounter = new QuackCounter(redHeadDuck)

		decorator.quack
		decorator.quack
		decorator.quack

		assert(QuackCounter.getCounter == 3)
		QuackCounter.counterToZero()
	}

	"Default factory".should("create ducks of the specified type") in {
		assert(mallardDuck.quack == duckFactory.createMallardDuck.quack)
		assert(redHeadDuck.quack == duckFactory.createRedheadDuck.quack)
		assert(rubberDuck.quack == duckFactory.createRubberDuck.quack)
		assert(duckCall.quack == duckFactory.createDuckCall.quack)
	}

	"Counter factory".should("create ducks of the specified types and count number of quacks") in {
		assert(mallardDuck.quack + " decorated with a counter" == duckCounterFactory.createMallardDuck.quack)
		assert(redHeadDuck.quack + " decorated with a counter" == duckCounterFactory.createRedheadDuck.quack)
		assert(rubberDuck.quack + " decorated with a counter" == duckCounterFactory.createRubberDuck.quack)
		assert(duckCall.quack + " decorated with a counter" == duckCounterFactory.createDuckCall.quack)

		assert(QuackCounter.getCounter == 4)
		QuackCounter.counterToZero()
	}

	"Flocks".should("be able to return all instances of type IQuackables even if there's a flock inside a flock") in {
		val smallerFlock : Flock = new Flock()
		smallerFlock.add(mallardDuck)
		smallerFlock.add(redHeadDuck)

		flock.add(rubberDuck)
		flock.add(smallerFlock)

		val sb = new StringBuilder

		sb.append(rubberDuck.quack + " from a flock\n")
		sb.append(mallardDuck.quack + " from a flock\n")
		sb.append(redHeadDuck.quack + " from a flock\n")
		sb.append(" from a flock\n")

		assert(flock.quack == sb.toString)
	}

	"Observers".should("be notified about what happens to the observables") in {
		//rubberDuck listens on in mallardDuck's notifications
		mallardDuck = new MallardDuck(Option.apply(rubberDuck))
		mallardDuck.registerObserver(quackologist)

		print("1: " + mallardDuck.notifyObservers + "\n")

		assert(mallardDuck.notifyObservers == "Quackologist says: \"Duck of type Rubber Duck quacked.\"")

		//Applies to itself
		mallardDuck = new MallardDuck()
		mallardDuck.registerObserver(quackologist)

		print("2: " + mallardDuck.notifyObservers + "\n")

		assert(mallardDuck.notifyObservers == "Quackologist says: \"Duck of type Mallard Duck quacked.\"")

		//Go down in the hierarchy of the flock and apply it on it's children nodes
		mallardDuck = new MallardDuck()

		val smallFlock = new Flock()

		smallFlock.add(new MallardDuck())
		smallFlock.add(new DuckCall())

		flock = new Flock()

		flock.add(mallardDuck)
		flock.add(rubberDuck)
		flock.add(redHeadDuck)
		flock.add(smallFlock)

		flock.registerObserver(quackologist)

		print("3: {\n" + flock.notifyObservers + "\n}")

		assert(flock.notifyObservers == "Quackologist says: \"Duck of type Mallard Duck quacked.\"\nQuackologist says: \"Duck of type Rubber Duck quacked.\"" +
		                                "\nQuackologist says: \"Duck of type Rubber Duck quacked.\"\nQuackologist says: \"Duck of type Red head Duck quacked.\"" +
		                                "\nQuackologist says: \"Duck of type Mallard Duck quacked.\"\nQuackologist says: \"Duck of type Duck Call quacked.\"")
	}
}
