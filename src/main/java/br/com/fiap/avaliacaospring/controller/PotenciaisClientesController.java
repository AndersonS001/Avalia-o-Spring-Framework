package br.com.fiap.avaliacaospring.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PotenciaisClientesController {

    private final JobLauncher jobLauncher;

    private final Job job;

    @GetMapping(value = "/potenciais_clientes")
    @Operation(summary = "Rota para iniciar batch de cadastro de potenciais clientes")
    public void uploadFileHandler() throws JobExecutionAlreadyRunningException, JobRestartException,
            JobInstanceAlreadyCompleteException, JobParametersInvalidException {

        JobParameters paramJobParameters = new JobParametersBuilder()
                .addParameter("time", new JobParameter(System.currentTimeMillis())).toJobParameters();

        jobLauncher.run(job, paramJobParameters);
    }
}
