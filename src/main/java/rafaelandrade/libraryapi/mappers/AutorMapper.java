package rafaelandrade.libraryapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import rafaelandrade.libraryapi.dto.AutorDto;
import rafaelandrade.libraryapi.model.Autor;

@Mapper(componentModel = "spring")
public interface AutorMapper {

    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "dataNascimento", target = "dataNascimento")
    @Mapping(source = "nacionalidade", target = "nacionalidade")
    Autor toEntity(AutorDto dto);

    AutorDto toDto(Autor autor);
}
