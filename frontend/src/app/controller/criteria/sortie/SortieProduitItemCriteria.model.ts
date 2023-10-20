import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {ProduitCriteria} from '../commun/ProduitCriteria.model';
import {SortieProduitCriteria} from './SortieProduitCriteria.model';

export class SortieProduitItemCriteria  extends BaseCriteria  {

    public id: number;
     public quantite: number;
     public quantiteMin: number;
     public quantiteMax: number;
     public prix: number;
     public prixMin: number;
     public prixMax: number;
  public produit: ProduitCriteria ;
  public produits: Array<ProduitCriteria> ;
  public sortieProduit: SortieProduitCriteria ;
  public sortieProduits: Array<SortieProduitCriteria> ;

}
