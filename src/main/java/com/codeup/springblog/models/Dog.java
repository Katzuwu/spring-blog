package com.codeup.springblog.models;

import javax.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int(11) unsigned")
	private long id;

	@Column(columnDefinition = "tinyint(3) unsigned NOT NULL")
	private int age;

	@Column(columnDefinition = "varchar(200) NOT NULL")
	private String name;

	@Column(columnDefinition = "char(2) DEFAULT 'XX'")
	private String resideState;
}
