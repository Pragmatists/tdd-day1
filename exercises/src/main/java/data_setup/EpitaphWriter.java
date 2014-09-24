package data_setup;

import hero.Hero;
import hero.HeroOrigin;

public class EpitaphWriter {

    public String epitaphFor(Hero hero) {
        if (hero.getOrigin().equals(HeroOrigin.GERMANY)) {
            return hero.getAlias() + " ist tot";
        } else if (hero.getAlias() != null) {
            return hero.getAlias() + " is dead";
        } else {
            return hero.getRealFirstName() + " " + hero.getRealLastName() + " is dead";
        }
    }

}
