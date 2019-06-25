package model.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import model.vo.NewsVO;

public class NewsDAOTest {

	@Test
	public void test() {
		NewsDAO dao = new NewsDAO();
		NewsVO vo = new NewsVO();
		
		NewsVO listone = dao.listOne(1);
		System.out.println(listone.getWriter());
	}
}
