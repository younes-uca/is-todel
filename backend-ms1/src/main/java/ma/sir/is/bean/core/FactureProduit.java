package ma.sir.is.bean.core;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.is.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "facture_produit")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="facture_produit_seq",sequenceName="facture_produit_seq",allocationSize=1, initialValue = 1)
public class FactureProduit   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime dateFacuture ;
    @Column(length = 500)
    private String ice;
    private BigDecimal montantHt = BigDecimal.ZERO;
    private BigDecimal montantTtc = BigDecimal.ZERO;
    private BigDecimal montantTva = BigDecimal.ZERO;

    private Societe societe ;
    


    public FactureProduit(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="facture_produit_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDateTime getDateFacuture(){
        return this.dateFacuture;
    }
    public void setDateFacuture(LocalDateTime dateFacuture){
        this.dateFacuture = dateFacuture;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Societe getSociete(){
        return this.societe;
    }
    public void setSociete(Societe societe){
        this.societe = societe;
    }
    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }
    public BigDecimal getMontantHt(){
        return this.montantHt;
    }
    public void setMontantHt(BigDecimal montantHt){
        this.montantHt = montantHt;
    }
    public BigDecimal getMontantTtc(){
        return this.montantTtc;
    }
    public void setMontantTtc(BigDecimal montantTtc){
        this.montantTtc = montantTtc;
    }
    public BigDecimal getMontantTva(){
        return this.montantTva;
    }
    public void setMontantTva(BigDecimal montantTva){
        this.montantTva = montantTva;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactureProduit factureProduit = (FactureProduit) o;
        return id != null && id.equals(factureProduit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

