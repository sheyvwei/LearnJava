
public class Hero {
	public String name;
	public float hp;
	public int damage; //损伤,攻击力
	public void attackHero(Hero h){
		try{
			Thread.sleep(1);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		h.hp -= damage;
		System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
		if(h.isDead()){
			System.out.println(h.name + "死了");
		}
	}
	public boolean isDead(){
		return 0 >= hp ? true : false;
	}
	//学习concurrency 使用synchronized :方法2
	public synchronized void recover(){
		hp += 1;
	}
	public  void hurt(){
//		hp -= 1;
		//在类中直接使用synchronized(object)
		 //使用this作为同步对象
		//方法3
		synchronized(this){
			hp -= 1;
		}
	}
}
