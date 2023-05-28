package ma.sir.is.service.impl.admin;

import ma.sir.is.bean.core.SousClassComptable;
import ma.sir.is.bean.history.SousClassComptableHistory;
import ma.sir.is.dao.criteria.core.SousClassComptableCriteria;
import ma.sir.is.dao.criteria.history.SousClassComptableHistoryCriteria;
import ma.sir.is.dao.facade.core.SousClassComptableDao;
import ma.sir.is.dao.facade.history.SousClassComptableHistoryDao;
import ma.sir.is.dao.specification.core.SousClassComptableSpecification;
import ma.sir.is.service.facade.admin.SousClassComptableAdminService;
import ma.sir.is.zynerator.service.AbstractServiceImpl;
import ma.sir.is.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.is.zynerator.util.VelocityPdf;
import ma.sir.is.ws.dto.SousClassComptableDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.is.service.facade.admin.ClassComptableAdminService ;


import java.util.List;
@Service
public class SousClassComptableAdminServiceImpl extends AbstractServiceImpl<SousClassComptable,SousClassComptableHistory, SousClassComptableCriteria, SousClassComptableHistoryCriteria, SousClassComptableDao,
SousClassComptableHistoryDao> implements SousClassComptableAdminService {
    public static final String TEMPLATE = "template/sousClassComptable.vm";
    public static final String FILE_NAME = "sousClassComptable.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(SousClassComptableDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<SousClassComptable> findByClassComptableId(Long id){
        return dao.findByClassComptableId(id);
    }
    public int deleteByClassComptableId(Long id){
        return dao.deleteByClassComptableId(id);
    }



    public void configure() {
        super.configure(SousClassComptable.class,SousClassComptableHistory.class, SousClassComptableHistoryCriteria.class, SousClassComptableSpecification.class);
    }

    @Autowired
    private ClassComptableAdminService classComptableService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public SousClassComptableAdminServiceImpl(SousClassComptableDao dao, SousClassComptableHistoryDao historyDao) {
        super(dao, historyDao);
    }

}