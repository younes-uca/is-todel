package ma.sir.is.bean.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.is.zynerator.history.HistBusinessObject;
import javax.persistence.*;


@Entity
@Table(name = "declaration_is")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="declaration_is_seq",sequenceName="declaration_is_seq",allocationSize=1, initialValue = 1)
public class DeclarationIsHistory extends HistBusinessObject  {


    public DeclarationIsHistory() {
    super();
    }

    public DeclarationIsHistory (Long id) {
    super(id);
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="declaration_is_seq")
    public Long getId() {
    return id;
    }
}

