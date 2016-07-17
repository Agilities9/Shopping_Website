package cn.bean;

public class User {
private int id;
private String name;
private String password;
private String sex;
private String address;
private int roleType;
private String question;
private String answer;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public int getRoleType() {
	return roleType;
}
public void setRoleType(int roleType) {
	this.roleType = roleType;
}
public String getQuestion() {
	return question;
}
public void setQuestion(String question) {
	this.question = question;
}
public String getAnswer() {
	return answer;
}
public void setAnswer(String answer) {
	this.answer = answer;
}
public User(int id, String name, String password, String sex, String address,
		int roleType, String question, String answer) {
	super();
	this.id = id;
	this.name = name;
	this.password = password;
	this.sex = sex;
	this.address = address;
	this.roleType = roleType;
	this.question = question;
	this.answer = answer;
}
public User() {
	super();
}


}
