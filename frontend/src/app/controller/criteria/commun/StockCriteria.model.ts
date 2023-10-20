import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ProduitCriteria} from './ProduitCriteria.model';
import {DepotCriteria} from './DepotCriteria.model';

export class StockCriteria  extends BaseCriteria  {

    public id: number;
     public quantite: number;
     public quantiteMin: number;
     public quantiteMax: number;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public depot: DepotCriteria ;
  public depots: Array<DepotCriteria> ;

}
