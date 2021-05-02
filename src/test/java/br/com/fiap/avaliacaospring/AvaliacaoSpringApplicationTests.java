package br.com.fiap.avaliacaospring;

import br.com.fiap.avaliacaospring.controller.AlunoController;
import br.com.fiap.avaliacaospring.controller.ComprasController;
import br.com.fiap.avaliacaospring.controller.PotenciaisClientesController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;




@SpringBootTest
class AvaliacaoSpringApplicationTests {

	@Autowired
	private AlunoController alunoController;

	@Test
	void contextLoadsAluno() throws Exception {
		assertThat(alunoController).isNotNull();
	}

	@Autowired
	private ComprasController comprasController;

	@Test
	void contextLoadsCompras() throws Exception {
		assertThat(comprasController).isNotNull();
	}

	@Autowired
	private PotenciaisClientesController potenciaisClientesController;

	@Test
	void contextLoadsPotenciaisClientes() throws Exception {
		assertThat(potenciaisClientesController).isNotNull();
	}


}

