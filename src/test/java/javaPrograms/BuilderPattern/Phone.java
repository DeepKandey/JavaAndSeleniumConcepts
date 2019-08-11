package javaPrograms.BuilderPattern;

public class Phone {

	private String oS;
	private int ram;
	private String processor;
	private double screenSize;
	private int battery;

	public Phone(String oS, int ram, String processor, double screenSize, int battery) {
		this.oS = oS;
		this.ram = ram;
		this.processor = processor;
		this.screenSize = screenSize;
		this.battery = battery;
	}

	@Override
	public String toString() {
		return "Phone [os=" + oS + " ,ram= " + ram + " ,processor= " + processor + " ,screenSize= " + screenSize
				+ " ,battery= " + battery + "]";
	}
}
