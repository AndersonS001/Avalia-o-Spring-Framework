package br.com.fiap.avaliacaospring.configuration;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.batch.core.JobParameter;

public class CustomJobParameter<T extends Serializable> extends JobParameter {
    private T customParam;
    public CustomJobParameter(T customParam){
        super(UUID.randomUUID().toString());//This is to avoid duplicate JobInstance error
        this.customParam = customParam;
    }
    public T getValue(){
        return customParam;
    }
}