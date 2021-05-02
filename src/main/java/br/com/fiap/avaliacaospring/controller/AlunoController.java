package br.com.fiap.avaliacaospring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.avaliacaospring.model.AlunoModel;
import br.com.fiap.avaliacaospring.service.AlunoService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/alunos")
@Api(value = "Aluno Controller")
public class AlunoController {

    private final AlunoService aService;

    public AlunoController(AlunoService aService) {
        this.aService = aService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    @Operation(summary = "Cadastra um aluno")
    public void cadastraAluno(@Parameter(description = "Objeto do aluno cadastrado") @RequestBody AlunoModel aluno) {
        aService.cadastraAluno(aluno);
    }

    
    @GetMapping
    @Operation(summary = "Lista todos os alunos")
    public List<AlunoModel> getAlunos() {
        return aService.getAlunos();
    }

    @DeleteMapping
    @Operation(summary = "Deleta todos os alunos")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlunos(){
        aService.deleteAlunos();
    }

}
