package az.spring.rentACar.business.abstracts;

import az.spring.rentACar.business.dtos.requests.CreateModelRequest;
import az.spring.rentACar.business.dtos.responses.GetAllModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();

    void add(CreateModelRequest createModelRequest);
}
