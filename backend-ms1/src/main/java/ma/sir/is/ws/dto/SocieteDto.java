package  ma.sir.is.ws.dto;

import ma.sir.is.zynerator.audit.Log;
import ma.sir.is.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class SocieteDto  extends AuditBaseDto {

    private String ice  ;
    private String siege  ;
    private Integer dernierAnneePayerIs  = 0 ;
    private Integer dernierTrimestrePayerIs  = 0 ;
    private Integer dernierAnneePayerTva  = 0 ;
    private Integer dernierTrimestrePayerTva  = 0 ;
    private Boolean bloqued  ;




    public SocieteDto(){
        super();
    }



    @Log
    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }

    @Log
    public String getSiege(){
        return this.siege;
    }
    public void setSiege(String siege){
        this.siege = siege;
    }

    @Log
    public Integer getDernierAnneePayerIs(){
        return this.dernierAnneePayerIs;
    }
    public void setDernierAnneePayerIs(Integer dernierAnneePayerIs){
        this.dernierAnneePayerIs = dernierAnneePayerIs;
    }

    @Log
    public Integer getDernierTrimestrePayerIs(){
        return this.dernierTrimestrePayerIs;
    }
    public void setDernierTrimestrePayerIs(Integer dernierTrimestrePayerIs){
        this.dernierTrimestrePayerIs = dernierTrimestrePayerIs;
    }

    @Log
    public Integer getDernierAnneePayerTva(){
        return this.dernierAnneePayerTva;
    }
    public void setDernierAnneePayerTva(Integer dernierAnneePayerTva){
        this.dernierAnneePayerTva = dernierAnneePayerTva;
    }

    @Log
    public Integer getDernierTrimestrePayerTva(){
        return this.dernierTrimestrePayerTva;
    }
    public void setDernierTrimestrePayerTva(Integer dernierTrimestrePayerTva){
        this.dernierTrimestrePayerTva = dernierTrimestrePayerTva;
    }

    @Log
    public Boolean getBloqued(){
        return this.bloqued;
    }
    public void setBloqued(Boolean bloqued){
        this.bloqued = bloqued;
    }






}
