package com.techtalentsouth.TechTalentBlog.BlogPost;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BlogPostController {
	
	@Autowired
	private BlogPostRepository blogPostRepository;
	
	
	@GetMapping("/")
	//@GetMapping(value="/")
	public String index(BlogPost blogPost, Model model) {
		
		model.addAttribute("posts", blogPostRepository.findAll());
		return "blogpost/index";
	}
	
	@DeleteMapping("/blog_posts/{id}")
    //@RequestMapping(value = "/blog_posts/{id}", method = RequestMethod.DELETE)
    public String deletePostWithId(@PathVariable Long id, BlogPost blogPost, Model model) {


        blogPostRepository.deleteById(id);
        model.addAttribute("posts", blogPostRepository.findAll());
        return "blogpost/index";

    }
	
	@GetMapping("/blog_posts/new")
	//@GetMapping(value = "/blog_posts/new")
    public String newBlog (BlogPost blogPost) {
        return "blogpost/new";	
    }
	
	@GetMapping("/blog_posts/{id}")
    public String editBlog (@PathVariable Long id, Model model) {
		model.addAttribute("blogPost", blogPostRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id: "+id)));
        return "blogpost/edit";	
    }
	
	
	@PostMapping("/blog_posts/new")
	//@PostMapping(value = "/blog_posts/new")
	public String create(BlogPost blogPost, Model model) {
		blogPostRepository.save(blogPost);
		//posts.add(blogPost);
		model.addAttribute("id", blogPost.getID());
		model.addAttribute("title", blogPost.getTitle());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("blogEntry", blogPost.getBlogEntry());
		return "blogpost/result";
	}
	
	@PutMapping("/blog_posts/{id}")
	//@RequestMapping(value = "/blog_posts/{id}", method = RequestMethod.PUT)
	public String edit(@PathVariable Long id,BlogPost blogPost, Model model) {
		BlogPost oldBlogPost =  blogPostRepository.findById(id).orElse(null);
		oldBlogPost.setTitle(blogPost.getTitle());
		oldBlogPost.setAuthor(blogPost.getAuthor());
		oldBlogPost.setBlogEntry(blogPost.getBlogEntry());
		blogPostRepository.save(oldBlogPost);
		model.addAttribute("blogPost", blogPostRepository.findById(oldBlogPost.getID()).orElseThrow(()->new IllegalArgumentException("Invalid id: "+id)));
		return "blogpost/result";
	}
	
	@GetMapping("/blog_posts/view/{id}")
    public String viewBlog (@PathVariable Long id, Model model) {
		model.addAttribute("blogPost", blogPostRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id: "+id)));
		return "blogpost/result";	
    }
	

    
    
	

}
