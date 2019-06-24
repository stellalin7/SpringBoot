package com.techtalentsouth.TechTalentBlog.BlogPost;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;





public class BlogPostControllerTest {
	
	
	@Mock
	BlogPostRepository blogPostRepository;
	
	
	BlogPost blogPost;
	
	
	BlogPostController blogPostController;
	
	@Mock
	Model model;
	
    @Before
    public void setUp() throws Exception {
    	MockitoAnnotations.initMocks(this);
      blogPostController = new BlogPostController();
      blogPost = new BlogPost("testTitle","testAuthor","testBlog");
      blogPostRepository.save(blogPost);
    }

	@Test
	public void testIndex() throws Exception {
		

        String view = blogPostController.index(blogPost, model);
        
        assertEquals("blogpost/index", view);

	        verify(blogPostRepository, times(1)).findAll();
	        
	        Set modelAttribute = (Set) ((ModelMap) model).get("posts");
	        
	        assertEquals(modelAttribute.size(), 1);

		        

	}

	@Test
	public void testDeletePostWithId() {
		fail("Not yet implemented");
	}

	@Test
	public void testNewBlog() {
		fail("Not yet implemented");
	}

	@Test
	public void testEditBlog() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testEdit() {
		fail("Not yet implemented");
	}

	@Test
	public void testViewBlog() {
		fail("Not yet implemented");
	}

}
