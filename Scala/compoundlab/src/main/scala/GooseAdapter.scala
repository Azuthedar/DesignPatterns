class GooseAdapter(goose : Goose) extends IQuackable {
	def quack : String = {
		this.goose.honk
	}
}
