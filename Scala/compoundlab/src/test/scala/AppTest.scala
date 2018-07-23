import org.scalatest.FlatSpec

class AppTest extends FlatSpec {

	val goose : Goose = new Goose
	val gooseAdapter : GooseAdapter = new GooseAdapter(goose)

	val mallardDuck : MallardDuck = new MallardDuck
	val redHeadDuck : RedheadDuck = new RedheadDuck
	val rubberDuck : RubberDuck = new RubberDuck
	val duckCall : DuckCall = new DuckCall

	var mallardCounterDuck : QuackCounter = new QuackCounter(mallardDuck)

	val duckFactory : DuckFactory = new DuckFactory
	val duckCounterFactory : DuckCounterFactory = new DuckCounterFactory

	val flock : Flock = new Flock()

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
		QuackCounter.setCounterToZero
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
		QuackCounter.setCounterToZero
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
}
