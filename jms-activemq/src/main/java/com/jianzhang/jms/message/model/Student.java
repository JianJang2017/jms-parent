package com.jianzhang.jms.message.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 自定义序列化对象
 * @author Jian Jang
 * @version 1.0 2017年11月12日
 */
public class Student implements Serializable {

	private static final long serialVersionUID = -1049984117760269120L;

	private Integer sno;

	private String name;

	private String email;

	private int age;

	private Date registerTime;

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + ", email=" + email + ", age=" + age
				+ ", registerTime=" + registerTime + "]";
	}

}
