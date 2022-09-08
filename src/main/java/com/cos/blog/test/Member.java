package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Member {
	
	//함수를 통해 변수에 접근해야하므로 
	//변수는 항상 private으로 생성하고, 함수는 public으로 만들어준다. 
	private int id;				
	private String username;		
	private String password;
	private String email;
	
	@Builder
	public Member(int id, String username, String password, String email) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	} 
	
	
}
