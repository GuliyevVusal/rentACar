package az.spring.rentACar.webApi.controllers;

import az.spring.rentACar.business.abstracts.BrandService;
import az.spring.rentACar.business.dtos.requests.CreateBrandRequest;
import az.spring.rentACar.business.dtos.requests.UpdateBrandRequest;
import az.spring.rentACar.business.dtos.responses.GetAllBrandsResponse;
import az.spring.rentACar.business.dtos.responses.GetByIdBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/brands")
public class BrandsController {

    private BrandService brandService;

//    @Autowired
//    public BrandsController(BrandService brandService) {
//        this.brandService = brandService;
//    }

    @GetMapping()
    public List<GetAllBrandsResponse> getAll() {
        return brandService.getAll();

    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id) {
        return brandService.getById(id);

    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateBrandRequest createBrandRequest) {
        this.brandService.add(createBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateBrandRequest updateBrandRequest) {
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        this.brandService.delete(id);
    }

}
