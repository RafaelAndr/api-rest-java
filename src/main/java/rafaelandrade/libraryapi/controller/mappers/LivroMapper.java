package rafaelandrade.libraryapi.controller.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import rafaelandrade.libraryapi.controller.dto.CadastroLivroDto;
import rafaelandrade.libraryapi.model.Livro;
import rafaelandrade.libraryapi.repository.AutorRepository;

@Mapper(componentModel = "spring")
public abstract class  LivroMapper {

    @Autowired
    AutorRepository autorRepository;

    @Mapping(target = "autor", expression = "java( autorRepository.findById(dto.idAutor()).orElse(null))")
    public abstract Livro toEntity(CadastroLivroDto dto);
}

