package ma.sir.is.service.impl.admin;

import ma.sir.is.bean.core.OperationComptable;
import ma.sir.is.bean.history.OperationComptableHistory;
import ma.sir.is.dao.criteria.core.OperationComptableCriteria;
import ma.sir.is.dao.criteria.history.OperationComptableHistoryCriteria;
import ma.sir.is.dao.facade.core.OperationComptableDao;
import ma.sir.is.dao.facade.history.OperationComptableHistoryDao;
import ma.sir.is.dao.specification.core.OperationComptableSpecification;
import ma.sir.is.service.facade.admin.OperationComptableAdminService;
import ma.sir.is.zynerator.service.AbstractServiceImpl;
import ma.sir.is.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.is.zynerator.util.VelocityPdf;
import ma.sir.is.ws.dto.OperationComptableDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.is.service.facade.admin.CompteComptableAdminService ;
import ma.sir.is.service.facade.admin.SocieteAdminService ;


import java.util.List;
@Service
public class OperationComptableAdminServiceImpl extends AbstractServiceImpl<OperationComptable,OperationComptableHistory, OperationComptableCriteria, OperationComptableHistoryCriteria, OperationComptableDao,
OperationComptableHistoryDao> implements OperationComptableAdminService {
    public static final String TEMPLATE = "template/operationComptable.vm";
    public static final String FILE_NAME = "operationComptable.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(OperationComptableDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<OperationComptable> findBySocieteId(Long id){
        return dao.findBySocieteId(id);
    }
    public int deleteBySocieteId(Long id){
        return dao.deleteBySocieteId(id);
    }
    public List<OperationComptable> findByCompteComptableId(Long id){
        return dao.findByCompteComptableId(id);
    }
    public int deleteByCompteComptableId(Long id){
        return dao.deleteByCompteComptableId(id);
    }



    public void configure() {
        super.configure(OperationComptable.class,OperationComptableHistory.class, OperationComptableHistoryCriteria.class, OperationComptableSpecification.class);
    }

    @Autowired
    private CompteComptableAdminService compteComptableService ;
    @Autowired
    private SocieteAdminService societeService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public OperationComptableAdminServiceImpl(OperationComptableDao dao, OperationComptableHistoryDao historyDao) {
        super(dao, historyDao);
    }

}