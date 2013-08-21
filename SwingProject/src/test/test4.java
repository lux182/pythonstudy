package test;

public class test4 {
	public static void main(String[] args) {
		String a = test.test1.toString();
		System.out.println(a);
	
		switch(test.test2){
			case test1: System.out.println("test1");
			case test2: System.out.println("test2");
		}
	}
}
	enum test{
	test1,
	test2
}