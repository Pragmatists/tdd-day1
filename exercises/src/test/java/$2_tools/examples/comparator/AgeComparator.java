
package $2_tools.examples.comparator;

import $2_tools.examples.TolkienCharacter;

import java.util.Comparator;


/**
 * Compare {@link TolkienCharacter} age.
 */
public class AgeComparator implements Comparator<TolkienCharacter> {
    public int compare(TolkienCharacter tolkienCharacter1, TolkienCharacter tolkienCharacter2) {
        Integer age1 = tolkienCharacter1.age;
        return age1.compareTo(tolkienCharacter2.age);
    }

}
