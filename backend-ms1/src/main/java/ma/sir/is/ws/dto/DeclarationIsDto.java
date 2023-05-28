package  ma.sir.is.ws.dto;

import ma.sir.is.zynerator.audit.Log;
import ma.sir.is.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeclarationIsDto  extends AuditBaseDto {

    private String dateDeclaration ;
    private Integer trimistre  = 0 ;
    private Integer annee  = 0 ;
    private BigDecimal totalCharge  ;
    private BigDecimal totalProduit  ;
    private BigDecimal resultatAvantImpot  ;
    private BigDecimal montantImpot  ;
    private BigDecimal resultatApresImpot  ;

    private SocieteDto societe ;
    private TauxIsDto tauxIs ;

    private List<FactureChargeDto> factureCharges ;
    private List<FactureProduitDto> factureProduit ;


    public DeclarationIsDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDateDeclaration(){
        return this.dateDeclaration;
    }
    public void setDateDeclaration(String dateDeclaration){
        this.dateDeclaration = dateDeclaration;
    }

    @Log
    public Integer getTrimistre(){
        return this.trimistre;
    }
    public void setTrimistre(Integer trimistre){
        this.trimistre = trimistre;
    }

    @Log
    public Integer getAnnee(){
        return this.annee;
    }
    public void setAnnee(Integer annee){
        this.annee = annee;
    }

    @Log
    public BigDecimal getTotalCharge(){
        return this.totalCharge;
    }
    public void setTotalCharge(BigDecimal totalCharge){
        this.totalCharge = totalCharge;
    }

    @Log
    public BigDecimal getTotalProduit(){
        return this.totalProduit;
    }
    public void setTotalProduit(BigDecimal totalProduit){
        this.totalProduit = totalProduit;
    }

    @Log
    public BigDecimal getResultatAvantImpot(){
        return this.resultatAvantImpot;
    }
    public void setResultatAvantImpot(BigDecimal resultatAvantImpot){
        this.resultatAvantImpot = resultatAvantImpot;
    }

    @Log
    public BigDecimal getMontantImpot(){
        return this.montantImpot;
    }
    public void setMontantImpot(BigDecimal montantImpot){
        this.montantImpot = montantImpot;
    }

    @Log
    public BigDecimal getResultatApresImpot(){
        return this.resultatApresImpot;
    }
    public void setResultatApresImpot(BigDecimal resultatApresImpot){
        this.resultatApresImpot = resultatApresImpot;
    }


    public SocieteDto getSociete(){
        return this.societe;
    }

    public void setSociete(SocieteDto societe){
        this.societe = societe;
    }
    public TauxIsDto getTauxIs(){
        return this.tauxIs;
    }

    public void setTauxIs(TauxIsDto tauxIs){
        this.tauxIs = tauxIs;
    }



    public List<FactureChargeDto> getFactureCharges(){
        return this.factureCharges;
    }

    public void setFactureCharges(List<FactureChargeDto> factureCharges){
        this.factureCharges = factureCharges;
    }
    public List<FactureProduitDto> getFactureProduit(){
        return this.factureProduit;
    }

    public void setFactureProduit(List<FactureProduitDto> factureProduit){
        this.factureProduit = factureProduit;
    }

}
