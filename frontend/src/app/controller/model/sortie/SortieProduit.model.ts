import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CollaborateurDto} from '../commun/Collaborateur.model';
import {SortieProduitItemDto} from './SortieProduitItem.model';

export class SortieProduitDto extends BaseDto{

    public reference: string;

   public dateSortieProduit: Date;

    public total: null | number;

    public description: string;

    public collaborateur: CollaborateurDto ;
     public sortieProduitItems: Array<SortieProduitItemDto>;
    

    constructor() {
        super();

        this.reference = '';
        this.dateSortieProduit = null;
        this.total = null;
        this.description = '';
        this.collaborateur = new CollaborateurDto() ;
        this.sortieProduitItems = new Array<SortieProduitItemDto>();

        }

}
