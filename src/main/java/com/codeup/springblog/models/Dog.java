package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int(11) unsigned")
	private long id;

	@Column(columnDefinition = "tinyint(3) unsigned NOT NULL", unique = true)
	private int age;

	@Column(columnDefinition = "varchar(200) NOT NULL")
	private String name;

	@Column(columnDefinition = "char(2) DEFAULT 'XX'")
	private String resideState;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResideState() {
		return resideState;
	}

	public void setResideState(String resideState) {
		this.resideState = resideState;
	}
}
