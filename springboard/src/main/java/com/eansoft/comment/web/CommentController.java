package com.eansoft.comment.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eansoft.comment.service.CommentVO;
import com.eansoft.comment.service.impl.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	CommentService commentService;
	
	// 댓글 입력
	@RequestMapping("/comment/insert.do")
	public void insert(@ModelAttribute CommentVO vo, HttpServletRequest request) throws Exception{
		
		String comment = request.getParameter("comment");
		String commentwriter = request.getParameter("commentwriter");
		int boardcode = Integer.parseInt(request.getParameter("boardcode"));
		//System.out.println(comment + "  " + commentwriter + "  " + boardcode);
		
		vo.setComments(comment);
		vo.setBoardcode(boardcode);
		vo.setCommentwriter(commentwriter);
		
		commentService.insertComment(vo);
		
	}
	
	@RequestMapping("/comment/listJson.do")
	public List<CommentVO> listJson(HttpServletRequest request)throws Exception{
		int boardcode = Integer.parseInt(request.getParameter("boardcode"));
		System.out.println(boardcode);
		List<CommentVO> list = commentService.selectCommentList(boardcode);
		System.out.println(list);
		return list;
	}

}
