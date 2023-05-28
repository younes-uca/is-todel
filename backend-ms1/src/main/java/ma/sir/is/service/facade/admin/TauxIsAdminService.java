package ma.sir.is.service.facade.admin;

import java.util.List;
import ma.sir.is.bean.core.TauxIs;
import ma.sir.is.dao.criteria.core.TauxIsCriteria;
import ma.sir.is.dao.criteria.history.TauxIsHistoryCriteria;
import ma.sir.is.zynerator.service.IService;

import ma.sir.is.ws.dto.TauxIsDto;
import org.springframework.http.HttpEntity;

public interface TauxIsAdminService extends  IService<TauxIs,TauxIsCriteria, TauxIsHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(TauxIsDto dto) throws Exception;


}
