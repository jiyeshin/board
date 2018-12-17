package com.eansoft.board.service.mapper;

import java.util.List;
import java.util.Map;

import com.eansoft.board.service.BoardVO;

public interface BoardMapper {
	 // 게시물 리스트 조회
    public List<BoardVO> selectBoardList(Map map) throws Exception;
    
   //전체 리스트 개수
    public int selectBoardListCnt(BoardVO boardVO) throws Exception;
    
    // 게시물 등록
    public void insertBoard(BoardVO boardVO) throws Exception;
    
    // 게시물 수정
    public void updateBoard(BoardVO boardVO) throws Exception;
    
    // 게시물 삭제
    public void deleteBoard(BoardVO boardVO) throws Exception;
 
    // 게시물 조회
    public BoardVO selectBoardByCode(BoardVO boardVO) throws Exception;
    
    // 조회수 증가 
    public void updateReadcnt(BoardVO boardVO) throws Exception;
    
    //답글 groupOrd 증가
    public void updateGroupOrd(BoardVO boardVO) throws Exception;
    
    // 답글 등록
    public void insertReply(BoardVO boardVO) throws Exception;
    

}
