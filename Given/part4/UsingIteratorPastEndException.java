

class UsingIteratorPastEndException extends Exception {
	static ﬁnal long serialVersionUID = 98L;
	public UsingIteratorPastEndException(String msg){
	super(msg); // call constructor in superclass (i.e., base class); it saves message and a bit more.
	}
}