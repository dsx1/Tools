package kremniy.tools.dao;

import kremniy.tools.models.Mill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MillDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MillDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Mill> index(){
        return jdbcTemplate.query("SELECT * FROM mills", new BeanPropertyRowMapper<>(Mill.class));
    }

    public void save (Mill mill){
        jdbcTemplate.update("INSERT INTO mills VALUES(?,?,?,?,?,?)",
                mill.getMillId(),
                mill.getName(),
                mill.getDiameter(),
                mill.getNumberOfFlutes(),
                mill.getManufacturer(),
                mill.getVendorCode());
        Mill.setMillId(Mill.getMillId()+1);
    }

    public void update (int id, Mill updatedMill){
        jdbcTemplate.update("UPDATE mills SET name=?, diameter=?, numberofflutes=?, manufacturer=?, vendorcode=? WHERE id=?",
                updatedMill.getName(),
                updatedMill.getDiameter(),
                updatedMill.getNumberOfFlutes(),
                updatedMill.getManufacturer(),
                updatedMill.getVendorCode(),
                id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM mills WHERE id=?", id);
    }
}
