package com.eansoft.comment.service;

public class CommentVO {
	
	private int commentcode;			// 댓글 번호 
	private int boardcode;				// 게시글 번호
	private String comments;			// 댓글 내용
	private String commentwriter;		// 댓글 작성자
	private String commentregdate;		// 댓글 작성일자
	public int getCommentcode() {
		return commentcode;
	}
	public void setCommentcode(int commentcode) {
		this.commentcode = commentcode;
	}
	public int getBoardcode() {
		return boardcode;
	}
	public void setBoardcode(int boardcode) {
		this.boardcode = boardcode;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCommentwriter() {
		return commentwriter;
	}
	public void setCommentwriter(String commentwriter) {
		this.commentwriter = commentwriter;
	}
	public String getCommentregdate() {
		return commentregdate;
	}
	public void setCommentregdate(String commentregdate) {
		this.commentregdate = commentregdate;
	}
	@Override
	public String toString() {
		return "CommentVO [commentcode=" + commentcode + ", boardcode=" + boardcode + ", comments=" + comments
				+ ", commentwriter=" + commentwriter + ", commentregdate=" + commentregdate + "]";
	}
	
	
	
}
