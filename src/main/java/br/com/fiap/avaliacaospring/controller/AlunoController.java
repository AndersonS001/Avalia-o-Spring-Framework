package br.com.fiap.avaliacaospring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.avaliacaospring.model.AlunoModel;
import br.com.fiap.avaliacaospring.service.AlunoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
    @ApiOperation(value = "Cadastra um aluno")
    public void cadastraAluno(@RequestBody AlunoModel aluno) {
        aService.cadastraAluno(aluno);
    }

}
