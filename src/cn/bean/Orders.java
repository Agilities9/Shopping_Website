package cn.bean;

public class Orders {
	private int goodsId;
	private String goodsName;
	private float goodsPrice;
	private int goodsCount;
	private String goodsDe;
	private int goodsType;
	private int userId;
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public float getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public int getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	public String getGoodsDe() {
		return goodsDe;
	}
	public void setGoodsDe(String goodsDe) {
		this.goodsDe = goodsDe;
	}
	public int getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(int goodsType) {
		this.goodsType = goodsType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Orders(int goodsId, String goodsName, float goodsPrice,
			int goodsCount, String goodsDe, int goodsType, int userId) {
		super();
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
		this.goodsCount = goodsCount;
		this.goodsDe = goodsDe;
		this.goodsType = goodsType;
		this.userId = userId;
	}
	public Orders() {
		super();
	}
	
}
