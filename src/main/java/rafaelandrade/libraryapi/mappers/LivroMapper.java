package rafaelandrade.libraryapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import rafaelandrade.libraryapi.dto.CadastroLivroDto;
import rafaelandrade.libraryapi.dto.ResultadoPesquisaLivroDto;
import rafaelandrade.libraryapi.model.Livro;
import rafaelandrade.libraryapi.repository.AutorRepository;
import rafaelandrade.libraryapi.repository.EditoraRepository;

@Mapper(componentModel = "spring", uses = AutorMapper.class)
public abstract class  LivroMapper {

    @Autowired
    AutorRepository autorRepository;
    @Autowired
    EditoraRepository editoraRepository;

    @Mapping(target = "autor", expression = "java( autorRepository.findById(dto.idAutor()).orElse(null) )")
    @Mapping(target = "editora", expression = "java( editoraRepository.findById(dto.idEditora()).orElse(null) )")
    public abstract Livro toEntity(CadastroLivroDto dto);

    public abstract ResultadoPesquisaLivroDto toDto(Livro livro);
}

