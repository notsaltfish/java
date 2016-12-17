
public abstract class TestVolatile {

	
	public volatile static int count = 0;
	 
    public static void inc() {
 
        //这里延迟1毫秒，使得结果明显
 
        count++;
      
        	System.out.println(count);
    }
 
    public static void main(String[] args) {
 
        //同时启动1000个线程，去进行i++计算，看看实际结果
 
       /* for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                	TestVolatile.inc();
                }
            }).start();
        }*/
 
   /*     try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        //这里每次运行的值都有可能不同,可能为1000
        System.out.println("运行结果:Counter.count=" + TestVolatile.count);
   */ 	
        
        /*
    	Integer i = 42;
    	long l = 42l;
    	Long l2=42l;
    	Double d = 42.0;
    	int i1 = 42;
    	System.out.println(l2==l);
    	System.out.println(i.equals(d));
    	System.out.println(l2.toString());
    	//System.out.println(i==l);
*/    	
    	
    	 Thread t = new Thread() {
             public void run() {
                 pong();
             }
         };
         t.start();
         System.out.print("ping");
    	
    }
    static void pong() {
        System.out.print("pong");
    }
}
