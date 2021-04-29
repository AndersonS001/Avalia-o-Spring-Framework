package br.com.fiap.avaliacaospring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.avaliacaospring.model.CompraModel;
import br.com.fiap.avaliacaospring.service.CompraService;

@RestController
@RequestMapping("/compras")
public class ComprasController {

    private final CompraService cService;

    public ComprasController(CompraService cService) {
        this.cService = cService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void compraAluno(@RequestBody CompraModel compra) {
        cService.compraAluno(compra);
    }

    @GetMapping
    public List<CompraModel> extrato(@RequestParam long ra) {
        return cService.extrato(ra);
    }

}
