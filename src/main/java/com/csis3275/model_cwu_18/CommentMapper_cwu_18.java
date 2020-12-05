package com.csis3275.model_cwu_18;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CommentMapper_cwu_18 implements RowMapper<Comment_cwu_18>{

	public Comment_cwu_18 mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Comment_cwu_18 comment = new Comment_cwu_18();
		comment.setComment_id(rs.getInt("comment_id"));
		comment.setContent(rs.getString("content"));
		comment.setUser_id(rs.getInt("user_id"));
		return comment;
	}

}
