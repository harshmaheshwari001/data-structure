package designPattern;

public class SingletonPattern {

	public static void main(String[] args) {

		// SingleTonObject obj = SingleTonObject.INSTANCE;
		// obj.getMethod();
		Runnable r = () -> {
			
			try {
				Thread.sleep(1000);
				SingleTonObject obj = SingleTonObject.INSTANCE;
				//SingleTonObjectClass obj = new SingleTonObjectClass();
				obj.getMethod(Thread.currentThread().getName());
				
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		
		Thread t = new Thread(r);
		t.start();
		
		Thread t1 = new Thread(r);
		t1.start();
		

	}
	/**
	 * SingleTon Pattern using Enum
	 * @author harsmahe
	 *
	 */
	public enum SingleTonObject {
		INSTANCE;
		public void getMethod(String nameofThread) {
			System.out.println(nameofThread +" -- " + INSTANCE.hashCode());
		}
	}
	
//	public static class SingleTonObjectClass {
//		//INSTANCE;
//		public void getMethod(String nameofThread) {
//			System.out.println(nameofThread +" -- " + this.hashCode());
//		}
//	}

}
