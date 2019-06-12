package br.com.geduca.api.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import br.com.geduca.api.model.Estoque;
import br.com.geduca.api.repository.custom.EstoqueRepositoryCustom;

public class EstoqueRepositoryImpl implements EstoqueRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Page<Estoque> listarEstoquePorDespensa(Pageable paginacao) {
		String hql = " select %s from Exame exame %s where exame.situacaoExame = :situacao "
				+ " and exame.procedimento in (select ep.procedimento from EspecialidadeProcedimento ep where ep.especialidade in :especialidades) ";

		String groupBy = " order by exame.prioridade, exame.dataPedido, exame.sla ";

		Query query = entityManager.createQuery(String.format(hql, "(exame)", "", ""));
		Long total = (Long) query.getSingleResult();

		if (total > 0) {
			query = entityManager.createQuery(String.format(hql, "exame", groupBy));

			query.setMaxResults(paginacao.getPageSize() > 0 ? paginacao.getPageSize() : 10);
			query.setFirstResult(paginacao.getPageNumber() * paginacao.getPageSize());
			Page<Estoque> resultado = new PageImpl<Estoque>(query.getResultList(), paginacao, total);
			return resultado;
		}
		return Page.empty(paginacao);
	}

}
