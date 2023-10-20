import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';
import {CollaborateurCriteria} from '../commun/CollaborateurCriteria.model';
import {InventaireItemCriteria} from './InventaireItemCriteria.model';

export class InventaireCriteria  extends BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public dateInventaire: Date;
    public dateInventaireFrom: Date;
    public dateInventaireTo: Date;
    public description: string;
    public descriptionLike: string;
  public collaborateur: CollaborateurCriteria ;
  public collaborateurs: Array<CollaborateurCriteria> ;
      public inventaireItems: Array<InventaireItemCriteria>;

}
