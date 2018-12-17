package com.eansoft.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eansoft.board.service.BoardVO;

@Service("boardServiceImpl")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAOService;

	@Override
	public List<BoardVO> selectBoardList(String searchOption, String keyword) throws Exception {
		List<BoardVO> list = null;
		list = boardDAOService.selectBoardList(searchOption, keyword);
		return list;
	}
	
	@Override
	public int selectBoardListCnt(BoardVO boardVO) throws Exception {
		int totalCnt = boardDAOService.selectBoardListCnt(boardVO);
		return totalCnt;
	}

	@Override
	public void insertBoard(BoardVO boardVO) throws Exception {
		boardDAOService.insertBoard(boardVO);
	}

	@Override
	public void updateBoard(BoardVO boardVO) throws Exception {
		boardDAOService.updateBoard(boardVO);
	}

	@Override
	public BoardVO updateView(BoardVO boardVO) throws Exception {

		return boardDAOService.selectBoardByCode(boardVO);
	}

	@Override
	public void deleteBoard(BoardVO boardVO) throws Exception {
		boardDAOService.deleteBoard(boardVO);
	}

	@Override
	public BoardVO selectBoardByCode(BoardVO boardVO) throws Exception {

		boardDAOService.updateReadcnt(boardVO);

		return boardDAOService.selectBoardByCode(boardVO);
	}

	@Override
	public void insertReply(BoardVO boardVO) throws Exception {
		
		boardDAOService.insertBoard(boardVO);		
	}

	@Override
	public void updateGroupOrd(BoardVO boardVO) throws Exception {
		
		boardDAOService.updateGroupOrd(boardVO);
		
	}

	

}
