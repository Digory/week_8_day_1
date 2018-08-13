import db.DBGuitar;
import models.Guitar;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        // Test CREATE

        Guitar guitar1 = new Guitar("blue", 6);
        DBGuitar.save(guitar1);

        Guitar guitar2 = new Guitar("green", 12);
        DBGuitar.save(guitar2);

        // Test READ

        List<Guitar> guitars = DBGuitar.getAll();
        Guitar foundGuitar = DBGuitar.findById(2);

        // Test UPDATE

        guitar2.setColour("red");
        DBGuitar.update(guitar2);
        Guitar foundGuitarAgain = DBGuitar.findById(2);

        // Test DELETE

        DBGuitar.delete(guitar2);
        List<Guitar> guitarsAgain = DBGuitar.getAll();
    }
}
