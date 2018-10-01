package javaPrograms;

public class Singleton {

	private static Singleton signleton_instance=null;
	public String str;
	
	private Singleton() {
		str= "Hey I am using Singleton class pattern";
	}
	
	public static Singleton getInstance() {
		if(signleton_instance==null) {
			signleton_instance= new Singleton();
		}
		return signleton_instance;
	}
			
	public static void main(String[] args) {
	Singleton x=Singleton.getInstance();
	Singleton y=Singleton.getInstance();
	Singleton z=Singleton.getInstance();
	
	x.str=(x.str).toUpperCase();
	
	System.out.println(x.str);
	System.out.println(y.str);
	System.out.println(z.str);
	
    z.str=(z.str).toLowerCase();
	
	System.out.println(x.str);
	System.out.println(y.str);
	System.out.println(z.str);
	}
}
