package az.spring.rentACar.business.concrets;

import az.spring.rentACar.business.abstracts.ModelService;
import az.spring.rentACar.business.dtos.requests.CreateModelRequest;
import az.spring.rentACar.business.dtos.responses.GetAllModelsResponse;
import az.spring.rentACar.core.utilities.mappers.ModelMapperService;
import az.spring.rentACar.dataAccess.abstracts.ModelRepository;
import az.spring.rentACar.entities.concrets.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;


    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelsResponse> modelsResponse =
                models.stream().map(model -> this.modelMapperService.forResponse()
                        .map(model, GetAllModelsResponse.class)).collect(Collectors.toList());
        return null;

    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);
    }
}
