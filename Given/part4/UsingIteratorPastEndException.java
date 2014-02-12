static ﬁnal long serialVersionUID = 69L;

class UsingIteratorPastEndException extends Exception {

	public UsingIteratorPastEndException(String msg){
	super(msg); // call constructor in superclass (i.e., base class); it saves message and a bit more.
	}
}