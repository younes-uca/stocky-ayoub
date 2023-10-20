import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CollaborateurDto} from '../commun/Collaborateur.model';
import {InventaireItemDto} from './InventaireItem.model';

export class InventaireDto extends BaseDto{

    public reference: string;

   public dateInventaire: Date;

    public description: string;

    public collaborateur: CollaborateurDto ;
     public inventaireItems: Array<InventaireItemDto>;
    

    constructor() {
        super();

        this.reference = '';
        this.dateInventaire = null;
        this.description = '';
        this.collaborateur = new CollaborateurDto() ;
        this.inventaireItems = new Array<InventaireItemDto>();

        }

}
