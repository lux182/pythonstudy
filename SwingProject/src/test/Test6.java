package test;

 

public class Test6   {

	public static void main(String[] args) {
		String path = "/a/b/c/d/1/2";
		for(int i=0;i<2;i++){
			int index = path.lastIndexOf("/");
			path = path.substring(0, index);
		}
		path=path+"/recycle/virtualmachine";
		System.out.println(path);
	}
}
