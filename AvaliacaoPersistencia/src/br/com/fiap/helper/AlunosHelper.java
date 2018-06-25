package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.entidades.Alunos;

public class AlunosHelper {

	private EntityManager em;

	public AlunosHelper(EntityManager em) {
		this.em = em;
	}

	public void salvar(Alunos aluno) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(aluno);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
	}

	public List<Alunos> listarAlunos() {
		Query query = em.createQuery("select a from Alunos a");
		return query.getResultList();
	}

	public Alunos buscarAluno(String idAluno) {
		Query query = em.createQuery("select a from Alunos a where	idalunos = :idAluno");
		query.setParameter("idAluno", idAluno);
		Alunos a = (Alunos) query.getSingleResult();
		return a;
	}

	public List<Alunos> listarTodos() {
		Query query = em.createNamedQuery("Cursos.findAll");
		return query.getResultList();
	}
}
