package com.eansoft.board.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eansoft.board.Pagination;
import com.eansoft.board.service.BoardVO;
import com.eansoft.board.service.impl.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardServiceImpl;
	
    /**
     * 게시판 조회
     * @param boardVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/boardList.do")
    public String boardList(@ModelAttribute("boardVO") BoardVO boardVO, Model model, 
    		@RequestParam(defaultValue="1") int curPage, 
    		@RequestParam(defaultValue="all") String searchOption, 
    		@RequestParam(defaultValue="") String keyword,
            HttpServletRequest request) throws Exception{  	
        
        // 전체리스트 개수
        int listCnt = boardServiceImpl.selectBoardListCnt(boardVO);
        
        Pagination pagination = new Pagination(listCnt, curPage);
        
        boardVO.setStartIndex(pagination.getStartIndex());
        boardVO.setCntPerPage(pagination.getPageSize());
 
     // 전체리스트 조회
        List<BoardVO> list = boardServiceImpl.selectBoardList(searchOption, keyword);
     //   System.out.println(searchOption + "  " + keyword);
     //   System.out.println(list);        
        
        model.addAttribute("list", list);
        model.addAttribute("listCnt", listCnt);
        model.addAttribute("pagination", pagination);
        
        return "board/boardList";
    }
    
    /**
     * 글쓰기 페이지로 이동
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/writeForm.do")
    public String writeBoardForm() throws Exception{
        
        return "board/writeForm";
    }
    
    /**
     * 게시글 등록
     * @param boardVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/write.do")
    public String write(@ModelAttribute("boardVO") BoardVO boardVO, Model model) throws Exception{
        
        boardServiceImpl.insertBoard(boardVO);
        
        return "redirect:/boardList.do";
    }
    
    /**
     * 게시글 조회
     * @param boardVO
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/viewContent.do")
    public String viewForm(@ModelAttribute("boardVO") BoardVO boardVO, Model model, HttpServletRequest request) throws Exception{
        
        int code = Integer.parseInt(request.getParameter("code"));
        boardVO.setCode(code);
        
        BoardVO resultVO = boardServiceImpl.selectBoardByCode(boardVO);
        
        System.out.println(resultVO);
        
        model.addAttribute("result", resultVO);
        
        
        
        return "board/viewForm";
    }
    
    /**
     * 게시글 수정
     * @param boardVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/updateboard.do")
    public String updateBoard(@ModelAttribute("boardVO") BoardVO boardVO, Model model) throws Exception{
        
        try{
            
            boardServiceImpl.updateBoard(boardVO);
            
        } catch (Exception e){
            e.printStackTrace();
        }        
        
        return "redirect:/boardList.do";       
    }
   
    /**
     * 게시글 수정 페이지로 이동
     * @param boardVO
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/update.do")
    public String updateView(@ModelAttribute("boardVO") BoardVO boardVO, Model model) throws Exception{
            
            model.addAttribute("result", boardServiceImpl.updateView(boardVO));                 
        
        return "board/updateForm";      
    }
    
    /**
     * 게시글 삭제
     * @param boardVO
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/deleteBoard.do")
    public String deleteBoard(@ModelAttribute("boardVO") BoardVO boardVO, Model model, HttpServletRequest request) throws Exception{
        
        int code = Integer.parseInt(request.getParameter("code"));
        boardVO.setCode(code);
        
        boardServiceImpl.deleteBoard(boardVO);
                
        return "redirect:/boardList.do";
    }
    
    
  /*
   
    *//**
     * 답글달기 페이지로 이동
     *//*
    @RequestMapping(value="/replyForm.do")
    public String replyView() throws Exception{
    	  
          return "board/replyForm";      
    }
    
    *//**
     * 답글 내용 insert
     * @param boardVO
     * @param model
     * @return
     * @throws Exception
     *//*
    @RequestMapping(value="/reply.do")
    public String reply(@ModelAttribute("boardVO") BoardVO boardVO, Model model) throws Exception{
    	
    	
    	//int originNo = boardDAOService.updateGroupOrd(boardVO);
    	//boardVO.setGroupOrd(Integer.parseInt(boardDAOService.updateGroupOrd(boardVO)));
        boardServiceImpl.insertReply(boardVO);
              
        
        return "redirect:/boardList.do";
    }
    
    */
    
    /**
     * 댓글 등록(Ajax)
     * @param boardVO
     * @param request
     * @return
     * @throws Exception
     */
  /*  @RequestMapping(value="/board/addComment.do")
    @ResponseBody
    public String ajax_addComment(@ModelAttribute("boardVO") BoardVO boardVO, HttpServletRequest request) throws Exception{
        
      //  HttpSession session = request.getSession();
      //  LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
        
        try{
        
           // boardVO.setWriter(loginVO.getUser_id());        
            boardServiceImpl.addComment(boardVO);
            
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return "success";
    }*/
    
    /**
     * 게시물 댓글 불러오기(Ajax)
     * @param boardVO
     * @param request
     * @return
     * @throws Exception
     */
   /* @RequestMapping(value="/board/commentList.do", produces="application/json; charset=utf8")
    @ResponseBody
    public ResponseEntity ajax_commentList(@ModelAttribute("boardVO") BoardVO boardVO, HttpServletRequest request) throws Exception{
        
        HttpHeaders responseHeaders = new HttpHeaders();
        ArrayList<HashMap> hmlist = new ArrayList<HashMap>();
        
        // 해당 게시물 댓글
        List<BoardVO> commentVO = boardServiceImpl.selectBoardCommentByCode(boardVO);
        
        if(commentVO.size() > 0){
            for(int i=0; i<commentVO.size(); i++){
                HashMap hm = new HashMap();
                hm.put("commentcode", commentVO.get(i).getCommentcode());
                hm.put("comments", commentVO.get(i).getComments());
                hm.put("writer", commentVO.get(i).getWriter());
                
                hmlist.add(hm);
            }
            
        }
        
        JSONArray json = new JSONArray(hmlist);        
        return new ResponseEntity(json.toString(), responseHeaders, HttpStatus.CREATED);
        
    }*/
	
}
