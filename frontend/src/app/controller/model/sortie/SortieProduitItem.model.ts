import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {ProduitDto} from '../commun/Produit.model';
import {SortieProduitDto} from './SortieProduit.model';

export class SortieProduitItemDto extends BaseDto{

    public quantite: null | number;

    public prix: null | number;

    public produit: ProduitDto ;
    public sortieProduit: SortieProduitDto ;
    

    constructor() {
        super();

        this.quantite = null;
        this.prix = null;
        this.produit = new ProduitDto() ;
        this.sortieProduit = new SortieProduitDto() ;

        }

}
