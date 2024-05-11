package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/")
public class RestApiDemoController {
    private List<Coffee> coffees = new ArrayList<>();
    public RestApiDemoController(){
        coffees.addAll(List.of(
                new Coffee("Cafe cereza"),
                new Coffee("Cafe Ganador"),
                new Coffee("Cafe Lareno"),
                new Coffee("Cafe Tres Pontas")
        ));
    }
    @GetMapping("/")
    Iterable<Coffee> getCoffees(){
        return coffees;
    }
    @GetMapping("/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id){
        for(Coffee c : coffees){
            if(c.getId().equals(id)){
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }
    @PostMapping("/coffee")
    Coffee postCoffee(@RequestBody Coffee coffee){
        coffees.add(coffee);
        return coffee;
    }
    @PutMapping("/{id}")
    Coffee putCoffee(@PathVariable String id, @RequestBody Coffee coffee){
        int coffeeIndex = -1;
        for(Coffee c : coffees){
            if(c.getId().equals(id)){
                coffeeIndex = coffees.indexOf(c);
                coffees.set(coffeeIndex, coffee);
            }
        }
        return (coffeeIndex == -1) ? postCoffee(coffee) : coffee;
    }

    @DeleteMapping("/{id}")
    void deleteCoffee (@PathVariable String id){
        coffees.removeIf(c -> c.getId().equals(id));
    }

}
