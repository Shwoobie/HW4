// the Seq base class

public abstract class Seq {
	protected int num;
	protected int value;
	protected int initial;
	protected int delta;
	protected int [] values;


	abstract String toString();
	abstract void Jumble();
	abstract void Delta();
	abstract void Constant();
}
