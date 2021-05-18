package repository;

import model.dto.Artist;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistMapper implements ResultSetMapper<Artist>
{
    @Override
    public Artist map(int i, ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Artist(
                resultSet.getInt("_id"),
                resultSet.getString("name")
        );
    }
}
