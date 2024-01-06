package Work.storage;

import Work.Animals.AbstractAnimal;

import java.util.List;

public interface Storage {

    List<AbstractAnimal> getAllAnimals();

    AbstractAnimal getAnimalById(int animalId);

    boolean addAnimal(AbstractAnimal animal);

    int removeAnimal(AbstractAnimal animal);
}