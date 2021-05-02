package br.com.fiap.avaliacaospring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class TesteApiAlunos {


	@Autowired
	public MockMvc mockMvc;

	@Test
	void getAlunosTeste() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.get("/batch"))
				.andExpect(status().isOk());

		mockMvc.perform(
				MockMvcRequestBuilders.get("/potenciais_clientes"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(100)));

	}

}

