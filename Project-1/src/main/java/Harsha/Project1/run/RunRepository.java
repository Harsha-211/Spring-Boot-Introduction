package Harsha.Project1.run;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RunRepository {
    private List<Run> run = new ArrayList<>();

    List<Run> findAll(){
        return run;
    }
    Optional<Run> findById(Integer id){
        return run.stream().filter(run->run.vegetables() == id).findFirst();
    }

    void create(Run run){

    }

    @PostConstruct
    private void init(){
        run.add(new Run(10,2, Health.Healthier, Taste.Special,Location.Native));
        run.add(new Run(5,1, Health.Healthier, Taste.Good,Location.forien));
    }
}
