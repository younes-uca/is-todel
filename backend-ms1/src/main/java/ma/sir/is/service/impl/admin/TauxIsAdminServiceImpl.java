package ma.sir.is.service.impl.admin;

import ma.sir.is.bean.core.TauxIs;
import ma.sir.is.bean.history.TauxIsHistory;
import ma.sir.is.dao.criteria.core.TauxIsCriteria;
import ma.sir.is.dao.criteria.history.TauxIsHistoryCriteria;
import ma.sir.is.dao.facade.core.TauxIsDao;
import ma.sir.is.dao.facade.history.TauxIsHistoryDao;
import ma.sir.is.dao.specification.core.TauxIsSpecification;
import ma.sir.is.service.facade.admin.TauxIsAdminService;
import ma.sir.is.zynerator.service.AbstractServiceImpl;
import ma.sir.is.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.is.zynerator.util.VelocityPdf;
import ma.sir.is.ws.dto.TauxIsDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class TauxIsAdminServiceImpl extends AbstractServiceImpl<TauxIs,TauxIsHistory, TauxIsCriteria, TauxIsHistoryCriteria, TauxIsDao,
TauxIsHistoryDao> implements TauxIsAdminService {
    public static final String TEMPLATE = "template/tauxIs.vm";
    public static final String FILE_NAME = "tauxIs.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(TauxIsDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }






    public void configure() {
        super.configure(TauxIs.class,TauxIsHistory.class, TauxIsHistoryCriteria.class, TauxIsSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public TauxIsAdminServiceImpl(TauxIsDao dao, TauxIsHistoryDao historyDao) {
        super(dao, historyDao);
    }

}