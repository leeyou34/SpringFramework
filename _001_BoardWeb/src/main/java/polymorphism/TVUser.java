package polymorphism;

public class TVUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SamsungTV tv = new SamsungTV();
		LgTV tv2 = new LgTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		tv2.powerOn();
		tv2.volumeUp();
		tv2.volumeDown();
		tv2.powerOff();
	}

}
