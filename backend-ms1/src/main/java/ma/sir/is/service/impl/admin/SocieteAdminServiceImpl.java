package ma.sir.is.service.impl.admin;

import ma.sir.is.bean.core.Societe;
import ma.sir.is.bean.history.SocieteHistory;
import ma.sir.is.dao.criteria.core.SocieteCriteria;
import ma.sir.is.dao.criteria.history.SocieteHistoryCriteria;
import ma.sir.is.dao.facade.core.SocieteDao;
import ma.sir.is.dao.facade.history.SocieteHistoryDao;
import ma.sir.is.dao.specification.core.SocieteSpecification;
import ma.sir.is.service.facade.admin.SocieteAdminService;
import ma.sir.is.zynerator.service.AbstractServiceImpl;
import ma.sir.is.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.is.zynerator.util.VelocityPdf;
import ma.sir.is.ws.dto.SocieteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class SocieteAdminServiceImpl extends AbstractServiceImpl<Societe,SocieteHistory, SocieteCriteria, SocieteHistoryCriteria, SocieteDao,
SocieteHistoryDao> implements SocieteAdminService {
    public static final String TEMPLATE = "template/societe.vm";
    public static final String FILE_NAME = "societe.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(SocieteDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Societe findByReferenceEntity(Societe t){
        return  dao.findByIce(t.getIce());
    }




    public void configure() {
        super.configure(Societe.class,SocieteHistory.class, SocieteHistoryCriteria.class, SocieteSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public SocieteAdminServiceImpl(SocieteDao dao, SocieteHistoryDao historyDao) {
        super(dao, historyDao);
    }

}