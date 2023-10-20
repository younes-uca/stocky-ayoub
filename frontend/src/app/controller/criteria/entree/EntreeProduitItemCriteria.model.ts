import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ProduitCriteria} from '../commun/ProduitCriteria.model';
import {EntreeProduitCriteria} from './EntreeProduitCriteria.model';

export class EntreeProduitItemCriteria  extends BaseCriteria  {

    public id: number;
     public quantite: number;
     public quantiteMin: number;
     public quantiteMax: number;
     public prix: number;
     public prixMin: number;
     public prixMax: number;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public entreeProduit: EntreeProduitCriteria ;
  public entreeProduits: Array<EntreeProduitCriteria> ;

}
