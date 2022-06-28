package kr.ac.jejunu.springbootandaws.service.posts;

import kr.ac.jejunu.springbootandaws.domain.posts.Posts;
import kr.ac.jejunu.springbootandaws.domain.posts.PostsRepository;
import kr.ac.jejunu.springbootandaws.web.dto.PostsListResponseDto;
import kr.ac.jejunu.springbootandaws.web.dto.PostsResponseDto;
import kr.ac.jejunu.springbootandaws.web.dto.PostsSaveRequestDto;
import kr.ac.jejunu.springbootandaws.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new PostsResponseDto(entity);
    }

    @Transactional
    public Object findAllDesc() {
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(posts);
    }
}