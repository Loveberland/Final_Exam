package Final_Exam.models;

abstract public class ItemBuff {
	protected String name;
	protected double base;
	protected double rate;

	public ItemBuff(String name, double base, double rate) {
		this.name = name;
		this.base = base;
		this.rate = rate;
	}
}
