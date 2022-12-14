package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudeCargoService;
import br.com.alura.spring.data.service.CrudeUnidadeTrabalhoService;
import br.com.alura.spring.data.service.RelatorioFuncionarioDinamico;
import br.com.alura.spring.data.service.RelatoriosService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudeCargoService cargoService;
	private final CrudFuncionarioService funcionarioService;
	private final CrudeUnidadeTrabalhoService TrabalhoService;
	private final RelatoriosService relatoriosService;
	private final RelatorioFuncionarioDinamico relatorioFuncionarioDinamico;
	private Boolean system = true;

	public SpringDataApplication(CrudeCargoService cargoService, CrudFuncionarioService funcionarioService,
			CrudeUnidadeTrabalhoService trabalhoService, RelatoriosService relatoriosService, RelatorioFuncionarioDinamico relatorioFuncionarioDinamico) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.TrabalhoService = trabalhoService;
		this.relatoriosService = relatoriosService;
		this.relatorioFuncionarioDinamico = relatorioFuncionarioDinamico;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("QUAL ACÃO VOCÊ QUER EXECUTAR?");
			System.out.println("0 - SAIR");
			System.out.println("1 - CARGO");
			System.out.println("2 - FUNCIONARIO");
			System.out.println("3 - UNIDADE DE TRABALHO");
			System.out.println("4 - RELATORIOS");
			System.out.println("5 - RELATORIOS DINAMICOS");

			int action = scanner.nextInt(); // para pegar o valor inteiro no console

			switch (action) {
			case 1:
				cargoService.inicial(scanner);
				break;

			case 2:
				funcionarioService.inicial(scanner);
				break;
				
			case 3:
				TrabalhoService.inicial(scanner);
				break;
				
			case 4:
				relatoriosService.inicial(scanner);
				break;
				
			case 5:
				relatorioFuncionarioDinamico.inicial(scanner);
				break;
				
			default:
				system = false;
				break;
			}
		}
	}
}
