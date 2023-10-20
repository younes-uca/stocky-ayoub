import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ProduitDto} from '../commun/Produit.model';
import {EntreeProduitDto} from './EntreeProduit.model';

export class EntreeProduitItemDto extends BaseDto{

    public quantite: null | number;

    public prix: null | number;

    public produit: ProduitDto ;
    public entreeProduit: EntreeProduitDto ;
    

    constructor() {
        super();

        this.quantite = null;
        this.prix = null;
        this.produit = new ProduitDto() ;
        this.entreeProduit = new EntreeProduitDto() ;

        }

}
