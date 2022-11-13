package com.cos.blog.repository;

import com.cos.blog.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

//밑의 JpaRepository는 User테이블을 관리하는 레파지토리이며, 
//User테이블의 프라이머리키는 Integer이다. 
//자동으로 bean등록이 된다.
//@Repository 생략 가능 
public interface UserRepository extends JpaRepository<User,Integer>{
	
}
