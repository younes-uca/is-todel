package ma.sir.is.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.is.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "declaration_tva")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="declaration_tva_seq",sequenceName="declaration_tva_seq",allocationSize=1, initialValue = 1)
public class DeclarationTvaHistory extends HistBusinessObject  {


    public DeclarationTvaHistory() {
    super();
    }

    public DeclarationTvaHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="declaration_tva_seq")
    public Long getId() {
    return id;
    }
}

