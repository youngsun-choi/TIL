package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.vo.NewsVO;
public class NewsDAO {
	public Connection connectDB() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:XE","jdbctest","jdbctest");
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	public void close(Connection conn,Statement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}else if(stmt != null) {
				stmt.close();
			}else if(conn != null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public boolean insert(NewsVO vo) {
		boolean result = true;
		try{
			PreparedStatement pstmt = connectDB().prepareStatement
					("insert into news values(news_seq.nextval,?,?,?,sysdate,?)");
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getCnt());
			pstmt.executeUpdate();
			close(connectDB(), pstmt, null);
		}catch(SQLException e) {
			result=false;
			e.printStackTrace();
		}
	return result;
}
	public boolean update(NewsVO vo) {
		boolean result = true;
		try{
			PreparedStatement pstmt = connectDB().prepareStatement
					("update news set writer=?, title=?, content=?, cnt=? where id=?");
			pstmt.setString(1, vo.getWriter());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getCnt()+1);
			pstmt.setInt(5, vo.getId());
			pstmt.executeUpdate();
			close(connectDB(), pstmt, null);
		}catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	public boolean delete(int id) {
		boolean result = true;
		try{
			PreparedStatement pstmt = connectDB().prepareStatement
					("delete from news where id=?");
			pstmt.setInt(1, id);
			int deleteNum = pstmt.executeUpdate();
			if(deleteNum != 1)
				result = false;
			close(connectDB(), pstmt, null);
		}catch(SQLException e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	public List<NewsVO> listAll(){
		List<NewsVO> list = new ArrayList<>();
		try{
			Statement stmt = connectDB().createStatement(); //여기서 자꾸 오류가...
			ResultSet rs = stmt.executeQuery
					("select id, writer, title, to_char(writedate,'yyyy-mm-dd'), cnt from news order by id asc, writedate asc");
			NewsVO vo;
			while(rs.next()) {
				vo=new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setWritedate(rs.getString(4));
				vo.setCnt(rs.getInt(5));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public NewsVO listOne(int id) {
		NewsVO vo = null;
		try {
			PreparedStatement pstmt = connectDB().prepareStatement
					("select id, writer,title,content,cnt from news where id=?");
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setContent(rs.getString(4));
				vo.setCnt(rs.getInt(5));
			}
			close(connectDB(), pstmt, rs);
		}catch(SQLException e) {
			vo = null;
			e.printStackTrace();
		}
		return vo;
	}
	public List<NewsVO> listWriter(String writer){
		List<NewsVO> list = new ArrayList<>();
		try{
			Statement stmt = connectDB().createStatement(); //여기서 자꾸 오류가...
			ResultSet rs = stmt.executeQuery
					("select id, writer, title, to_char(writedate,'yyyy-mm-dd'), cnt from news order by id asc, writedate asc");
			NewsVO vo;
			while(rs.next()) {
				vo=new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setWritedate(rs.getString(4));
				vo.setCnt(rs.getInt(5));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<NewsVO> search(String key, String searchType){
		List<NewsVO> list = new ArrayList<>();
		try{
			Statement stmt = connectDB().createStatement(); //여기서 자꾸 오류가...
			ResultSet rs = stmt.executeQuery
					("select id, writer, title, to_char(writedate,'yyyy-mm-dd'), cnt from news order by id asc, writedate asc");
			NewsVO vo;
			while(rs.next()) {
				vo=new NewsVO();
				vo.setId(rs.getInt(1));
				vo.setWriter(rs.getString(2));
				vo.setTitle(rs.getString(3));
				vo.setWritedate(rs.getString(4));
				vo.setCnt(rs.getInt(5));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}