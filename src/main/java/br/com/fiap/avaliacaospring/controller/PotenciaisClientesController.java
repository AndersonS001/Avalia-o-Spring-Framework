package br.com.fiap.avaliacaospring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.avaliacaospring.model.ClientePotencialModel;
import br.com.fiap.avaliacaospring.repository.ClientePotencialRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PotenciaisClientesController {

    private final JobLauncher jobLauncher;

    private final Job job;

    private final ClientePotencialRepository repository;

    @GetMapping(value = "/batch")
    @Operation(summary = "Rota para iniciar batch de cadastro de potenciais clientes")
    public void uploadFileHandler() throws JobExecutionAlreadyRunningException, JobRestartException,
            JobInstanceAlreadyCompleteException, JobParametersInvalidException {

        JobParameters paramJobParameters = new JobParametersBuilder()
                .addParameter("time", new JobParameter(System.currentTimeMillis())).toJobParameters();

        jobLauncher.run(job, paramJobParameters);
    }

    @GetMapping(value = "/potenciais_clientes")
    @Operation(summary = "Lista todos os clientes em potencial")
    public List<ClientePotencialModel> getClientes() {
        return repository.findAll().stream().map(x -> new ClientePotencialModel(x.getRa(), x.getNome()))
                .collect(Collectors.toList());
    }

    @DeleteMapping(value = "/potenciais_clientes")
    @Operation(summary = "Deleta todos os clientes potenciais")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAlunos(){
        repository.deleteAll();
    }

}
