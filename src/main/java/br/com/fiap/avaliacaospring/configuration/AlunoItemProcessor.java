package br.com.fiap.avaliacaospring.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import br.com.fiap.avaliacaospring.domain.AlunoDomain;
import br.com.fiap.avaliacaospring.model.AlunoModel;

public class AlunoItemProcessor implements ItemProcessor<AlunoModel, AlunoDomain> {

    private static final Logger log = LoggerFactory.getLogger(AlunoItemProcessor.class);
    private AlunoDomain alunoDomain;

    @Override
    public AlunoDomain process(AlunoModel item) throws Exception {
        String nome = item.getNome().toUpperCase();

        alunoDomain = new AlunoDomain(nome, item.getRa());

        log.info("Converting (" + item + ") into (" + alunoDomain + ")");

        return alunoDomain;
    }
    
}
