package data_setup;

import hero.Hero;
import hero.HeroOrigin;

public class HeroOriginService {

    public HeroOrigin findById(int originId) {
        if (originId == 3) {
            return new HeroOrigin(originId, "Krypton");
        }
        if (originId == 4) {
            return new HeroOrigin(originId, "Gotham City");
        }

        if (originId == 5) {
            return new HeroOrigin(originId, "Unknown");
        }
        return null;
    }

    public HeroOrigin findByHero(Hero hero) {
        if (hero.getAlias().equals("Superman")) {
            return new HeroOrigin(3, "Krypton");
        }
        if (hero.getAlias().equals("Batman")) {
            return new HeroOrigin(4, "Gotham City");
        }
        return null;
    }

}
