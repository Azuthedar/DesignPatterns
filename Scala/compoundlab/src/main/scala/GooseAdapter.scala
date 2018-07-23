class GooseAdapter(goose : Goose) extends IQuackable {
	override def quack : String = {
		this.goose.honk
	}
}
