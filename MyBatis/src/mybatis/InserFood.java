package mybatis;

import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import dao.FoodDao;
import dto.Food;

public class InserFood {
	public static void main(String[] args) {
		
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		FoodDao dao = sqlSession.getMapper(FoodDao.class);
		Scanner sc = new Scanner(System.in);
		Food insert = new Food();
		
		System.out.print("음식 번호 입력 : ");
		insert.setF_no(sc.nextInt());
//		sc.skip("/r/n");
		System.out.print("음식 이름 입력 : ");
		insert.setF_name(sc.next());
//		sc.skip("/r/n");
		System.out.print("음식 가격 입력 :");
		insert.setF_price(sc.nextInt());
		
		dao.insertFood(insert);
		
		Food res = dao.selectByFNo(insert.getF_no());
		
		if(res==null) {
			sqlSession.rollback();
		}else{
			sqlSession.commit();
		}
	}
}
