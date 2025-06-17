package com.mySpring.myapp.adminPage.board.service;

import com.mySpring.myapp.adminPage.board.vo.ArticleVO;

import java.util.List;
import java.util.Map;

public interface BoardService {
	public List<ArticleVO> listArticles() throws Exception;
	public int addNewArticle(Map articleMap) throws Exception;
	public ArticleVO viewArticle(int articleNO) throws Exception;
	//public Map viewArticle(int articleNO) throws Exception;
	public void modArticle(Map articleMap) throws Exception;
	public void removeArticle(int articleNO) throws Exception;
}
