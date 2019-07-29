package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.NewsVO;

@Repository
public class NewsMyBatisDAO {
	@Autowired
	SqlSession session=null;
	
	public List<NewsVO> listAll(){
		List<NewsVO> list = null;
		String statement = "resource.NewsMapper.selectAllNews";
		list = session.selectList(statement);
		return list;
	}
	public NewsVO listOne(int id) {
		NewsVO vo = null;
		String statement = "resource.NewsMapper.selectOneNews";
		vo = session.selectOne(statement, id);
		return vo;
	}
	public List<NewsVO> listWriter(String writer){
		List<NewsVO> list = null;
		String statement = "resource.NewsMapper.selectListWriter";
		list = session.selectList(statement, writer);
		return list;
	}
	public List<NewsVO> search(String key, String searchType){
		List<NewsVO> list = null;
		String statement = null;
		if(searchType.equals("title")) {
			statement = "resource.NewsMapper.searchTitleNews";
		}else if(searchType.equals("writer")) {
			statement = "resource.NewsMapper.searchWriterNews";
		}
		list = session.selectList(statement, key);
		return list;
	}
	
	public boolean insert(NewsVO vo) {
		boolean result=true;
		String statement = "resource.NewsMapper.insertNews";
		if(session.insert(statement, vo) != 1)
			result = false;
		return result;
}
	public boolean update(NewsVO vo) {
		boolean result=true;
		String statement = "resource.NewsMapper.updateNews";
		if(session.insert(statement, vo) != 1)
			result = false;
		return result;
	}
	public boolean delete(int id) {
		boolean result=true;
		String statement = "resource.NewsMapper.deleteNews";
		if(session.insert(statement, id) != 1)
			result = false;
		return result;
	}
}