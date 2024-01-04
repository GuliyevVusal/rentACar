package az.spring.rentACar.webApi.controllers;

import az.spring.rentACar.business.abstracts.ModelService;
import az.spring.rentACar.business.dtos.requests.CreateModelRequest;
import az.spring.rentACar.business.dtos.responses.GetAllModelsResponse;
import az.spring.rentACar.business.dtos.responses.GetByIdBrandResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/models")
public class ModelsController {

    private ModelService modelService;

    @GetMapping()
    public List<GetAllModelsResponse> getAll() {
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateModelRequest createModelRequest) {
        this.modelService.add(createModelRequest);
    }

}
