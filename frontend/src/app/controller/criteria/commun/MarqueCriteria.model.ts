import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class MarqueCriteria  extends BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public libelle: string;
    public libelleLike: string;

}
