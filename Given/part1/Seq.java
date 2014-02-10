// the Seq base class

public abstract class Seq {
	protected int num;
	protected int value;
	protected int initial;
	protected int delta;
	protected int [] values;


	abstract String toString();
	abstract void Constant( int num, int value );
	abstract void Delta( int num, int initial, int delta );
	abstract void Jumble( int [] values);
}
