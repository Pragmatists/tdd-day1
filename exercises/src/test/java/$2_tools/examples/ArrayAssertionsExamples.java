
package $2_tools.examples;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;

import static $2_tools.examples.Ring.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Arrays.array;

/**
 * Array assertions examples.
 */
public class ArrayAssertionsExamples extends AbstractAssertionsExamples {
    @Test
    public void rings_are_not_empty() throws Exception {
        Ring[] elvesRings = array(vilya, nenya, narya);

    }

    @Test
    public void rings_have_size() throws Exception {
        Ring[] elvesRings = array(vilya, nenya, narya);

    }

    @Test
    public void rings_contains_nenya() throws Exception {
        Ring[] elvesRings = array(vilya, nenya, narya);

    }

    @Test
    public void rings_not_contains_oneRing() throws Exception {
        Ring[] elvesRings = array(vilya, nenya, narya);

    }

    @Test
    public void all_rigs_are_present() throws Exception {
        Ring[] elvesRings = array(vilya, nenya, narya);

    }

    // putting a different order would make the assertion fail :
    @Test
    public void all_rigs_are_present_in_given_order() throws Exception {
        Ring[] elvesRings = array(vilya, nenya, narya);
    }

    @Test
    public void all_rigs_are_present_and_no_other() throws Exception {
        Ring[] elvesRings = array(vilya, nenya, narya);

    }

    @Test
    public void first_element_is_vilya() throws Exception {
        Ring[] elvesRings = array(vilya, nenya, narya);

    }

    @Test
    public void all_elements_are_sorted() throws Exception {
        TolkienCharacter[] fellowshipOfTheRingArray = fellowshipOfTheRing.toArray(new TolkienCharacter[0]);
        Arrays.sort(fellowshipOfTheRingArray, ageComparator);

    }

    @Test
    public void fellowship_contains_heroes_by_names() {
        TolkienCharacter[] fellowshipOfTheRingArray = fellowshipOfTheRing.toArray(new TolkienCharacter[0]);

        //conatins "Boromir", "Gandalf", "Frodo","Legolas"
    }

    @Test
    public void fellowship_does_not_contain_orcs() {
        TolkienCharacter[] fellowshipOfTheRingArray = fellowshipOfTheRing.toArray(new TolkienCharacter[0]);

        //"Hobbit", "Elf", "Orc"
    }


}
