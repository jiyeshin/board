package com.eansoft.comment.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.eansoft.comment.service.CommentVO;
import com.eansoft.comment.service.mapper.CommentMapper;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<CommentVO> selectCommentList(int boardcode) throws Exception {
		CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
		
		return mapper.selectCommentList(boardcode);
	}

	@Override
	public void insertComment(CommentVO vo) throws Exception {
		CommentMapper mapper = sqlSession.getMapper(CommentMapper.class);
		mapper.insertComment(vo);
	}

	@Override
	public void updateComment(CommentVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteComment(int commentcode) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
