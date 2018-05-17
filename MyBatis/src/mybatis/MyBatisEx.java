package mybatis;

import org.apache.ibatis.session.SqlSession;

import dao.FoodDao;
import dto.Food;

public class MyBatisEx {
	public static void main(String[] args) {
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
//		DeptDao deptDao = sqlSession.getMapper(DeptDao.class);
		FoodDao foodDao = sqlSession.getMapper(FoodDao.class);
//		Dept dept = deptDao.selectByDeptNo(deptNo);
//		List list = deptDao.selectAll();
//		System.out.println(list);
		
		Food food = foodDao.selectByFNo(333);
		
		System.out.println(food.getF_name());
	}
}
