package com.github.fiap.projeto_tornado.controller;
import com.github.fiap.projeto_tornado.dto.simple_dto.DanoCadastroDTO;
import com.github.fiap.projeto_tornado.dto.simple_dto.DanoExibicaoDTO;
import com.github.fiap.projeto_tornado.model.Danos;
import com.github.fiap.projeto_tornado.service.DanoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dano")
public class DanoController {

    @Autowired
    private DanoService danoService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public DanoExibicaoDTO cadastrar(@RequestBody @Valid DanoCadastroDTO danoCadastroDTO){
        return danoService.cadastrar(danoCadastroDTO);
    }

    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DanoExibicaoDTO atualizar (@RequestBody Danos danos){
        return danoService.atualizar(danos);
    }

    @DeleteMapping("excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir (@PathVariable Long id){
        danoService.excluir(id);
    }

    @GetMapping("listarTodos")
    @ResponseStatus(HttpStatus.OK)
    public Page<DanoExibicaoDTO> listarTodos (Pageable pageable){
        return danoService.listarTodos(pageable);
    }

}
