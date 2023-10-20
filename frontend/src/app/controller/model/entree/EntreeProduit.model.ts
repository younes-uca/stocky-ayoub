import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CollaborateurDto} from '../commun/Collaborateur.model';
import {FournisseurDto} from '../commun/Fournisseur.model';
import {EntreeProduitItemDto} from './EntreeProduitItem.model';

export class EntreeProduitDto extends BaseDto{

    public reference: string;

   public dateEntreeProduit: Date;

    public total: null | number;

    public description: string;

    public fournisseur: FournisseurDto ;
    public collaborateur: CollaborateurDto ;
     public entreeProduitItems: Array<EntreeProduitItemDto>;
    

    constructor() {
        super();

        this.reference = '';
        this.dateEntreeProduit = null;
        this.total = null;
        this.description = '';
        this.fournisseur = new FournisseurDto() ;
        this.collaborateur = new CollaborateurDto() ;
        this.entreeProduitItems = new Array<EntreeProduitItemDto>();

        }

}
