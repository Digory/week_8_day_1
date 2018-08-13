import db.DBGuitar;
import db.DBMusician;
import models.Guitar;
import models.Musician;

import java.util.List;

public class Runner {

    public static void main(String[] args) {


        // Test CREATE Guitar

        Guitar guitar1 = new Guitar("blue", 6);
        DBGuitar.save(guitar1);

        Guitar guitar2 = new Guitar("green", 12);
        DBGuitar.save(guitar2);

        // Test READ Guitar

        List<Guitar> guitars = DBGuitar.getAll();
        Guitar foundGuitar = DBGuitar.findById(2);

        // Test UPDATE Guitar

        guitar2.setColour("red");
        DBGuitar.update(guitar2);
        Guitar foundGuitarAgain = DBGuitar.findById(2);

        // Test DELETE Guitar

        DBGuitar.delete(guitar2);
        List<Guitar> guitarsAgain = DBGuitar.getAll();



        // Test CREATE Musician

        Musician musician1 = new Musician("Digory");
        DBMusician.save(musician1);

        Musician musician2 = new Musician("Wigory");
        DBMusician.save(musician2);

        // Test READ Musician

        List<Musician> musicians = DBMusician.getAll();
        Musician foundMusician = DBMusician.findById(2);

        // Test UPDATE Musician

        musician2.setName("Migory");
        DBMusician.update(musician2);
        Musician foundMusicianAgain = DBMusician.findById(2);

        // Test DELETE Musician

        DBMusician.delete(musician2);
        List<Musician> musiciansAgain = DBMusician.getAll();
    }
}
