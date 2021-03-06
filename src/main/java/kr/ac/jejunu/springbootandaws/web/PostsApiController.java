package kr.ac.jejunu.springbootandaws.web;

import kr.ac.jejunu.springbootandaws.service.posts.PostsService;
import kr.ac.jejunu.springbootandaws.web.dto.PostsResponseDto;
import kr.ac.jejunu.springbootandaws.web.dto.PostsSaveRequestDto;
import kr.ac.jejunu.springbootandaws.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    public void testMethod() {
        System.out.println("test");
    }
}