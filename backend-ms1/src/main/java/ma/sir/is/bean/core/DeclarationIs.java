package ma.sir.is.bean.core;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.is.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "declaration_is")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="declaration_is_seq",sequenceName="declaration_is_seq",allocationSize=1, initialValue = 1)
public class DeclarationIs   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateDeclaration ;
    private Integer trimistre = 0;
    private Integer annee = 0;
    private BigDecimal totalCharge = BigDecimal.ZERO;
    private BigDecimal totalProduit = BigDecimal.ZERO;
    private BigDecimal resultatAvantImpot = BigDecimal.ZERO;
    private BigDecimal montantImpot = BigDecimal.ZERO;
    private BigDecimal resultatApresImpot = BigDecimal.ZERO;

    private Societe societe ;
    
    private TauxIs tauxIs ;
    

    private List<FactureCharge> factureCharges ;
    private List<FactureProduit> factureProduit ;

    public DeclarationIs(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="declaration_is_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDateTime getDateDeclaration(){
        return this.dateDeclaration;
    }
    public void setDateDeclaration(LocalDateTime dateDeclaration){
        this.dateDeclaration = dateDeclaration;
    }
    public Integer getTrimistre(){
        return this.trimistre;
    }
    public void setTrimistre(Integer trimistre){
        this.trimistre = trimistre;
    }
    public Integer getAnnee(){
        return this.annee;
    }
    public void setAnnee(Integer annee){
        this.annee = annee;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Societe getSociete(){
        return this.societe;
    }
    public void setSociete(Societe societe){
        this.societe = societe;
    }
    public BigDecimal getTotalCharge(){
        return this.totalCharge;
    }
    public void setTotalCharge(BigDecimal totalCharge){
        this.totalCharge = totalCharge;
    }
    public BigDecimal getTotalProduit(){
        return this.totalProduit;
    }
    public void setTotalProduit(BigDecimal totalProduit){
        this.totalProduit = totalProduit;
    }
    public BigDecimal getResultatAvantImpot(){
        return this.resultatAvantImpot;
    }
    public void setResultatAvantImpot(BigDecimal resultatAvantImpot){
        this.resultatAvantImpot = resultatAvantImpot;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public TauxIs getTauxIs(){
        return this.tauxIs;
    }
    public void setTauxIs(TauxIs tauxIs){
        this.tauxIs = tauxIs;
    }
    public BigDecimal getMontantImpot(){
        return this.montantImpot;
    }
    public void setMontantImpot(BigDecimal montantImpot){
        this.montantImpot = montantImpot;
    }
    public BigDecimal getResultatApresImpot(){
        return this.resultatApresImpot;
    }
    public void setResultatApresImpot(BigDecimal resultatApresImpot){
        this.resultatApresImpot = resultatApresImpot;
    }
    @OneToMany(mappedBy = "declarationIs")
    public List<FactureCharge> getFactureCharges(){
        return this.factureCharges;
    }
    public void setFactureCharges(List<FactureCharge> factureCharges){
        this.factureCharges = factureCharges;
    }
    @OneToMany
    public List<FactureProduit> getFactureProduit(){
        return this.factureProduit;
    }
    public void setFactureProduit(List<FactureProduit> factureProduit){
        this.factureProduit = factureProduit;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeclarationIs declarationIs = (DeclarationIs) o;
        return id != null && id.equals(declarationIs.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

