package com.codeup.springblog.models;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "posts")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int unsigned", nullable = false)
	private long id;

	@Column(columnDefinition = "varchar(200)", nullable = false)
	private String title;

	@Column(columnDefinition = "text", nullable = false)
	private String body;

	@ManyToOne
	@JoinColumn (name = "user_id")
	private User user;

	public Post(String title, String body, User user) {
		this.title = title;
		this.body = body;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Post(String title, String body){
		this.title = title;
		this.body = body;
	}

	public Post(){

	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
