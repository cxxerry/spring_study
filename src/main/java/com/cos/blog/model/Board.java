package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data				//getter,setter가 없기 때문에 
@NoArgsConstructor 				//빈생성자 
@AllArgsConstructor				//전체 생성자
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
	
	@ManyToOne(fetch=FetchType.EAGER)			//Many = Board, One = User   즉, 여러 개의 게시글은 한 명의 유저에 의해 쓰일 수 있다 
 	@JoinColumn(name="userId")
	private User user; 			//DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다 

	@OneToMany(mappedBy="board",fetch=FetchType.EAGER )		//mappedBy의 뜻 : 연관관계의 주인이 아니다.(=즉, 난 FK가 아니다) DB에 칼럼을 만들지 않는다 
	List<Reply> reply; 	//하나의 게시글 (Board)에 답글은 여러 개 달릴 수 있으므로 List처리 해주어야 한다. 
	
	@CreationTimestamp				// 데이터가 insert되거나 update 될 때 자동으로 현재 시간 데이터가 들어감 
	private Timestamp createDate; 
	
	
	
}
