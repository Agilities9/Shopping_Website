package cn.bean;

public class Money {
private int userId;
private float amount;
public int getUserId() {
	return userId;
}
public void setUserId(int userId) {
	this.userId = userId;
}
public float getAmount() {
	return amount;
}
public void setAmount(float amount) {
	this.amount = amount;
}
public Money(int userId, float amount) {
	super();
	this.userId = userId;
	this.amount = amount;
}
public Money() {
	super();
}

}
