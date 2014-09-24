package data_setup;

import hero.Hero;
import hero.HeroOrigin;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HeroRowMapper {

    public Hero mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Hero().alias(rs.getString(1)).realFirstName(rs.getString(2)).realLastName(rs.getString(3))
                .origin(new HeroOrigin(rs.getInt(4), rs.getString(5)));
    }
}
