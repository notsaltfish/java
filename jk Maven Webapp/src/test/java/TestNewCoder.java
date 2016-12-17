
public class TestNewCoder {
	public static void main(String[] args){
		Object o = new Object(){
		//int e=0;
		//s="ss"?"ss":"sss";
			int i=8==8?8:9;
			@Override
			public boolean equals(Object obj) {
						return true;
			}
		};
		
		System.out.println(o.equals("ssss"));
		
	}

}
