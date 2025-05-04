package br.unipar.programacaoweb.livraria.controller;

import br.unipar.programacaoweb.livraria.dto.AutorComLivrosDTO;
import br.unipar.programacaoweb.livraria.model.Autor;
import br.unipar.programacaoweb.livraria.service.AutorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Autor>> listar() {
        List<Autor> autores = autorService.listaTodos();
        if (autores.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(autores);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Autor> buscarPorId(@PathVariable Long id) {
        Autor autor = autorService.buscarPorId(id);
        if (autor == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(autor);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Autor> salvar(@RequestBody Autor autor) {
        Autor criado = autorService.salvar(autor);
        return ResponseEntity.status(201).body(criado);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Autor> editar(@PathVariable Long id, @RequestBody Autor autor) {
        Autor atualizado = autorService.editar(id, autor);
        if (atualizado == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        boolean removed = autorService.excluir(id);
        if (!removed)
            return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/listar-com-livros")
    public ResponseEntity<List<AutorComLivrosDTO>> listarAutoresComLivros() {
        List<Autor> autores = autorService.listarTodosComLivros();

        List<AutorComLivrosDTO> resposta = autores.stream().map(autor -> {
            AutorComLivrosDTO dto = new AutorComLivrosDTO();
            dto.setId(autor.getId());
            dto.setNome(autor.getNome());
            dto.setNacionalidade(autor.getNacionalidade());
            dto.setEmail(autor.getEmail());
            dto.setDataNascimento(autor.getDataNascimento());
            dto.setLivros(autor.getLivros());
            return dto;
        }).toList();

        return ResponseEntity.ok(resposta);
    }
}