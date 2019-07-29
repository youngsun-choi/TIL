package edu.spring.springnews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.NewsMyBatisDAO;
import vo.NewsVO;

@Controller
public class NewsController {
	@Autowired
	NewsMyBatisDAO dao;
	@RequestMapping(value= {"/newsmain","/listOne","/delete","/search","/writer"}, method=RequestMethod.GET)
	protected ModelAndView newsGet(NewsVO vo, String action, String newsid,  String writer, String keyword, String searchType) {
		ModelAndView mav = new ModelAndView();
		if(newsid != null) {
			if(action.equals("read")) { //제목부분 눌렀을 때
				vo = dao.listOne(Integer.parseInt(newsid));
				dao.update(vo);
				mav.addObject("listone", vo);	
			}else if(action.equals("delete")) {
				boolean result = dao.delete(Integer.parseInt(newsid));
				if(result)
					mav.addObject("msg", "뉴스가 성공적으로 삭제되었어요!");
				else 
					mav.addObject("msg", "뉴스 삭제를 실패했어요!");
			}
		}else if(newsid == null && action != null) { //작성자부분 눌렀을 때
			if(action.equals("search")) {
				List<NewsVO> searchList = dao.search(keyword, searchType);
				if(searchList.isEmpty() || keyword.equals("") ) {
					mav.addObject("msg", "찾으시는 내용이 없습니다.");
					mav.addObject("list", dao.listAll());
				}else {
					mav.addObject("list", searchList);
					mav.addObject("homebtn", "homebtn");
					mav.addObject("keyword", keyword);
					mav.addObject("searchType", searchType);
				}
			}else if(action.equals("listwriter")) {
				mav.addObject("list", dao.listWriter(writer));
				mav.addObject("homebtn", "homebtn");
			}
			mav.setViewName("news");
			return mav;
		}
		
		List<NewsVO> list = dao.listAll();
		if(list.size() != 0) 
			mav.addObject("list", list);
		else 
			mav.addObject("msg", "추출된 뉴스 정보가 없습니다.");
		mav.setViewName("news");
		return mav;
	} 
	
	@RequestMapping(value= {"/insert","/update"}, method=RequestMethod.POST)
	protected ModelAndView newsPost(NewsVO vo, String newsid, String action) {
		ModelAndView mav = new ModelAndView();
		vo.setWriter(vo.getWriter());
		vo.setTitle(vo.getTitle());
		vo.setContent(vo.getContent());
		if(action.equals("insert")) { 
			boolean result = dao.insert(vo);
			if(result) 
				mav.addObject("msg", "뉴스가 성공적으로 입력되었어요~!");
			else
				mav.addObject("msg", "뉴스 입력을 실패했어요~!");
		}else if(action.equals("update") && newsid != null){ 
			vo.setId(Integer.parseInt(newsid));
			vo.setCnt(dao.listOne(Integer.parseInt(newsid)).getCnt()-1);
			boolean result = dao.update(vo);
			if(result) 
				mav.addObject("msg", "뉴스가 성공적으로 수정되었어요~!");
			else
				mav.addObject("msg", "뉴스 수정을 실패했어요~!");
		}
		mav.addObject("list", dao.listAll());
		mav.setViewName("news");
		return mav;
	}
}
