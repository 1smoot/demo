package domain;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.posts.Posts;
import com.example.demo.domain.posts.PostsRepository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
	@Autowired
	PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void postSave_Load() {
		// given
		postsRepository.save(Posts.builder()
				.title("테스트 제목")
				.content("테스트 테스트")
				.author("작자")
				.build());
		
		// when
		List<Posts> postsList = postsRepository.findAll();
		
		// then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("테스트 제목"));
		assertThat(posts.getContent(), is("테스트 테스트"));
	}
}
