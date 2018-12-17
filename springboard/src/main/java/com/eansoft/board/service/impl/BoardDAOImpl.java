package com.eansoft.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eansoft.board.service.BoardVO;
import com.eansoft.board.service.mapper.BoardMapper;

@Service
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<BoardVO> selectBoardList(String searchOption, String keyword) throws Exception {
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("searchOption", searchOption);
        map.put("keyword", keyword);
        
        return mapper.selectBoardList(map);
    }
	
	@Override
	public int selectBoardListCnt(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        return mapper.selectBoardListCnt(boardVO);
	}
 
	@Override
    public void insertBoard(BoardVO boardVO) throws Exception {
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        mapper.insertBoard(boardVO);
    }
 
    @Override
    public void updateBoard(BoardVO boardVO) throws Exception {
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        mapper.updateBoard(boardVO);
    }
 
    @Override
    public void deleteBoard(BoardVO boardVO) throws Exception {
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        mapper.deleteBoard(boardVO);
    }
 
    @Override
    public BoardVO selectBoardByCode(BoardVO boardVO) throws Exception {
        BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
        return mapper.selectBoardByCode(boardVO);
    }

	@Override
	public void updateReadcnt(BoardVO boardVO) throws Exception {
		   BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	       mapper.updateReadcnt(boardVO);
		
	}
	
	@Override
	public void updateGroupOrd(BoardVO boardVO) throws Exception {
		  BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	       mapper.updateGroupOrd(boardVO);	
	}

	@Override
	public void insertReply(BoardVO boardVO) throws Exception {
		 BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	        mapper.insertReply(boardVO);
		
	}

}
