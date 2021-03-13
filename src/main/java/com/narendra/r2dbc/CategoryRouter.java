package com.narendra.r2dbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class CategoryRouter {

    @Autowired
    CategoryRepository categoryRepository;

    @Bean
    RouterFunction<ServerResponse> getEmployeeByIdRoute() {
        return route(GET("/employees/{id}"),
                req -> ok().body(
                        categoryRepository.findById(Integer.valueOf(req.pathVariable("id"))), Category.class));
    }

    @Bean
    RouterFunction<ServerResponse> getAccountByIdRoute() {

        return route(GET("/category/{id}"),
                req -> ok().body(
                        categoryRepository.findById(Integer.valueOf(req.pathVariable("id"))), CategoryRepository.class));
    }


    @Bean
    public RouterFunction<ServerResponse> getAllCategoriesRoute() {
        return route(GET("/category"),
                req ->
                        ok().body(
                                categoryRepository.findAll(), Category.class)
               );
    }

    //TODO
//    @PostMapping("/save")
//    public Mono<Category> saveECate(@RequestBody Category category){
//        return categoryRepository.saveCategory(category);
//    }


}
