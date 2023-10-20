import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {CollaborateurCriteria} from '../commun/CollaborateurCriteria.model';
import {SortieProduitItemCriteria} from './SortieProduitItemCriteria.model';

export class SortieProduitCriteria  extends BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public dateSortieProduit: Date;
    public dateSortieProduitFrom: Date;
    public dateSortieProduitTo: Date;
     public total: number;
     public totalMin: number;
     public totalMax: number;
    public description: string;
    public descriptionLike: string;
  public collaborateur: CollaborateurCriteria ;
  public collaborateurs: Array<CollaborateurCriteria> ;
      public sortieProduitItems: Array<SortieProduitItemCriteria>;

}
