package guru.springframework.repositories.reactive;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UnitOfMeasureReactiveRepositoryIT {

    @Autowired
    UnitOfMeasureReactiveRepository unitOfMeasureReactiveRepository;

    @Test
    public void addObject() throws Exception {
        UnitOfMeasure um = new UnitOfMeasure();
        um.setDescription("Deca Liters");
        unitOfMeasureReactiveRepository.save(um);
    }

    @Test
    public void listAll() throws Exception {
        List<UnitOfMeasure> umList = unitOfMeasureReactiveRepository.findAll().collectList().block();
//        System.out.println("");
    }

}
