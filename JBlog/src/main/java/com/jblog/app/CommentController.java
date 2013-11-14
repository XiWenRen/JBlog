package com.jblog.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jblog.domain.Comment;
import com.jblog.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {

	private static final Logger logger = LoggerFactory
			.getLogger(CommentController.class);

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/aa")
	@ResponseBody
	public List<Comment> getCommentsByArticleId(int articleId) {
		return commentService.getCommentListByArticleId(articleId);
	}
}
