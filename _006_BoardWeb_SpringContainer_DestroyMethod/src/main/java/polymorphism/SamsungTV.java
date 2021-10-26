package polymorphism;

public class SamsungTV implements TV{
	
	public void initMethod() { // 생성자...
		System.out.println("객체 초기화 작업 처리...");
	}
	
	public void destroyMethod() { // 생성자...
		System.out.println("객체 삭제 전에 처리할 로직 처리...");
	}
	
	public void powerOn() {
		System.out.println("SamsungTV--- 전원을 킨다.");
	}
	
	public void powerOff() {
		System.out.println("SamsungTV--- 전원을 끈다.");
	}
	
	public void volumeUp() {
		System.out.println("SamsungTV--- 소리를 올린다.");
	}
	
	public void volumeDown() {
		System.out.println("SamsungTV--- 소리를 내린다..");
	}
	
}
