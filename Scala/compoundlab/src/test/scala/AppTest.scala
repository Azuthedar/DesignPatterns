import org.scalatest.FlatSpec

class AppTest extends FlatSpec {

	val goose : Goose = new Goose
	val gooseAdapter : GooseAdapter = new GooseAdapter(goose)

	val mallardDuck : MallardDuck = new MallardDuck
	val redHeadDuck : RedheadDuck = new RedheadDuck
	val rubberDuck : RubberDuck = new RubberDuck

	"A duck" should "quack properly" in {
		assert("Mallard duck quacked" == mallardDuck.quack)
	}

	"Different ducks".should("not have the same quack") in {
		assert(redHeadDuck.quack != rubberDuck.quack)
	}

	"An adapter".should("allow another type to quack").in {
		assert("Goose honked" == gooseAdapter.quack)
	}


}
