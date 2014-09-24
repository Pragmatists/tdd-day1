package hero;

import static com.google.common.collect.Lists.*;

import java.util.List;

public class HeroService {

    private HeroRepository heroRepository = new HeroRepository();
    private HeroContext heroContext =new HeroContext();

    public Hero getHero(int id) {
        return new Hero().alias("Superman").realFirstName("Clark").realLastName("Kent").origin(new HeroOrigin(87, "Krypton"))
                .symbols(newArrayList("blue costume", "red cape", "S-shield"));
    }

    public List<Hero> findByAliasPrefix(String s) {
        return newArrayList();
    }

    public boolean isFriendOfMine(Hero hero) {
        Hero foundHero = heroRepository.findByAlias(hero.getAlias());
        String currentHeroOrganization = heroContext.getCurrentHeroOrganization();
        return foundHero.isFromOrganization(currentHeroOrganization);
    }
}
