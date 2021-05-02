package br.com.fiap.avaliacaospring.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import br.com.fiap.avaliacaospring.domain.ClientePotencialDomain;
import br.com.fiap.avaliacaospring.model.AlunoModel;

public class AlunoItemProcessor implements ItemProcessor<AlunoModel, ClientePotencialDomain> {

    private static final Logger log = LoggerFactory.getLogger(AlunoItemProcessor.class);
    private ClientePotencialDomain cliente;

    @Override
    public ClientePotencialDomain process(AlunoModel item) throws Exception {
        String nome = item.getNome().toUpperCase();

        cliente = new ClientePotencialDomain(item.getRa(), nome);

        log.info("Converting (" + item + ") into (" + cliente + ")");

        return cliente;
    }
    
}
