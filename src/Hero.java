
public class Hero {
	public String name;
	public float hp;
	public int damage; //����,������
	public void attackHero(Hero h){
		try{
			Thread.sleep(1);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		h.hp -= damage;
		System.out.format("%s ���ڹ��� %s, %s��Ѫ����� %.0f%n",name,h.name,h.name,h.hp);
		if(h.isDead()){
			System.out.println(h.name + "����");
		}
	}
	public boolean isDead(){
		return 0 >= hp ? true : false;
	}
	//ѧϰconcurrency ʹ��synchronized :����2
	public synchronized void recover(){
		hp += 1;
	}
	public  void hurt(){
//		hp -= 1;
		//������ֱ��ʹ��synchronized(object)
		 //ʹ��this��Ϊͬ������
		//����3
		synchronized(this){
			hp -= 1;
		}
	}
}
