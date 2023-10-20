package ma.zy.stocky.zynerator.service;

import ma.zy.stocky.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.zy.stocky.zynerator.criteria.BaseCriteria;
import ma.zy.stocky.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, CRITERIA extends BaseCriteria, REPO extends AbstractRepository<T, Long>> extends AbstractServiceImpl<T, CRITERIA, REPO> {

    public AbstractReferentielServiceImpl(REPO dao) {
        super(dao);
    }

}
