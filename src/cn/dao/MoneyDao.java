package cn.dao;

import cn.bean.Shopping;

public interface MoneyDao {
public float getAmount(int userId);
public boolean updateAmount(Shopping sh);
}
