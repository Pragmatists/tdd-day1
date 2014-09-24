
package $2_tools.examples;

import $2_tools.examples.movie.Movie;
import org.assertj.core.util.introspection.IntrospectionError;
import org.junit.Test;

import java.util.Map;

import static $2_tools.examples.Race.HOBBIT;
import static com.google.common.collect.Maps.newLinkedHashMap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

/**
 * Assertions available for all objects.
 */
public class BasicAssertionsExamples extends AbstractAssertionsExamples {


    @Test
    public void simple_assertions_examples() {
        TolkienCharacter frodo = new TolkienCharacter("Frodo", 33, HOBBIT);

        //age is 33
        //name is "Frodo"
        //name is not "Frodon"
    }

    @Test
    public void meaningful_error_with_test() {
        // set a bad age to Mr Frodo, just to see how nice is the assertion error message
        frodo.setAge(33);
        // you can specify a test description with as() method or describedAs(), it supports String format args
        assertThat(frodo.age).as("check %s's age", frodo.getName()).isEqualTo(33);
    }

    @Test
    public void meaningful_error_with_test_description_example() {
        // but you still can override the error message if you have a better one :
        final String frodon = "Frodob";
        assertThat(frodo.getName()).as("check Frodo's name")
                .overridingErrorMessage("Hey my name is Frodo not %s", frodon).isEqualTo(frodon);

        // if you still can override the error message if you have a better one :
        assertThat(frodo.getName()).overridingErrorMessage("Hey my name is Frodo not (%)").isEqualTo(frodon);

    }

    @Test
    public void assert_object_reference_assertions_examples() {
        //compares objects reference
        Object jake = new Person("Jake", 43);
        Object sameJake = jake;
        Object jakeClone = new Person("Jake", 43); // equals to jake but not the same
        assertThat(jake).isEqualTo(sameJake).isNotEqualTo(jakeClone);
    }

    @Test
    public void better_null_assertions_examples() {
        Object nullObject = null;
        assertThat(nullObject).isEqualTo(null);
        Object nonNullObject = new Object();
        assertThat(nonNullObject).isNotEqualTo(null);
    }

    @Test
    public void better_instance_of_assertions_examples() {
        assertThat(gandalf.getClass()).isEqualTo(TolkienCharacter.class);
        assertThat(gandalf.getClass()).isNotEqualTo(Movie.class);
    }

    @Test
    public void assertion_error_message_differentiates_expected_and_actual_persons() {
        // Assertion error message is built with toString description of involved objects.
        // Sometimes, objects differs but not their toString description, in that case the error message would be
        // confusing because, if toString returns "Jake" for different objects, isEqualTo would return :
        // "expected:<'Jake'> but was:<'Jake'> ... How confusing !
        // In that case, AssertJ is smart enough and differentiates objects description by adding their class and hashCode.
        Person actual = new Person("Jake", 43);
        Person expected = new Person("Jake", 47);

        assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void basic_assertions_with_lenient_equals_examples() {
        TolkienCharacter mysteriousHobbit = new TolkienCharacter(null, 33, HOBBIT);

        // Frodo is still Frodo ...
        assertThat(frodo).isEqualToComparingFieldByField(frodo);

        TolkienCharacter frodoClone = new TolkienCharacter("Frodo", 33, HOBBIT);

        // Frodo and his clone are equals by comparing fields
        assertThat(frodo).isEqualToComparingFieldByField(frodoClone);

        // ------------------------------------------------------------------------------------
        // Lenient equality when ignoring null fields of other object
        // ------------------------------------------------------------------------------------

        // Frodo is still Frodo ...
        assertThat(frodo).isEqualToIgnoringNullFields(frodo);

        // Null fields in expected object are ignored, the mysteriousHobbit has null name
        assertThat(frodo).isEqualToIgnoringNullFields(mysteriousHobbit);


        // ------------------------------------------------------------------------------------
        // Lenient equality with field by field comparison expect specified fields
        // ------------------------------------------------------------------------------------

        // Except name and age, frodo and sam both are hobbits, so they are lenient equals ignoring name and age
        assertThat(frodo).isEqualToIgnoringGivenFields(sam, "name", "age");

        // But not when just age is ignored

        //assertThat(frodo).isEqualToIgnoringGivenFields(sam, "age");

        // ------------------------------------------------------------------------------------
        // Lenient equality with field by field comparison on given fields only
        // ------------------------------------------------------------------------------------

        // frodo and sam both are hobbits, so they are lenient equals on race
        assertThat(frodo).isEqualToComparingOnlyGivenFields(sam, "race");

        // but not when accepting name and race
        //assertThat(frodo).isEqualToComparingOnlyGivenFields(sam, "name", "race", "age");
    }

    @Test
    public void map_contains_examples() throws Exception {

        Map<String, TolkienCharacter> characters = newLinkedHashMap();
        characters.put(frodo.getName(), frodo);
        characters.put(galadriel.getName(), galadriel);
        characters.put(gandalf.getName(), gandalf);
        characters.put(sam.getName(), sam);

        assertThat(characters).containsOnly(
                entry(sam.getName(), sam),
                entry(frodo.getName(), frodo),
                entry(gandalf.getName(), gandalf),
                entry(galadriel.getName(), galadriel));

    }

    @Test
    public void string_assertions_examples() {
        String frodo = "Frodo";
        assertThat(frodo).startsWith("Fro").endsWith("do").hasSize(5);
        assertThat(frodo).contains("rod").doesNotContain("fro");
        assertThat(frodo).containsOnlyOnce("do");
    }

    @Test
    public void number_assertions_examples() throws Exception {
        // equals / no equals assertions
        assertThat(sam.age).isEqualTo(38);
        assertThat(frodo.age).isEqualTo(33).isNotEqualTo(sam.age);

        // <= < > >= assertions
        assertThat(sam.age).isGreaterThan(frodo.age).isGreaterThanOrEqualTo(38);
        assertThat(frodo.age).isLessThan(sam.age).isLessThanOrEqualTo(33);
        assertThat(sam.age).isBetween(frodo.age, gimli.age);

        // shortcuts for assertions : > 0, < 0 and == 0
        assertThat(frodo.age - frodo.age).isZero();
        assertThat(frodo.age - sauron.age).isNegative();
        assertThat(gandalf.age - frodo.age).isPositive();

        assertThat(frodo.age - frodo.age).isNotNegative();
        assertThat(frodo.age - frodo.age).isNotPositive();
        assertThat(gandalf.age - frodo.age).isNotNegative();
        assertThat(frodo.age - sauron.age).isNotPositive();
    }


}
