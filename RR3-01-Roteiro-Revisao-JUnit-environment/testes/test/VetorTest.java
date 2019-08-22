package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import vetor.Vetor;
import vetor.Aluno;

public class VetorTest {
	
	private Vetor<Aluno> vetor = new Vetor<Aluno>(20);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void inserir() {
		assertTrue(vetor.isVazio());
		vetor.inserir(new Aluno("Joaozinho", 10.0));
		assertFalse(vetor.isVazio());
	}
	
	@Test
	public void remover() {
		vetor.inserir(new Aluno("Joaozinho", 10.0));
		vetor.remover(new Aluno("Joaozinho", 10.0));
		assertTrue(vetor.isVazio());
	}
	
	@Test
	public void procurar() { //buscando pela media
		Aluno aluno = new Aluno("Joaozinho", 2.0);
		vetor.inserir(aluno);
		vetor.inserir(new Aluno("Mariazinha", 6.2));
		vetor.inserir(new Aluno("Joaninha", 5.7));
		
		assertFalse(vetor.isVazio());
		
		Aluno a = vetor.procurar(new Aluno(null, 2.0));
		assertEquals(a, aluno);
	}
	
	@Test
	public void maximo() {
		vetor.inserir(new Aluno("Mariazinha", 6.2));
		vetor.inserir(new Aluno("Joaninha", 5.7));
		vetor.inserir(new Aluno("Joaozinho", 2.0));
		
		assertFalse(vetor.isVazio());
		
		Aluno a = vetor.maximo();
		
		assertEquals(a, new Aluno("Mariazinha", 6.2));
	}
	
	@Test
	public void minimo() {
		vetor.inserir(new Aluno("Mariazinha", 6.2));
		vetor.inserir(new Aluno("Joaninha", 5.7));
		vetor.inserir(new Aluno("Joaozinho", 2.0));
		
		Aluno a = vetor.minimo();
		
		assertEquals(a, new Aluno("Joaozinho", 2.0));
	}
}
