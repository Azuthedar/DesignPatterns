class Quackologist extends IObserver {

	override def update(observable: IQuackableObservable): String = {
		"Quackologist says: \"Duck of type " + observable.getName + " quacked.\""
	}
}
