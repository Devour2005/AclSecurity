package com.cookie.dao.user;

import com.cookie.dao.AbstractDbManagerRepository;
import com.cookie.dao.UserFilter;
import com.cookie.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexander Kuidin on 029 29.10.17.
 */

@Getter(AccessLevel.PROTECTED)
@Repository
public class UserRepository
        extends AbstractDbManagerRepository<User, UserFilter>
        implements IUserRepository {

    private static final String USER_SELECTION = "SELECT * FROM users WHERE id = :id";
    private final DataSource dataSource;
//    private NamedParameterJdbcTemplate jdbcTemplate;
//    private JdbcTemplate jdbcTemplate2;
//    private final RowMapper<User> defaultRowMapper = new BeanPropertyRowMapper<>(User.class);


    @Autowired
    public UserRepository(DataSource dataSource) {
        this.dataSource = dataSource;
//        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
//        this.jdbcTemplate2 = new JdbcTemplate(dataSource);

    }


    /*Actor actor = this.jdbcTemplate.queryForObject(
            "select first_name, last_name from t_actor where id = ?",
            new Object[]{1212L},
            new RowMapper<Actor>() {
                public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Actor actor = new Actor();
                    actor.setFirstName(rs.getString("first_name"));
                    actor.setLastName(rs.getString("last_name"));
                    return actor;
                }
            });*/

    @Override
    public User findByFilter(UserFilter filter) {  //todo implement search by criteria
      /*  StringBuilder queryBuilder = new StringBuilder(USER_SELECTION);
        if (StringUtils.isNotEmpty(filter.getLogin())) {
            queryBuilder.append(" AND login = :login");
        }
        if (StringUtils.isNotEmpty(filter.getFirstName())) {
            queryBuilder.append(" AND first_name = :first_name");
        }
        if (StringUtils.isNotEmpty(filter.getLastName())) {
            queryBuilder.append(" AND last_name = :last_name");
        }
        if (StringUtils.isNotEmpty(filter.getEmail())) {
            queryBuilder.append(" AND email = :email");
        }
        return this.getJdbcTemplate2().queryForObject(queryBuilder.toString(), this.defaultRowMapper);*/

    /*    return this.getJdbcTemplate().query(queryBuilder.toString(),
                new BeanPropertySqlParameterSource(filter),
                this.defaultRowMapper);*/

        return null;
    }

    @Override
    public void insert(User user) {
     /*   String query = "INSERT INTO users (login, first_name, last_name, email, enabled) VALUES(?, ?, ?, ?, ?)";
        this.jdbcTemplate.update(query,
                new MapSqlParameterSource(this.getQueryParameters(user)));*/
    }

    @Override
    public void update(User user) {
        String query = "UPDATE users VALUES(?, ?, ?, ?, ? WHERE id = :id";
//        this.jdbcTemplate.update(query, this.getQueryParameters(user));
    }

    @Override
    public void delete(long id) {
        String query = "DELETE FROM users WHERE id = :id";
        Map<String, Object> queryParameters = new HashMap<>();
        queryParameters.put("id", id);
//        this.jdbcTemplate.update(query, queryParameters);
    }

    private Map<String, Object> getQueryParameters(User user) {
        Map<String, Object> queryParameters = new HashMap<>();
        if (user.getId() != null) {
            queryParameters.put("id", user.getId());
        }
        queryParameters.put("login", user.getLogin());
        queryParameters.put("first_name", user.getFirstName());
        queryParameters.put("last_name", user.getLastName());
        queryParameters.put("email", user.getEmail());
        queryParameters.put("enabled", user.isEnabled());
        return queryParameters;
    }
}
