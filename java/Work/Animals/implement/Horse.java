package Work.Animals.implement;

import Work.Animals.Pack_Animals;
import Work.Animals.AnimalGenius;

import java.time.LocalDate;

public class Horse extends Pack_Animals {
    public Horse(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalGenius.HORSE);
    }
}
