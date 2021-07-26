package dev.paulmatthews.baseormexample.data;

import dev.paulmatthews.baseormexample.models.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
