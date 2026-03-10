package rafaelandrade.libraryapi.mappers;

import org.mapstruct.Mapper;
import rafaelandrade.libraryapi.dto.EditoraDto;
import rafaelandrade.libraryapi.model.Editora;

@Mapper(componentModel = "spring", uses = AutorMapper.class)
public interface EditoraMapper {

    Editora toEntity(EditoraDto dto);

    EditoraDto toDto(Editora editora);
}
