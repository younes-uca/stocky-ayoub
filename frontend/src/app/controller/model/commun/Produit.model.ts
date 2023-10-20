import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';

import {CategorieProduitDto} from './CategorieProduit.model';
import {MarqueDto} from './Marque.model';
import {StockDto} from './Stock.model';

export class ProduitDto extends BaseDto{

    public reference: string;

    public libelle: string;

    public prixAchatMoyen: null | number;

    public prixVente: null | number;

    public categorieProduit: CategorieProduitDto ;
    public marque: MarqueDto ;
     public stocks: Array<StockDto>;
    

    constructor() {
        super();

        this.reference = '';
        this.libelle = '';
        this.prixAchatMoyen = null;
        this.prixVente = null;
        this.categorieProduit = new CategorieProduitDto() ;
        this.marque = new MarqueDto() ;
        this.stocks = new Array<StockDto>();

        }

}
