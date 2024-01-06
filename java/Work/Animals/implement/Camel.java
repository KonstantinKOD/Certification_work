package Work.Animals.implement;

import Work.Animals.Pack_Animals;
import Work.Animals.AnimalGenius;

import java.time.LocalDate;

public class Camel extends Pack_Animals {
    public Camel(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalGenius.CAMEL);
    }
}