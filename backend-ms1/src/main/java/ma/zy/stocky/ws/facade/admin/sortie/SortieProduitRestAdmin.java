package  ma.zy.stocky.ws.facade.admin.sortie;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zy.stocky.bean.core.sortie.SortieProduit;
import ma.zy.stocky.dao.criteria.core.sortie.SortieProduitCriteria;
import ma.zy.stocky.service.facade.admin.sortie.SortieProduitAdminService;
import ma.zy.stocky.ws.converter.sortie.SortieProduitConverter;
import ma.zy.stocky.ws.dto.sortie.SortieProduitDto;
import ma.zy.stocky.zynerator.controller.AbstractController;
import ma.zy.stocky.zynerator.dto.AuditEntityDto;
import ma.zy.stocky.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zy.stocky.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zy.stocky.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/sortieProduit/")
public class SortieProduitRestAdmin  extends AbstractController<SortieProduit, SortieProduitDto, SortieProduitCriteria, SortieProduitAdminService, SortieProduitConverter> {



    @Operation(summary = "upload one sortieProduit")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple sortieProduits")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all sortieProduits")
    @GetMapping("")
    public ResponseEntity<List<SortieProduitDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all sortieProduits")
    @GetMapping("optimized")
    public ResponseEntity<List<SortieProduitDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a sortieProduit by id")
    @GetMapping("id/{id}")
    public ResponseEntity<SortieProduitDto> findById(@PathVariable Long id, String[] includes, String[] excludes) throws Exception {
        return super.findById(id, includes, excludes);
    }
    @Operation(summary = "Saves the specified  sortieProduit")
    @PostMapping("")
    public ResponseEntity<SortieProduitDto> save(@RequestBody SortieProduitDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  sortieProduit")
    @PutMapping("")
    public ResponseEntity<SortieProduitDto> update(@RequestBody SortieProduitDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of sortieProduit")
    @PostMapping("multiple")
    public ResponseEntity<List<SortieProduitDto>> delete(@RequestBody List<SortieProduitDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified sortieProduit")
    @DeleteMapping("")
    public ResponseEntity<SortieProduitDto> delete(@RequestBody SortieProduitDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified sortieProduit")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple sortieProduits by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by collaborateur id")
    @GetMapping("collaborateur/id/{id}")
    public List<SortieProduitDto> findByCollaborateurId(@PathVariable Long id){
        return findDtos(service.findByCollaborateurId(id));
    }
    @Operation(summary = "delete by collaborateur id")
    @DeleteMapping("collaborateur/id/{id}")
    public int deleteByCollaborateurId(@PathVariable Long id){
        return service.deleteByCollaborateurId(id);
    }
    @Operation(summary = "Finds a sortieProduit and associated list by id")
    @GetMapping("detail/id/{id}")
    public ResponseEntity<SortieProduitDto> findWithAssociatedLists(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds sortieProduits by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<SortieProduitDto>> findByCriteria(@RequestBody SortieProduitCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated sortieProduits by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody SortieProduitCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports sortieProduits by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody SortieProduitCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets sortieProduit data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody SortieProduitCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public SortieProduitRestAdmin (SortieProduitAdminService service, SortieProduitConverter converter) {
        super(service, converter);
    }




}
