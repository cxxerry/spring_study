package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

//html 파일이 아니라 data를 리턴해주는 controller = RestController 
@RestController			//회원가입이 잘 됐다 안 됐다를 응답하는 컨트롤러
public class DummyControllerTest {
	
	@Autowired		//의존성주입(Di)
	private UserRepository userRepository; 

	// {id}주소로 파라메터를 전달 받을 수 있음 
	// ex)   https://localhost:8000/blog/dummy/user/5
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		
		//만약 user/4를 찾으면 내가 데이터베이스에서 못 찾아오게 되면 user가 null이 될 것 아냐?
		// 그럼 return null이 리턴되자나.. 그럼 프로그램에 문제가 있지 않겠나?
		// Optional로 너의 User 객체를 감싸서 가져올테니 null인지 아닌지 판단해서 return해!
		
		//람다식
		
		//	User user = userRepository.findById(id).orElseThrow(()->{
		//		return new IllegalArgumentException("해당 사용자는 없습니다.");
			//});

		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 사용자가 없습니다.");
			}
		});
		
		//요청 : 웹브라우저 
		//user객체 = 자바 오브젝트 
		//변환 (웹브라우저가 이해할 수 있는 데이터) -> json (Gson 라이브러리) 
		//스프링부트 = MessageConverter라는 애가 응답시에 자동 작동
		//만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
		//user 오브젝트를 json으로 변환해서 브라우저에게 던져준다. 
		return user; 
	}
	
	//http://localhost:8000/blog/dummy/join (요청) 
	//http의 body에 username, password, email 데이터를 가지고 (요청)
	@PostMapping	("/dummy/join")		
	//회원가입시 데이터 insert 해야하므로 postmapping 해주고,
	//주소는 dummy의 join으로 해줌
	public String join(User user) {
		System.out.println("Id: " + user.getId());
		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getEmail());
		System.out.println("role: " + user.getRole());
		System.out.println("createDate: " + user.getCreateDate());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다"; 
	}

}
