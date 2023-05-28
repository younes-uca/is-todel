package ma.sir.is.service.impl.admin;

import ma.sir.is.bean.core.TauxRetardTva;
import ma.sir.is.bean.history.TauxRetardTvaHistory;
import ma.sir.is.dao.criteria.core.TauxRetardTvaCriteria;
import ma.sir.is.dao.criteria.history.TauxRetardTvaHistoryCriteria;
import ma.sir.is.dao.facade.core.TauxRetardTvaDao;
import ma.sir.is.dao.facade.history.TauxRetardTvaHistoryDao;
import ma.sir.is.dao.specification.core.TauxRetardTvaSpecification;
import ma.sir.is.service.facade.admin.TauxRetardTvaAdminService;
import ma.sir.is.zynerator.service.AbstractServiceImpl;
import ma.sir.is.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.is.zynerator.util.VelocityPdf;
import ma.sir.is.ws.dto.TauxRetardTvaDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class TauxRetardTvaAdminServiceImpl extends AbstractServiceImpl<TauxRetardTva,TauxRetardTvaHistory, TauxRetardTvaCriteria, TauxRetardTvaHistoryCriteria, TauxRetardTvaDao,
TauxRetardTvaHistoryDao> implements TauxRetardTvaAdminService {
    public static final String TEMPLATE = "template/tauxRetardTva.vm";
    public static final String FILE_NAME = "tauxRetardTva.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(TauxRetardTvaDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }






    public void configure() {
        super.configure(TauxRetardTva.class,TauxRetardTvaHistory.class, TauxRetardTvaHistoryCriteria.class, TauxRetardTvaSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public TauxRetardTvaAdminServiceImpl(TauxRetardTvaDao dao, TauxRetardTvaHistoryDao historyDao) {
        super(dao, historyDao);
    }

}