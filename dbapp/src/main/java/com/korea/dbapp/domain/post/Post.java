package com.korea.dbapp.domain.post;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.korea.dbapp.domain.user.User;

// 글쓰기 만들기
@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // 프라이머리키(기본키)
	private String title; // varchar(255), 255는 글자수 
	@Lob
	private String content;
	
	// jpa(Java Persistence API) 자바로 영구히 데이터 저장 파일/데이터베이스에 함수의 모임
	@JoinColumn(name = "myId")
	@ManyToOne
	private User user; // ORM 사용-> Hibernate 사용 -> foreign Key 생성
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
