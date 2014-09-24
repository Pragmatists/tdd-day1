package hero;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.List;
import java.util.Map;

public class Hero {

    private String alias;
    private String realFirstName;
    private String realLastName;
    private HeroOrigin origin;
    private List<String> symbols;
    public int numberOfFightsWon;
    private int power;
    private String weapon;
    private int health = 1;
    private String organization;

    public String getAlias() {
        return alias;
    }

    public Hero alias(String alias) {
        this.alias = alias;
        return this;
    }

    public String getRealFirstName() {
        return realFirstName;
    }

    public Hero realFirstName(String realFirstName) {
        this.realFirstName = realFirstName;
        return this;
    }

    public String getRealLastName() {
        return realLastName;
    }

    public Hero realLastName(String realLastName) {
        this.realLastName = realLastName;
        return this;
    }

    public HeroOrigin getOrigin() {
        return origin;
    }

    public Hero origin(HeroOrigin origin) {
        this.origin = origin;
        return this;
    }

    public List<String> getSymbols() {
        return symbols;
    }

    public Hero symbols(List<String> symbols) {
        this.symbols = symbols;
        return this;
    }

    public Hero power(int power) {
        this.power = power;
        return this;
    }

    public boolean fight(Hero opponent) {
        if(health == 0 ){
            throw new DeadException();
        }
        boolean won = this.power > opponent.power;
        if (won) {
            numberOfFightsWon++;
        }
        return won;
    }

    public boolean fight(Hero opponent, Map<String, String> fightContext) {
        if ("Superman".equals(this.alias) && "kryptonite".equals(opponent.weapon)) {
            return false;
        }
        if (this.power == opponent.power) {
            return "day".equals(fightContext.get("timeOfDay"));
        }
        return this.power > opponent.power;
    }

    public Hero weapon(String weapon) {
        this.weapon = weapon;
        return this;
    }

    public void inflictDamage(int damage) {
        if (damage > 5) {
            health--;
        }
    }

    public Hero health(int health) {
        this.health = health;
        return this;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return super.toString() + " [alias=" + alias + ", realFirstName=" + realFirstName + ", realLastName=" + realLastName + ", power=" + power
                + ", health=" + health + ", symbols=" + symbols+"]";
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public String sayHello() {
        return "Hello from " + getAlias();
    }

    public Hero organization(String organization) {
        this.organization = organization;
        return this;
    }

    public boolean isFromOrganization(String organization) {
        return this.organization.equals(organization);
    }

    public class DeadException extends RuntimeException {
    }
}
