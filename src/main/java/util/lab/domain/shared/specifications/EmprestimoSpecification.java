package util.lab.domain.shared.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.FetchParent;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import util.lab.domain.model.Emprestimo;
import util.lab.domain.model.Livro;
import util.lab.domain.model.Pessoa;

@SuppressWarnings("serial")
public class EmprestimoSpecification  implements Specification<Emprestimo> {

	@Override
	public Predicate toPredicate(Root<Emprestimo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		Predicate p = criteriaBuilder.conjunction();
		
		FetchParent<Emprestimo, Livro> fetch = root.fetch("livro");
		Join<Emprestimo, Livro> join = (Join<Emprestimo, Livro>) fetch;
		
		FetchParent<Emprestimo, Pessoa> fetch2 = root.fetch("pessoa");
		Join<Emprestimo, Pessoa> join2 = (Join<Emprestimo, Pessoa>) fetch2;
		
		p.getExpressions().add(criteriaBuilder.equal(join.get("id"), root.get("livro")));
		p.getExpressions().add(criteriaBuilder.equal(join2.get("id"), root.get("pessoa")));
		
		return p;
	}

}
