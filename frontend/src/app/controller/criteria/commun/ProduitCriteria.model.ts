import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {CategorieProduitCriteria} from './CategorieProduitCriteria.model';
import {MarqueCriteria} from './MarqueCriteria.model';
import {StockCriteria} from './StockCriteria.model';

export class ProduitCriteria  extends BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public libelle: string;
    public libelleLike: string;
     public prixAchatMoyen: number;
     public prixAchatMoyenMin: number;
     public prixAchatMoyenMax: number;
     public prixVente: number;
     public prixVenteMin: number;
     public prixVenteMax: number;
  public categorieProduit: CategorieProduitCriteria ;
  public categorieProduits: Array<CategorieProduitCriteria> ;
  public marque: MarqueCriteria ;
  public marques: Array<MarqueCriteria> ;
      public stocks: Array<StockCriteria>;

}
