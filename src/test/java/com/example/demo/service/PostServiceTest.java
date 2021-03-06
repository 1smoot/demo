package com.example.demo.service;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.PostsSaveRequestDto;
import com.example.demo.domain.posts.PostsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {
	@Autowired
	private PostsService postsService;
	
	@Autowired
	private PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void Dto데이터가_posts테이블에_저장된다() {
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
				.author("kaypro")
				.content("test")
				.title("title")
				.build();
		
		//when
		postsService.save(dto);
		
		//then
	}
}
