package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.fiap.entidades.Aluno;
import br.com.fiap.entidades.Curso;

public class CursosHelper {

	private EntityManager em;

	public CursosHelper(EntityManager em) {
		this.em = em;
	}

	public void salvar(Curso cursos) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(cursos);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
	}

	public List<Curso> listarCursos(int idEscola) {
		Query query = em.createQuery("select c from Curso c where c.escola.id = :idEscola");
		query.setParameter("idEscola", idEscola);
		return query.getResultList();
	}

	public Curso buscarCurso(String idcurso) {
		Query query = em.createQuery("select c from Curso c where	idcursos = :idcurso");
		query.setParameter("idcursos", idcurso);
		Curso c = (Curso) query.getSingleResult();
		return c;
	}

	public List<Curso> listarTodos() {
		Query query = em.createNamedQuery("Curso.findAll");
		return query.getResultList();
	}

	public List<Aluno> listaAlunos(int idCurso){
		 TypedQuery<Aluno> query = em.createQuery("Select a from Aluno a Where p.curso.idCursos = :idCurso", Aluno.class);
		 query.setParameter("idCurso", idCurso);
		 return query.getResultList();
		 }
}
