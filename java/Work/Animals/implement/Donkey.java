package Work.Animals.implement;

import Work.Animals.Pack_Animals;
import Work.Animals.AnimalGenius;

import java.time.LocalDate;

public class Donkey extends Pack_Animals {
    public Donkey(String name, LocalDate birthDate) {
        super(name, birthDate);
        setAnimalGenius(AnimalGenius.DONKEY);
    }
}
