package controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.EmpDao;
import dto.Emp;
import mybatis.MyBatisConnectionFactory;

public class EmpEx {
	public static void main(String[] args) {
		SqlSession sqlSession = MyBatisConnectionFactory.getSqlSessionFactory().openSession();
		
		EmpDao dao = sqlSession.getMapper(EmpDao.class);
		Emp emp = new Emp();
		
		emp.setEmp_id("115");
		
		Emp res = dao.selectByEmpId(emp);
		
		System.out.println(res.getFirst_name());
		
		List<Emp> list = dao.selectAll();
		
		for(Emp e : list) {
			System.out.println(e.getFirst_name()+", "+e.getJob_id());
		}
		
		Emp insert = new Emp();
		
		insert.setComm("1");
		insert.setDept_id("60");
		insert.setEmail("email@zzz.com");
		insert.setEmp_id("207");
		insert.setFirst_name("Raylia");
		insert.setLast_name("walker");
		insert.setHire_date("18/04/17");
		insert.setJob_id("IT_PROG");
		insert.setManager_id("103");
		insert.setP_no("4568");
		insert.setSalary(2800);
		
		dao.insertEmp(insert);
		
		if(dao.selectByEmpId(insert) != null){
			System.out.println("입력 완료");
		}else {
			System.out.println("입력 실패");
		}
		dao.deleteByEmpId(insert);
		if(dao.selectByEmpId(insert) != null){
			System.out.println("삭제 실패");
		}else {
			System.out.println("삭제 완료");
		}
		
		sqlSession.commit();
		
	}
}
