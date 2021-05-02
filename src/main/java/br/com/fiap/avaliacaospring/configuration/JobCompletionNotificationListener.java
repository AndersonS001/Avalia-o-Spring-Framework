package br.com.fiap.avaliacaospring.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

import br.com.fiap.avaliacaospring.repository.AlunoRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final AlunoRepository alunoRepository;

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB ENCERRADO! Verificando resultados");

            alunoRepository.findAll().forEach(aluno -> log.info("Encontrou <" + aluno + "> na base"));
        }
    }
}