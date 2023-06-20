package com.example.demo.model;



import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "contact")
    private String contact;

    @Column(name = "semester")
    private int semester;

    // Constructors, getters, and setters

    public Student() {
    }

    public Student(String name, String contact, int semester) {
        this.name = name;
        this.contact = contact;
        this.semester = semester;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long studentId) {
		this.id = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

}


