package repository;

import model.dto.Artist;
import model.dto.Order;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(value=ArtistMapper.class)
public interface ArtistDao
{
    @SqlQuery("Select * from artists")
    public List<Artist> getAllArtists();

    @SqlUpdate("insert into artists(name) values(:name)")
    @GetGeneratedKeys
    public Integer addArtist(@BindBean Artist artist);
}
