import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {FactureProduitService} from 'src/app/controller/service/FactureProduit.service';
import {FactureProduitDto} from 'src/app/controller/model/FactureProduit.model';
import {FactureProduitCriteria} from 'src/app/controller/criteria/FactureProduitCriteria.model';

import {SocieteDto} from 'src/app/controller/model/Societe.model';
import {SocieteService} from 'src/app/controller/service/Societe.service';
@Component({
  selector: 'app-facture-produit-view-admin',
  templateUrl: './facture-produit-view-admin.component.html'
})
export class FactureProduitViewAdminComponent extends AbstractViewController<FactureProduitDto, FactureProduitCriteria, FactureProduitService> implements OnInit {


    constructor(private factureProduitService: FactureProduitService, private societeService: SocieteService){
        super(factureProduitService);
    }

    ngOnInit(): void {
        this.societe = new SocieteDto();
        this.societeService.findAll().subscribe((data) => this.societes = data);
    }


    get societe(): SocieteDto {
       return this.societeService.item;
    }
    set societe(value: SocieteDto) {
        this.societeService.item = value;
    }
    get societes():Array<SocieteDto> {
       return this.societeService.items;
    }
    set societes(value: Array<SocieteDto>) {
        this.societeService.items = value;
    }


}
