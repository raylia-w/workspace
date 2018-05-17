package dao;

import dto.Food;

public interface FoodDao {
	public Food selectByFNo(int fno);
	public void insertFood(Food insertFood);
}
