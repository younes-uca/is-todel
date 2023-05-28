import {Component, OnInit} from '@angular/core';
import {DeclarationIsService} from 'src/app/controller/service/DeclarationIs.service';
import {DeclarationIsDto} from 'src/app/controller/model/DeclarationIs.model';
import {DeclarationIsCriteria} from 'src/app/controller/criteria/DeclarationIsCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { SocieteService } from 'src/app/controller/service/Societe.service';
import { TauxIsService } from 'src/app/controller/service/TauxIs.service';

import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {FactureChargeDto} from 'src/app/controller/model/FactureCharge.model';
import {FactureProduitDto} from 'src/app/controller/model/FactureProduit.model';
import {TauxIsDto} from 'src/app/controller/model/TauxIs.model';


@Component({
  selector: 'app-declaration-is-list-admin',
  templateUrl: './declaration-is-list-admin.component.html'
})
export class DeclarationIsListAdminComponent extends AbstractListController<DeclarationIsDto, DeclarationIsCriteria, DeclarationIsService>  implements OnInit {

    fileName = 'DeclarationIs';

    societes :Array<SocieteDto>;
    tauxIss :Array<TauxIsDto>;
  
    constructor(declarationIsService: DeclarationIsService, private societeService: SocieteService, private tauxIsService: TauxIsService) {
        super(declarationIsService);
        this.pdfName='DeclarationIs.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadSociete();
      this.loadTauxIs();
    }

    public async loadDeclarationIss(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('DeclarationIs', 'list');
        isPermistted ? this.service.findAll().subscribe(declarationIss => this.items = declarationIss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'dateDeclaration', header: 'Date declaration'},
            {field: 'trimistre', header: 'Trimistre'},
            {field: 'annee', header: 'Annee'},
            {field: 'societe?.ice', header: 'Societe'},
            {field: 'totalCharge', header: 'Total charge'},
            {field: 'totalProduit', header: 'Total produit'},
            {field: 'resultatAvantImpot', header: 'Resultat avant impot'},
            {field: 'tauxIs?.id', header: 'Taux is'},
            {field: 'montantImpot', header: 'Montant impot'},
            {field: 'resultatApresImpot', header: 'Resultat apres impot'},
        ];
    }


    public async loadSociete(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('DeclarationIs', 'list');
        isPermistted ? this.societeService.findAllOptimized().subscribe(societes => this.societes = societes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadTauxIs(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('DeclarationIs', 'list');
        isPermistted ? this.tauxIsService.findAll().subscribe(tauxIss => this.tauxIss = tauxIss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: DeclarationIsDto) {
        if (res.factureCharges != null) {
             res.factureCharges.forEach(d => { d.declarationIs = null; d.id = null; });
        }
        if (res.factureProduit != null) {
             res.factureProduit.forEach(d => { d.declarationIs = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Date declaration': this.datePipe.transform(e.dateDeclaration , 'dd/MM/yyyy hh:mm'),
                 'Trimistre': e.trimistre ,
                 'Annee': e.annee ,
                'Societe': e.societe?.ice ,
                 'Total charge': e.totalCharge ,
                 'Total produit': e.totalProduit ,
                 'Resultat avant impot': e.resultatAvantImpot ,
                'Taux is': e.tauxIs?.id ,
                 'Montant impot': e.montantImpot ,
                 'Resultat apres impot': e.resultatApresImpot ,
            }
        });

        this.criteriaData = [{
            'Date declaration Min': this.criteria.dateDeclarationFrom ? this.datePipe.transform(this.criteria.dateDeclarationFrom , this.dateFormat) : environment.emptyForExport ,
            'Date declaration Max': this.criteria.dateDeclarationTo ? this.datePipe.transform(this.criteria.dateDeclarationTo , this.dateFormat) : environment.emptyForExport ,
            'Trimistre Min': this.criteria.trimistreMin ? this.criteria.trimistreMin : environment.emptyForExport ,
            'Trimistre Max': this.criteria.trimistreMax ? this.criteria.trimistreMax : environment.emptyForExport ,
            'Annee Min': this.criteria.anneeMin ? this.criteria.anneeMin : environment.emptyForExport ,
            'Annee Max': this.criteria.anneeMax ? this.criteria.anneeMax : environment.emptyForExport ,
        //'Societe': this.criteria.societe?.ice ? this.criteria.societe?.ice : environment.emptyForExport ,
            'Total charge Min': this.criteria.totalChargeMin ? this.criteria.totalChargeMin : environment.emptyForExport ,
            'Total charge Max': this.criteria.totalChargeMax ? this.criteria.totalChargeMax : environment.emptyForExport ,
            'Total produit Min': this.criteria.totalProduitMin ? this.criteria.totalProduitMin : environment.emptyForExport ,
            'Total produit Max': this.criteria.totalProduitMax ? this.criteria.totalProduitMax : environment.emptyForExport ,
            'Resultat avant impot Min': this.criteria.resultatAvantImpotMin ? this.criteria.resultatAvantImpotMin : environment.emptyForExport ,
            'Resultat avant impot Max': this.criteria.resultatAvantImpotMax ? this.criteria.resultatAvantImpotMax : environment.emptyForExport ,
        //'Taux is': this.criteria.tauxIs?.id ? this.criteria.tauxIs?.id : environment.emptyForExport ,
            'Montant impot Min': this.criteria.montantImpotMin ? this.criteria.montantImpotMin : environment.emptyForExport ,
            'Montant impot Max': this.criteria.montantImpotMax ? this.criteria.montantImpotMax : environment.emptyForExport ,
            'Resultat apres impot Min': this.criteria.resultatApresImpotMin ? this.criteria.resultatApresImpotMin : environment.emptyForExport ,
            'Resultat apres impot Max': this.criteria.resultatApresImpotMax ? this.criteria.resultatApresImpotMax : environment.emptyForExport ,
        }];
      }
}
