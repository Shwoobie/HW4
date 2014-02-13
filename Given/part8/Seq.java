// the Seq base class

public abstract class Seq {
	protected int num;
	protected int value;
	protected int initial;
	protected int delta;
	protected int [] values;
    public abstract int min();
    public abstract SeqIt createSeqIt();
}
