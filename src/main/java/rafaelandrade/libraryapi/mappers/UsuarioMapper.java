package rafaelandrade.libraryapi.mappers;

import org.mapstruct.Mapper;
import rafaelandrade.libraryapi.dto.UsuarioDto;
import rafaelandrade.libraryapi.model.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDto dto);
}
