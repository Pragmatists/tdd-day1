package $7_data_setup;

import static junitparams.JUnitParamsRunner.*;
import static org.assertj.core.api.Assertions.*;

import data_setup.HeroOriginService;
import hero.Hero;
import hero.HeroOrigin;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JUnitParamsRunner.class)
public class ParameterizedTest {

    private HeroOriginService service = new HeroOriginService();

    @Test
    @Parameters({ "3, Krypton", "4, Gotham City" })
    public void find_hero_origin_by_id(int originId, String expectedOriginName) {
        HeroOrigin origin = service.findById(originId);

        assertThat(origin.getId()).isEqualTo(originId);
        assertThat(origin.getName()).isEqualTo(expectedOriginName);
    }

    @Test
    @Parameters(method = "heros")
    public void find_hero_origin_by_hero(Hero hero, HeroOrigin expectedOrigin) {
        HeroOrigin origin = service.findByHero(hero);

        assertThat(origin).isEqualTo(expectedOrigin);
    }

    public Object[] heros() {
        return $(
                $(new Hero().alias("Superman"), new HeroOrigin(3, "Krypton")),
                $(new Hero().alias("Batman"), new HeroOrigin(4, "Gotham City")));
    }

}
