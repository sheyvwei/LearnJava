
public class TestConcurrency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final Object someObject = new Object();	//final���η�һ����ֵ���Ͳ������޸�
		Hero gareen = new Hero();
		gareen.name = "����";
		gareen.hp = 1000;
		System.out.printf("%s �ĳ�ʼֵ�� %.0f%n", gareen.name, gareen.hp);
		int n = 1000;
		//n���߳�����Ѫ��
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
		//����
		for(int i = 0; i < n; i++){
			Thread t = new Thread(){
				public void run(){
					//ʹ��synchronized����1
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
		//�ȴ������߳̽��� ----ʹ��join���̼߳��뵽���߳�
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
		
		System.out.printf("%d ����Ѫ�����Ӻ�  %d Ѫ�����ٺ� ��Ѫ���ĸ��ױ���� %.0f%n", n,n,gareen.hp);
	}

}
