package az.spring.rentACar.business.abstracts;

import az.spring.rentACar.business.dtos.requests.CreateBrandRequest;
import az.spring.rentACar.business.dtos.requests.UpdateBrandRequest;
import az.spring.rentACar.business.dtos.responses.GetAllBrandsResponse;
import az.spring.rentACar.business.dtos.responses.GetByIdBrandResponse;

import java.util.List;

public interface BrandService {
    List<GetAllBrandsResponse> getAll();

    GetByIdBrandResponse getById(int id);

    void add(CreateBrandRequest createBrandRequest);

    void update(UpdateBrandRequest updateBrandRequest);

    void delete(int id);
}
