package ma.sir.is.service.impl.admin;

import ma.sir.is.bean.core.CompteComptable;
import ma.sir.is.bean.history.CompteComptableHistory;
import ma.sir.is.dao.criteria.core.CompteComptableCriteria;
import ma.sir.is.dao.criteria.history.CompteComptableHistoryCriteria;
import ma.sir.is.dao.facade.core.CompteComptableDao;
import ma.sir.is.dao.facade.history.CompteComptableHistoryDao;
import ma.sir.is.dao.specification.core.CompteComptableSpecification;
import ma.sir.is.service.facade.admin.CompteComptableAdminService;
import ma.sir.is.zynerator.service.AbstractServiceImpl;
import ma.sir.is.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.is.zynerator.util.VelocityPdf;
import ma.sir.is.ws.dto.CompteComptableDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.is.service.facade.admin.SousClassComptableAdminService ;


import java.util.List;
@Service
public class CompteComptableAdminServiceImpl extends AbstractServiceImpl<CompteComptable,CompteComptableHistory, CompteComptableCriteria, CompteComptableHistoryCriteria, CompteComptableDao,
CompteComptableHistoryDao> implements CompteComptableAdminService {
    public static final String TEMPLATE = "template/compteComptable.vm";
    public static final String FILE_NAME = "compteComptable.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(CompteComptableDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<CompteComptable> findBySousClassComptableId(Long id){
        return dao.findBySousClassComptableId(id);
    }
    public int deleteBySousClassComptableId(Long id){
        return dao.deleteBySousClassComptableId(id);
    }



    public void configure() {
        super.configure(CompteComptable.class,CompteComptableHistory.class, CompteComptableHistoryCriteria.class, CompteComptableSpecification.class);
    }

    @Autowired
    private SousClassComptableAdminService sousClassComptableService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public CompteComptableAdminServiceImpl(CompteComptableDao dao, CompteComptableHistoryDao historyDao) {
        super(dao, historyDao);
    }

}