package $2_tools;

import static org.junit.Assert.*;

import org.junit.Test;

import hero.Hero;
import hero.HeroService;

public class AssertionsTest {
    private static final int SUPERMAN_ID = 1;

    private HeroService heroService = new HeroService();

    @Test
    public void should_use_junit() {
        Hero hero = heroService.getHero(SUPERMAN_ID);

        assertEquals(hero.getAlias(), "Superman");
    }

    @Test
    public void should_use_hamcrest() {
        Hero hero = heroService.getHero(SUPERMAN_ID);

//        Assert.assertThat(hero.getAlias(), xxx("Superman"));
    }

    @Test
    public void should_use_assertJ() {
        Hero hero = heroService.getHero(SUPERMAN_ID);

//        Assertions.assertThat(hero.getAlias()).xxx("Superman");
    }

}
