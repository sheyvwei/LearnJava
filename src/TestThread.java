

public class TestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//多线程学习
		Hero gareen = new Hero();
		gareen.name ="盖伦";
		gareen.hp = 1000;
		gareen.damage = 50;
		
		Hero teemo = new Hero();
		teemo.name = "提莫";
		teemo.hp = 800;
		teemo.damage = 100;
		
		Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;
         
        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;
        
        
        //单线程
//        while(!teemo.isDead()){
//        	gareen.attackHero(teemo);
//        }
//        while(!leesin.isDead()){
//        	bh.attackHero(leesin);
//        }
        
        //多线程 KillThread
//        killThread killTeemo = new killThread(gareen, teemo);
//        killTeemo.start();
//        killThread killLeesin = new killThread(bh, leesin);
//        killLeesin.start();
        
        //继承 Runnable接口
//        Battle b1 = new Battle(gareen, teemo);
//        new Thread(b1).start(); //直接调用run方法并不会启动一个新线程，所欲需要start
//        
//        Battle b2 = new Battle(bh,leesin);
//        new Thread(b2).start();
        
        //使用匿名类
        Thread t1 = new Thread(){
        	public void run(){
        		//重写run方法
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
        t1.setPriority(Thread.MAX_PRIORITY);//设置优先级
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
//        t1.run();	//如果直接执行run方法，不会创建新的线程
//        t2.run();
	}

}
