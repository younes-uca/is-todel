import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {FactureProduitService} from 'src/app/controller/service/FactureProduit.service';
import {FactureProduitDto} from 'src/app/controller/model/FactureProduit.model';
import {FactureProduitCriteria} from 'src/app/controller/criteria/FactureProduitCriteria.model';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';
@Component({
  selector: 'app-facture-produit-create-admin',
  templateUrl: './facture-produit-create-admin.component.html'
})
export class FactureProduitCreateAdminComponent extends AbstractCreateController<FactureProduitDto, FactureProduitCriteria, FactureProduitService>  implements OnInit {



    private _validSocieteIce = true;

    constructor( private factureProduitService: FactureProduitService , private societeService: SocieteService) {
        super(factureProduitService);
    }

    ngOnInit(): void {
    this.societe = new SocieteDto();
    this.societeService.findAll().subscribe((data) => this.societes = data);
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateSociete(societe: string) {
    const isPermistted = await this.roleService.isPermitted('Societe', 'add');
    if(isPermistted) {
         this.societe = new SocieteDto();
         this.createSocieteDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get societe(): SocieteDto {
        return this.societeService.item;
    }
    set societe(value: SocieteDto) {
        this.societeService.item = value;
    }
    get societes(): Array<SocieteDto> {
        return this.societeService.items;
    }
    set societes(value: Array<SocieteDto>) {
        this.societeService.items = value;
    }
    get createSocieteDialog(): boolean {
       return this.societeService.createDialog;
    }
    set createSocieteDialog(value: boolean) {
        this.societeService.createDialog= value;
    }




    get validSocieteIce(): boolean {
        return this._validSocieteIce;
    }
    set validSocieteIce(value: boolean) {
        this._validSocieteIce = value;
    }


}
