package com.codeup.springblog.models;

import javax.persistence.*;

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
}
