package dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlSessionBean;


public class CustomerDao {
	SqlSessionFactory factory = SqlSessionBean.getSessionFactory();
	private static CustomerDao dao = new CustomerDao();
	
	private CustomerDao() {}
	public static CustomerDao getInstance() {
		return dao;
	}
	
	public dto.SessionDto login(Map<String, String> map) {
		dto.SessionDto dto = null;
		SqlSession mapper = factory.openSession();
		dto = mapper.selectOne("loginCheck", map);
		return dto;
	}
}
