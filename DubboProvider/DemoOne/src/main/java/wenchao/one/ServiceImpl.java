package wenchao.one;



import org.springframework.stereotype.Service;

import wenchao.one.service.MyService;
@Service("myService")
public class ServiceImpl implements MyService{


	public String cry() {
		return "cry is show unable";
	}

	public String say(String name) {
		return name+" hello";
	}

}
