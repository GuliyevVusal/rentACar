package az.spring.rentACar.business.concrets;

import az.spring.rentACar.business.abstracts.BrandService;
import az.spring.rentACar.business.dtos.requests.CreateBrandRequest;
import az.spring.rentACar.business.dtos.requests.UpdateBrandRequest;
import az.spring.rentACar.business.dtos.responses.GetAllBrandsResponse;
import az.spring.rentACar.business.dtos.responses.GetByIdBrandResponse;
import az.spring.rentACar.business.rules.BrandBusinessRules;
import az.spring.rentACar.core.utilities.mappers.ModelMapperManager;
import az.spring.rentACar.core.utilities.mappers.ModelMapperService;
import az.spring.rentACar.dataAccess.abstracts.BrandRepository;
import az.spring.rentACar.entities.concrets.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

//    @Autowired         yuxarida Anatation i.eliyirik @AllArgsConstructor
//    public BrandManager(BrandRepository brandRepository) {
//        this.brandRepository = brandRepository;
//    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
//        for (Brand brand : brands) {
//            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
//            responseItem.setId(brand.getId());
//            responseItem.setName(brand.getName());
//            brandsResponse.add(responseItem);
//        }

        List<GetAllBrandsResponse> brandsResponses =
                (List<GetAllBrandsResponse>) brands.stream().map(brand -> this.modelMapperService
                        .forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponses;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response =
                this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
//        Brand brand = new Brand();
//        brand.setName(createBrandRequest.getName());

        this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {

        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
