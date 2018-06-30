package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.entidades.Aluno;

public class AlunosHelper {

	private EntityManager em;

	public AlunosHelper(EntityManager em) {
		this.em = em;
	}

	public void salvar(Aluno aluno) throws Exception {
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

	public List<Aluno> listarAlunos() {
		Query query = em.createQuery("select a from Aluno a");
		return query.getResultList();
	}

	public Aluno buscarAluno(String idAluno) {
		Query query = em.createQuery("select a from Aluno a where	idalunos = :idAluno");
		query.setParameter("idAluno", idAluno);
		Aluno a = (Aluno) query.getSingleResult();
		return a;
	}

	public List<Aluno> listarTodos() {
		Query query = em.createNamedQuery("Aluno.findAll");
		return query.getResultList();
	}
}
