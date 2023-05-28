import {SocieteCriteria} from './SocieteCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class FactureProduitCriteria  extends   BaseCriteria  {

    public id: number;
    public dateFacuture: Date;
    public dateFacutureFrom: Date;
    public dateFacutureTo: Date;
    public ice: string;
    public iceLike: string;
     public montantHt: number;
     public montantHtMin: number;
     public montantHtMax: number;
     public montantTtc: number;
     public montantTtcMin: number;
     public montantTtcMax: number;
     public montantTva: number;
     public montantTvaMin: number;
     public montantTvaMax: number;
  public societe: SocieteCriteria ;
  public societes: Array<SocieteCriteria> ;

}
