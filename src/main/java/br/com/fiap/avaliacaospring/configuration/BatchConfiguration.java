package br.com.fiap.avaliacaospring.configuration;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.data.builder.RepositoryItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import br.com.fiap.avaliacaospring.domain.ClientePotencialDomain;
import br.com.fiap.avaliacaospring.model.AlunoModel;
import br.com.fiap.avaliacaospring.repository.ClientePotencialRepository;
import lombok.AllArgsConstructor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class BatchConfiguration {

    public final JobBuilderFactory jobBuilderFactory;
    public final StepBuilderFactory stepBuilderFactory;
    private final ClientePotencialRepository repository;

    @Bean
    public FlatFileItemReader<AlunoModel> reader() {
        return new FlatFileItemReaderBuilder<AlunoModel>().name("alunoItemReader")
                .resource(new ClassPathResource("potenciasclients.txt")).delimited()
                .names(new String[] { "nome", "ra" }).fieldSetMapper(new BeanWrapperFieldSetMapper<AlunoModel>() {
                    {
                        setTargetType(AlunoModel.class);
                    }
                }).build();
    }

    @Bean
    public AlunoItemProcessor processor() {
        return new AlunoItemProcessor();
    }

    @Bean
    public RepositoryItemWriter<ClientePotencialDomain> writer() {

        return new RepositoryItemWriterBuilder<ClientePotencialDomain>().repository(this.repository).methodName("save")
                .build();
    }

    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob").incrementer(new RunIdIncrementer()).listener(listener).flow(step1)
                .end().build();
    }

    @Bean
    public Step step1(RepositoryItemWriter<ClientePotencialDomain> writer) {
        return stepBuilderFactory.get("step1").<AlunoModel, ClientePotencialDomain>chunk(10).reader(reader())
                .processor(processor()).writer(writer).build();
    }

}
