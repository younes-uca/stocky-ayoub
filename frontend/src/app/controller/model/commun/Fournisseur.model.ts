import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class FournisseurDto extends BaseDto{

    public reference: string;

    public nom: string;

    public prenom: string;

    public telephone: string;

    public email: string;

    public description: string;

    

    constructor() {
        super();

        this.reference = '';
        this.nom = '';
        this.prenom = '';
        this.telephone = '';
        this.email = '';
        this.description = '';

        }

}
