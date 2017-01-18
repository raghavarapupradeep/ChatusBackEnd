package com.niit.chatusbackend.dao;

import java.util.List;

import com.niit.chatusbackend.model.Forum;

public interface ForumDAO {
	public boolean saveOrUpdate(Forum forum);
	public boolean delete(Forum forum);
public List<Forum>list();
public Forum getforum(int id);
}