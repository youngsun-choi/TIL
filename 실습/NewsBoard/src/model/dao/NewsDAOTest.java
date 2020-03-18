package model.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import model.vo.NewsVO;

public class NewsDAOTest {

	@Test
	public void test() {
		NewsDAO dao = new NewsDAO();
		
		NewsVO listone = dao.listOne(2);
		dao.update(listone);
		System.out.println(dao.listAll());
	}
}
