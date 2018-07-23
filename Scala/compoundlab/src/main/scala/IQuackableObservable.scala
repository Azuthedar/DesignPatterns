trait IQuackableObservable {
	def registerObserver(observer : IObserver) : Unit
	def notifyObservers : String
	def getName : String
}
