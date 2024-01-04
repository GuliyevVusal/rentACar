package az.spring.rentACar.dataAccess.abstracts;

import az.spring.rentACar.entities.concrets.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Integer> {


}
