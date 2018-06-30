package br.com.fiap.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.fiap.entidades.Nota;

public class NotaHelper {
	private EntityManager em;

	public NotaHelper(EntityManager em) {
		this.em = em;
	}

	public void salvar(Nota nota) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(nota);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
	}

	public List<Nota> listarNota() {
		Query query = em.createQuery("select n from Nota n");
		return query.getResultList();
	}

	public Nota buscarNota(String idNota) {
		Query query = em.createQuery("select n from Nota n where idNota = :idnota");
		query.setParameter("idnota", idNota);
		Nota n = (Nota) query.getSingleResult();
		return n;
	}

	public List<Nota> listarTodos() {
		Query query = em.createNamedQuery("Nota.findAll");
		return query.getResultList();
	}

}
