package com.narendra.r2dbc;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CategoryRepository extends ReactiveCrudRepository<Category, Integer> {


    @Query("INSERT INTO categories(id, name) VALUES ($1, $2)")
    Mono<Category> saveCategory(Category category);
}
