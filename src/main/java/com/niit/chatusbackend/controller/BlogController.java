package com.niit.chatusbackend.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.chatusbackend.dao.BlogDAO;
import com.niit.chatusbackend.model.Blog;

@RestController
public class BlogController {

	@Autowired
	private BlogDAO blogDAO;
	@PostMapping(value="/createblog")
	public ResponseEntity<Blog> addblog(@RequestBody Blog blog,HttpSession session){
		System.out.println("hello");
		String name=blog.getTitle();
		System.out.println(name);
		String uid=(String) session.getAttribute("username");
		blog.setDoc(new Date());
		blog.setUserid(uid);
		blogDAO.saveOrUpdate(blog);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
		
	}
	@GetMapping(value="/blog")
	public ResponseEntity<List<Blog>> listblog(){
		System.out.println("list of blog");
		List<Blog> blog =blogDAO.list();
		return new ResponseEntity<List<Blog>>(blog,HttpStatus.OK);
	}
	@DeleteMapping(value="/deleteblog/{blogid}")
	public ResponseEntity<Blog> deleteblog(Blog blog,@PathVariable("blogid") int blogid){
		Blog blog1=blogDAO.get(blogid);
		blogDAO.delete(blog1);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	/*@DeleteMapping(value="/deleteblog/{blogid}")
	public ResponseEntity<Blog> deleteblog(Blog blog,@PathVariable("blogid") int blogid){
		Blog blog1=blogDAO.get(blogid);
		blogDAO.delete(blog1);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}*/
}
