package javaPrograms.BuilderPattern;

public class Shop {

	public static void main(String[] args) {

		Phone phone = new PhoneBuilder().setOS("Android").setProcessor("Qualcomm").getPhone();
		System.out.println(phone);

	}
}
