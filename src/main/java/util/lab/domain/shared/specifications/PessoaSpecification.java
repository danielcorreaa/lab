package util.lab.domain.shared.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import util.lab.configs.exceptions.BusinessException;
import util.lab.domain.model.Pessoa;

public class PessoaSpecification  implements Specification<Pessoa>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String field;
	private String value;	
	
	public PessoaSpecification(String field, String value) {
		super();
		this.field = field;
		this.value = value;		
	}

	@Override
	public Predicate toPredicate(Root<Pessoa> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {
		Predicate p = criteriaBuilder.conjunction();		
		if(value != null && !value.isEmpty()) {	
			try {
				p.getExpressions().add(criteriaBuilder.like(root.get(field), "%" + value +"%" ));
			}catch (IllegalArgumentException e) {
				throw new BusinessException("Informe um field válido para realizar o filtro", e);
			}
		}
		return p;
	}


}
