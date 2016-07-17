package cn.dao;

import java.util.List;

import cn.bean.GoodsType;


public interface GoodsTypeDao {
	 public void addType(GoodsType goodsType);
	 public List<GoodsType> selAllGoodsType();
}
