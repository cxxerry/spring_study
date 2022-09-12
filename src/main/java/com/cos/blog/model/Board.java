package com.cos.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)			// 넘버링 전략을 IDENTITY로 잡고 auto_increment를 쓰겠다. 
	private int id; 
	
	@Column(nullable=false, length=100)
	private String title; 
	
	@Lob				// 대용량 데이터
	private String content; 		// 섬머노트 라이브러리 <html> 태그가 섞여서 디자인이 됨. 
	
	@ColumnDefault("0")
	private int count;			//	조회수
	
	@ManyToOne					//Many = Board, One = User   즉, 여러 개의 게시글은 한 명의 유저에 의해 쓰일 수 있다 
 	@JoinColumn(name="userId")
	private User user; 			//DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다 
	
	@CreationTimestamp				// 데이터가 insert되거나 update 될 때 자동으로 현재 시간 데이터가 들어감 
	private Timestamp createDate; 
	
	
	
}
