package com.pafradev.literalura;

import com.pafradev.literalura.main.Main;
import com.pafradev.literalura.repository.AutorRepository;
import com.pafradev.literalura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository repository;

	@Autowired
	private AutorRepository repositoryAutor;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Main principal = new Main(repository, repositoryAutor);
		principal.muestraMenu();

	}
}
