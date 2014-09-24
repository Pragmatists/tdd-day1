package sql;

public class HeroQueryBuilder {


    private String heroTable = "Hero";
    private String heroAlias = "h";

    public String createSelectByOriginNameQuery(String originName) {
        return "SELECT " + heroAlias + " FROM " + heroTable + " " + heroAlias + " WHERE " + heroAlias + ".origin.name = '" + originName +
                "'";
    }
}
