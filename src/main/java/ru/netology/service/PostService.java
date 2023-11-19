package ru.netology.service;

import org.springframework.stereotype.Service;
import ru.netology.Dto.PostDto;
import ru.netology.exception.NotFoundException;
import ru.netology.mapping.PostDtoMapper;
import ru.netology.model.Post;
import ru.netology.repository.PostRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService{
  private final PostRepository repository;

  public PostService(PostRepository repository) {
    this.repository = repository;
  }

  public List<PostDto> all() {
    List<Post> postList = repository.all();
    return postList.stream()
            .map(PostDtoMapper::dtoPost)
            .collect(Collectors.toList());

  }

  public Post getById(long id) {
    return repository.getById(id).orElseThrow(NotFoundException::new);
  }

  public Optional<Post> save(Post post) {
    return repository.save(post);
  }

  public void removeById(long id) {
    repository.removeById(id);
  }


}

