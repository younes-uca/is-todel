package ma.sir.is.service.facade.admin;

import java.util.List;
import ma.sir.is.bean.core.TauxRetardTva;
import ma.sir.is.dao.criteria.core.TauxRetardTvaCriteria;
import ma.sir.is.dao.criteria.history.TauxRetardTvaHistoryCriteria;
import ma.sir.is.zynerator.service.IService;

import ma.sir.is.ws.dto.TauxRetardTvaDto;
import org.springframework.http.HttpEntity;

public interface TauxRetardTvaAdminService extends  IService<TauxRetardTva,TauxRetardTvaCriteria, TauxRetardTvaHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(TauxRetardTvaDto dto) throws Exception;


}
