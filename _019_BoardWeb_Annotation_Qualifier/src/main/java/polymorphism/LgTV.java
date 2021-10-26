package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component//==> id나 name 미지정 시 lgTV 자동으로 이름이 지정됨
//<bean class="polymorphism.LgTV></bean>
@Component("tv")
//<bean id="tv" class="polymorphism.LgTV></bean>
public class LgTV implements TV {
	//@Autowired 어노테이션 사용 시 생성자, setter 메소드를 이용한 의존성 주입이 이뤄지지 않음
	//@Qualifier : 동일한 타입의 객체가 두 개 이상 생성되어 있을 때 명확하게 지정해서 의존성 주입할 때 사용.
	@Autowired // 두개 이상 사용 가능하고 autowired가 먼저 선언되고 아래 qualifier를 선언하여 사용하자.
	@Qualifier("apple")
	private Speaker speaker;
	
	public void powerOn() {
		System.out.println("LgTV---전원 켠다.");
	}
	
	public void powerOff() {
		System.out.println("LgTV---전원 끈다.");
	}
	
	public void volumeUp() {
		speaker.volumeUp();
	}
	
	public void volumeDown() {
		speaker.volumeDown();
	}
}
