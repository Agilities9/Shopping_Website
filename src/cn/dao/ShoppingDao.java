package cn.dao;
import java.util.List;

import cn.bean.Shopping;
public interface ShoppingDao {
public List<Shopping> getOrderShopping(int userId);
public void delOrderShopping(int userId);

}
