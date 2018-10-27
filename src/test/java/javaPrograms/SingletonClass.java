package javaPrograms;

public class SingletonClass {

	private static SingletonClass signleton_instance=null;
	public String str;
	
	private SingletonClass() {
		str= "Hey I am using Singleton class pattern";
	}
	
	public static SingletonClass getInstance() {
		if(signleton_instance==null) {
			signleton_instance= new SingletonClass();
		}
		return signleton_instance;
	}
			
	public static void main(String[] args) {
	SingletonClass x=SingletonClass.getInstance();
	SingletonClass y=SingletonClass.getInstance();
	SingletonClass z=SingletonClass.getInstance();
	
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
