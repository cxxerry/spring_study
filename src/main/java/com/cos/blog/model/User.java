package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

//ORM ->JAVA(다른 언어포함) Object를 테이블로 매핑해주는 기술 
@Entity		//User 클래스가 자동으로 MySQL에 테이블이 생성된다 .
public class User {
	
	@Id				//Primary key 
	@GeneratedValue(strategy =GenerationType.IDENTITY) //identity (시퀀스 or MySQL)를 이용하여 해당 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다 
	private int id; 	//오라클의 경우 시퀀스, MySQL의 경우 auto_increment를 의미함 
	
	@Column(nullable=false, length=30)			// username은 null이 될 수 없음 
	private String username; 			// 아이디
	
	@Column(nullable=false, length=100)			// password는 null이 될 수 없음 	//123456 => 해쉬 (비밀번호 암호화) 
	private String password; 	
	
	@Column(nullable=false, length=50)			// email은 null이 될 수 없음 
	private String email; 
	
	@ColumnDefault("'user'")				// 권한의 defualt 값을 user로 설정한다. 	//쌍타옴표 사이에 홑따옴표를 추가함으로서 문자임을 알린다. 
	private String role; 				// Enum전략을 쓰는 게 좋다. 	//Enum을 쓴다면 admin, user, manager 권한 중 하나로 도메인 설정을 String으로 하겠다.  
	
	@CreationTimestamp				// 값을 비워두고 insert 해도 현재 시간이 자동 입력 
	private Timestamp createDate; 
	

}
