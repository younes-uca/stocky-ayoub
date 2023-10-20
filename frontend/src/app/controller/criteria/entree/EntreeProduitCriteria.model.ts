import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {CollaborateurCriteria} from '../commun/CollaborateurCriteria.model';
import {FournisseurCriteria} from '../commun/FournisseurCriteria.model';
import {EntreeProduitItemCriteria} from './EntreeProduitItemCriteria.model';

export class EntreeProduitCriteria  extends BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public dateEntreeProduit: Date;
    public dateEntreeProduitFrom: Date;
    public dateEntreeProduitTo: Date;
     public total: number;
     public totalMin: number;
     public totalMax: number;
    public description: string;
    public descriptionLike: string;
  public fournisseur: FournisseurCriteria ;
  public fournisseurs: Array<FournisseurCriteria> ;
  public collaborateur: CollaborateurCriteria ;
  public collaborateurs: Array<CollaborateurCriteria> ;
      public entreeProduitItems: Array<EntreeProduitItemCriteria>;

}
