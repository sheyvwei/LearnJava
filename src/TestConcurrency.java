
public class TestConcurrency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final Object someObject = new Object();	//final修饰符一经赋值，就不可以修改
		Hero gareen = new Hero();
		gareen.name = "盖伦";
		gareen.hp = 1000;
		System.out.printf("%s 的初始值是 %.0f%n", gareen.name, gareen.hp);
		int n = 1000;
		//n个线程增加血量
		Thread[] addHP = new Thread[n];
		Thread[] reduceHP = new Thread[n];
		
		for(int i = 0; i < n; i++){
			Thread t = new Thread(){
				public void run(){
					
					synchronized (someObject) {
                        gareen.recover();
                    }					
					try{
						Thread.sleep(100);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			};
			t.start();
			addHP[i] = t;
		}
		//减少
		for(int i = 0; i < n; i++){
			Thread t = new Thread(){
				public void run(){
					//使用synchronized方法1
					synchronized (someObject) {
						gareen.hurt();
                    }
					try{
						Thread.sleep(100);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			};
			t.start();
			reduceHP[i] = t;
		}
		//等待所有线程结束 ----使用join把线程加入到主线程
		for(Thread t: addHP){
			try{
				t.join();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		for(Thread t: reduceHP){
			try{
				t.join();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
		System.out.printf("%d 多少血量增加和  %d 血量减少后 ，血量的盖伦变成了 %.0f%n", n,n,gareen.hp);
	}

}
