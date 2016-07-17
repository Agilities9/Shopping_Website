package cn.dao;

import java.util.List;

import cn.bean.Goods;



public interface GoodsDao {
	public List<Goods> getGoods();
	public void doGoods(Goods goods);
	public void delGoods(int id);
	public void updateGoods(Goods goods);
}
