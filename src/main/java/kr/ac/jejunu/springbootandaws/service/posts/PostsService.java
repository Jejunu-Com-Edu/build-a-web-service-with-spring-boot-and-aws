package kr.ac.jejunu.springbootandaws.service.posts;

import kr.ac.jejunu.springbootandaws.domain.posts.PostsRepository;
import kr.ac.jejunu.springbootandaws.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
