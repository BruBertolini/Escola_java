package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.fiap.entidades.Alunos;
import br.com.fiap.entidades.Cursos;

public class CursosHelper {

	private EntityManager em;

	public CursosHelper(EntityManager em) {
		this.em = em;
	}

	public void salvar(Cursos cursos) throws Exception {
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

	public List<Cursos> listarCursos() {
		Query query = em.createQuery("select c from Cursos c");
		return query.getResultList();
	}

	public Cursos buscarCurso(String idcurso) {
		Query query = em.createQuery("select c from Cursos c where	idcursos = :idcurso");
		query.setParameter("idcursos", idcurso);
		Cursos c = (Cursos) query.getSingleResult();
		return c;
	}

	public List<Cursos> listarTodos() {
		Query query = em.createNamedQuery("Cursos.findAll");
		return query.getResultList();
	}

	public List<Alunos> listaAlunos(int idCurso){
		 TypedQuery<Alunos> query = em.createQuery("Select a from Alunos a Where p.curso.idCursos = :idCurso", Alunos.class);
		 query.setParameter("idCurso", idCurso);
		 return query.getResultList();
		 }
}
