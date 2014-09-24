package $8_assertions;

import static com.googlecode.catchexception.CatchException.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import hero.Hero;

import org.junit.Ignore;
import org.junit.Test;

public class HeroBeingDeadTest {

    @Test
    public void hero_cannot_fight_when_is_dead() throws Exception {
        Hero hero = new Hero().health(0);

        try {
            hero.fight(anyHero());
            fail("Exception was not thrown");
        } catch (Hero.DeadException exception) {
            //expected DeadException
        }
    }

    @Ignore
    @Test(expected = Hero.DeadException.class)
    public void hero_cannot_fight_when_is_dead_v2() throws Exception {
        Hero hero = new Hero().health(0);

        hero.fight(anyHero());

        //exception expected
    }

    @Ignore
    @Test
    public void hero_cannot_fight_when_is_dead_v3() throws Exception {
        Hero hero = new Hero().health(0);

        catchException(hero).fight(anyHero());

//       assertThat(xxx).isExactlyInstanceOf(Hero.DeadException.class);
    }


    private Hero anyHero() {
        return new Hero();
    }
}
