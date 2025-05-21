package dev.marekvoe.pizzatieto.repositories;

import dev.marekvoe.pizzatieto.models.Pizza;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PizzaRepository extends MongoRepository<Pizza, Integer> {

}
