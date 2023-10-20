package ma.zy.stocky.dao.facade.core.commun;

import org.springframework.data.jpa.repository.Query;
import ma.zy.stocky.zynerator.repository.AbstractRepository;
import ma.zy.stocky.bean.core.commun.Fournisseur;
import org.springframework.stereotype.Repository;
import ma.zy.stocky.bean.core.commun.Fournisseur;
import java.util.List;


@Repository
public interface FournisseurDao extends AbstractRepository<Fournisseur,Long>  {
    Fournisseur findByPrenom(String prenom);
    int deleteByPrenom(String prenom);


    @Query("SELECT NEW Fournisseur(item.id,item.reference) FROM Fournisseur item")
    List<Fournisseur> findAllOptimized();

}
