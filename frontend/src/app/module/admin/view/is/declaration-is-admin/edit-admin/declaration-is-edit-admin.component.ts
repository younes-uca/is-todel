import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {DeclarationIsService} from 'src/app/controller/service/DeclarationIs.service';
import {DeclarationIsDto} from 'src/app/controller/model/DeclarationIs.model';
import {DeclarationIsCriteria} from 'src/app/controller/criteria/DeclarationIsCriteria.model';


import {FactureChargeDto} from 'src/app/controller/model/FactureCharge.model';
import {FactureChargeService} from 'src/app/controller/service/FactureCharge.service';
import {FactureProduitDto} from 'src/app/controller/model/FactureProduit.model';
import {FactureProduitService} from 'src/app/controller/service/FactureProduit.service';
import {TauxIsDto} from 'src/app/controller/model/TauxIs.model';
import {TauxIsService} from 'src/app/controller/service/TauxIs.service';
import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';

@Component({
  selector: 'app-declaration-is-edit-admin',
  templateUrl: './declaration-is-edit-admin.component.html'
})
export class DeclarationIsEditAdminComponent extends AbstractEditController<DeclarationIsDto, DeclarationIsCriteria, DeclarationIsService>   implements OnInit {

    private _factureChargesElement = new FactureChargeDto();
    private _factureProduitElement = new FactureProduitDto();


    private _validSocieteIce = true;



    constructor( private declarationIsService: DeclarationIsService , private factureChargeService: FactureChargeService, private tauxIsService: TauxIsService, private societeService: SocieteService, private factureProduitService: FactureProduitService) {
        super(declarationIsService);
    }

    ngOnInit(): void {
        this.factureChargesElement.societe = new SocieteDto();
        this.societeService.findAll().subscribe((data) => this.societes = data);

        this.factureProduitElement.societe = new SocieteDto();
        this.societeService.findAll().subscribe((data) => this.societes = data);

    this.societe = new SocieteDto();
    this.societeService.findAll().subscribe((data) => this.societes = data);
    this.tauxIs = new TauxIsDto();
    this.tauxIsService.findAll().subscribe((data) => this.tauxIss = data);
}
    public prepareEdit() {
        this.item.dateDeclaration = this.declarationIsService.format(this.item.dateDeclaration);
    }



    public validateFactureCharges(){
        this.errorMessages = new Array();
    }
    public validateFactureProduit(){
        this.errorMessages = new Array();
    }
    public setValidation(value : boolean){
        }
   public addFactureCharges() {
        if( this.item.factureCharges == null )
            this.item.factureCharges = new Array<FactureChargeDto>();
       this.validateFactureCharges();
       if (this.errorMessages.length === 0) {
            if(this.factureChargesElement.id == null){
                this.item.factureCharges.push(this.factureChargesElement);
            }else{
                const index = this.item.factureCharges.findIndex(e => e.id == this.factureChargesElement.id);
                this.item.factureCharges[index] = this.factureChargesElement;
            }
          this.factureChargesElement = new FactureChargeDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteFactureCharge(p: FactureChargeDto) {
        this.item.factureCharges.forEach((element, index) => {
            if (element === p) { this.item.factureCharges.splice(index, 1); }
        });
    }

    public editFactureCharge(p: FactureChargeDto) {
        this.factureChargesElement = {... p};
        this.activeTab = 0;
    }
   public addFactureProduit() {
        if( this.item.factureProduit == null )
            this.item.factureProduit = new Array<FactureProduitDto>();
       this.validateFactureProduit();
       if (this.errorMessages.length === 0) {
            if(this.factureProduitElement.id == null){
                this.item.factureProduit.push(this.factureProduitElement);
            }else{
                const index = this.item.factureProduit.findIndex(e => e.id == this.factureProduitElement.id);
                this.item.factureProduit[index] = this.factureProduitElement;
            }
          this.factureProduitElement = new FactureProduitDto();
       }else{
            this.messageService.add({severity: 'error',summary: 'Erreurs', detail: 'Merci de corrigé les erreurs suivant : ' + this.errorMessages});
        }
   }

    public deleteFactureProduit(p: FactureProduitDto) {
        this.item.factureProduit.forEach((element, index) => {
            if (element === p) { this.item.factureProduit.splice(index, 1); }
        });
    }

    public editFactureProduit(p: FactureProduitDto) {
        this.factureProduitElement = {... p};
        this.activeTab = 0;
    }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateTauxIs(tauxIs: string) {
        const isPermistted = await this.roleService.isPermitted('TauxIs', 'edit');
        if(isPermistted) {
             this.tauxIs = new TauxIsDto();
             this.createTauxIsDialog = true;
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
   get tauxIs(): TauxIsDto {
       return this.tauxIsService.item;
   }
  set tauxIs(value: TauxIsDto) {
        this.tauxIsService.item = value;
   }
   get tauxIss(): Array<TauxIsDto> {
        return this.tauxIsService.items;
   }
   set tauxIss(value: Array<TauxIsDto>) {
        this.tauxIsService.items = value;
   }
   get createTauxIsDialog(): boolean {
       return this.tauxIsService.createDialog;
   }
  set createTauxIsDialog(value: boolean) {
       this.tauxIsService.createDialog= value;
   }

    get factureChargesElement(): FactureChargeDto {
        if( this._factureChargesElement == null )
            this._factureChargesElement = new FactureChargeDto();
         return this._factureChargesElement;
    }

    set factureChargesElement(value: FactureChargeDto) {
        this._factureChargesElement = value;
    }
    get factureProduitElement(): FactureProduitDto {
        if( this._factureProduitElement == null )
            this._factureProduitElement = new FactureProduitDto();
         return this._factureProduitElement;
    }

    set factureProduitElement(value: FactureProduitDto) {
        this._factureProduitElement = value;
    }


    get validSocieteIce(): boolean {
        return this._validSocieteIce;
    }
    set validSocieteIce(value: boolean) {
        this._validSocieteIce = value;
    }
}
