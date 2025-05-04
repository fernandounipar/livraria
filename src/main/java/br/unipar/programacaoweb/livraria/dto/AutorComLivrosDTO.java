package br.unipar.programacaoweb.livraria.dto;

import br.unipar.programacaoweb.livraria.model.Livro;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AutorComLivrosDTO {
    private Long id;
    private String nome;
    private String nacionalidade;
    private Date dataNascimento;
    private String email;
    private List<Livro> livros;
}