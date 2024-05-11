package Harsha.Project1.run;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class runControllers {

    private final RunRepository runRepository;

    public runControllers(RunRepository runRepository){
        this.runRepository = runRepository;
    }
    @GetMapping("/runs")
    List<Run> findAll(){
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run  findById(@PathVariable Integer id){

        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Run is not found");
        }
        return  run.get();
    }

    @PostMapping("")
    void create(Run run){
        runRepository.create(run);
    }
}
