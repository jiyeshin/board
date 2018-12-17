package com.eansoft.board.service.impl;

import java.util.List;

import com.eansoft.board.service.BoardVO;

public interface BoardDAO {
	 /**
     * 게시물 리스트 조회
     * @param boardVO
     * @return
     * @throws Exception
     */
    List<BoardVO> selectBoardList(String searchOption, String keyword) throws Exception;
    
  //전체 리스트 개수
    public int selectBoardListCnt(BoardVO boardVO) throws Exception;
 
    /**
     * 게시물 등록
     * @param boardVO
     * @throws Exception
     */
    void insertBoard(BoardVO boardVO) throws Exception;
 
    /**
     * 게시물 수정
     * @param boardVO
     * @throws Exception
     */
    void updateBoard(BoardVO boardVO) throws Exception;
 
    /**
     * 게시물 삭제
     * @param boardVO
     * @throws Exception
     */
    void deleteBoard(BoardVO boardVO) throws Exception;
 
    /**
     * 게시물 조회
     * @param boardVO
     * @return
     * @throws Exception
     */
    BoardVO selectBoardByCode(BoardVO boardVO) throws Exception;
    
    /**
     * 조회수 증가
     * @param boardVO
     * @throws Exception
     */
    void updateReadcnt(BoardVO boardVO) throws Exception;
    
   //답글 groupOrd 증가
    void updateGroupOrd(BoardVO boardVO) throws Exception;
    
    // 답글 등록
    public void insertReply(BoardVO boardVO) throws Exception;
    
 

}
