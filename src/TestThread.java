

public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���߳�ѧϰ
		Hero gareen = new Hero();
		gareen.name ="����";
		gareen.hp = 1000;
		gareen.damage = 50;
		
		Hero teemo = new Hero();
		teemo.name = "��Ī";
		teemo.hp = 800;
		teemo.damage = 100;
		
		Hero bh = new Hero();
        bh.name = "�ͽ�����";
        bh.hp = 500;
        bh.damage = 65;
         
        Hero leesin = new Hero();
        leesin.name = "äɮ";
        leesin.hp = 455;
        leesin.damage = 80;
        
        
        //���߳�
//        while(!teemo.isDead()){
//        	gareen.attackHero(teemo);
//        }
//        while(!leesin.isDead()){
//        	bh.attackHero(leesin);
//        }
        
        //���߳� KillThread
//        killThread killTeemo = new killThread(gareen, teemo);
//        killTeemo.start();
//        killThread killLeesin = new killThread(bh, leesin);
//        killLeesin.start();
        
        //�̳� Runnable�ӿ�
//        Battle b1 = new Battle(gareen, teemo);
//        new Thread(b1).start(); //ֱ�ӵ���run��������������һ�����̣߳�������Ҫstart
//        
//        Battle b2 = new Battle(bh,leesin);
//        new Thread(b2).start();
        
        //ʹ��������
        Thread t1 = new Thread(){
        	public void run(){
        		//��дrun����
        		while(!teemo.isDead()){
        			gareen.attackHero(teemo);
        		}
        	}
        };
        
        Thread t2 = new Thread(){
        	public void run(){
        		while(!bh.isDead()){
        			leesin.attackHero(bh);
        		}
        	}
        };
        t1.setPriority(Thread.MAX_PRIORITY);//�������ȼ�
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
//        t1.run();	//���ֱ��ִ��run���������ᴴ���µ��߳�
//        t2.run();
	}

}
