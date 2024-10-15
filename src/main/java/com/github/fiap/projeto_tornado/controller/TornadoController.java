package com.github.fiap.projeto_tornado.controller;

import com.github.fiap.projeto_tornado.Security.UserSecurity;
import com.github.fiap.projeto_tornado.dto.simple_dto.TornadoCadastroDTO;
import com.github.fiap.projeto_tornado.dto.simple_dto.TornadoExibicaoDTO;
import com.github.fiap.projeto_tornado.model.Tornado;
import com.github.fiap.projeto_tornado.service.TornadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("tornado")
@Tag(name = "tornado", description = "Aplicação para cadastro de tornados!")
@SecurityRequirement(name = UserSecurity.SECUTIRY)
public class TornadoController {

    @Autowired
    private TornadoService tornadoService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar tornado", description = "Função cadastra tornado")
    @ApiResponse(responseCode = "201", description = "Cadastro efetivado!")
    @ApiResponse(responseCode = "400", description = "Não foi possível cadastrar o usuário")
    @ApiResponse(responseCode = "500", description = "Erro de conexão com o servidor")
    public TornadoExibicaoDTO cadastrar (@RequestBody @Valid TornadoCadastroDTO tornadoCadastroDTO){
        return tornadoService.cadastrar(tornadoCadastroDTO);
    }

    @PutMapping("/atualizar")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Atualiza tornado", description = "função atualiza tornado")
    @ApiResponse(responseCode = "201", description = "Atualização efetivada!")
    @ApiResponse(responseCode = "400", description = "Não foi possível atualizar o tornado")
    @ApiResponse(responseCode = "500", description = "Erro de conexão com o servidor")
    public TornadoExibicaoDTO atualizar(@RequestBody Tornado tornado){
        return tornadoService.atualizar(tornado);
    }

    @GetMapping("/listarTodos")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar tornados", description = "Função lista todos os tornados cadastrados!")
    @ApiResponse(responseCode = "201", description = "Listados com sucesso!")
    @ApiResponse(responseCode = "400", description = "Não existe tornados registrados!")
    @ApiResponse(responseCode = "500", description = "Erro de conexão com o servidor")
    public Page<TornadoExibicaoDTO> listarTodos (Pageable pageable){return tornadoService.listarTodos(pageable);}

    @DeleteMapping("excluir/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Exclui tornado", description = "Função exclui tornado!")
    @ApiResponse(responseCode = "201", description = "Tornado excluido!")
    @ApiResponse(responseCode = "400", description = "Tornado não existe!")
    @ApiResponse(responseCode = "500", description = "Erro de conexão com o servidor")
    public void exluir(@PathVariable  Long id){
        tornadoService.excluir(id);
    }

    @GetMapping( value = "/buscarPorNome", params = "nome")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Buscar tornado", description = "Função retorna um tornado específico!")
    @ApiResponse(responseCode = "201", description = "Tornado encontrado!")
    @ApiResponse(responseCode = "400", description = "Tornado não existe")
    @ApiResponse(responseCode = "500", description = "Erro de conexão com o servidor")
    public TornadoExibicaoDTO buscarPorNome (@RequestParam String nome){
        return tornadoService.buscarNome(nome);
    }

    @GetMapping(value = "/buscarEntreData", params = {"dataInicial", "dataFinal"})
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Filto de Eventos por data", description = "Função filta evento por data")
    @ApiResponse(responseCode = "201", description = "Filtro aplicado com sucesso!")
    @ApiResponse(responseCode = "400", description = "Não foram encontrados dados do filtro!")
    @ApiResponse(responseCode = "500", description = "Erro de conexão com o servidor")
    public List<TornadoExibicaoDTO> buscarEntreData(@RequestParam LocalDate dataInicial, @RequestParam LocalDate dataFinal){
        return tornadoService.buscarEntreData(dataInicial, dataFinal);
    }

}
