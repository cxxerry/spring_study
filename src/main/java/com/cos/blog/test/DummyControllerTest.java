package com.cos.blog.test;

import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController			//회원가입이 잘 됐다 안 됐다를 응답하는 컨트롤러
public class DummyControllerTest {
	
	@Autowired		//의존성주입(Di)
	private UserRepository userRepository; 

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
		
		userRepository.save(user);
		return "회원가입이 완료되었습니다"; 
	}

}
