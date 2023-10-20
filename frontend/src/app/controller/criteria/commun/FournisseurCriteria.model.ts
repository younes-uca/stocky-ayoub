import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';

export class FournisseurCriteria  extends BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public nom: string;
    public nomLike: string;
    public prenom: string;
    public prenomLike: string;
    public telephone: string;
    public telephoneLike: string;
    public email: string;
    public emailLike: string;
    public description: string;
    public descriptionLike: string;

}
