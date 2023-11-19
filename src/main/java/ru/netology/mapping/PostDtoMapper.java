package ru.netology.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.netology.Dto.PostDto;
import ru.netology.model.Post;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostDtoMapper {
    //PostDtoMapper INSTANCE = Mappers.getMapper( PostDtoMapper.class );
    @Mapping(target = "removed", defaultValue = "false")
    List<PostDto> dtoPost(List<Post> post);
    Post postDto(PostDto postDto);
}
