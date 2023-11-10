package ar.edu.ubp.das.rest.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import ar.edu.ubp.das.rest.beans.EquipoBean;

@Repository
public class EquipoRepository {
	

    @Autowired
    private JdbcTemplate jdbcTpl;
    
	@SuppressWarnings("unchecked")
	public List<EquipoBean> getEquipos() {
    	SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
    	   .withProcedureName("get_equipos")
           .withSchemaName("dbo")
       	   .returningResultSet("equipos", BeanPropertyRowMapper.newInstance(EquipoBean.class));
       	
       	Map<String, Object> out = jdbcCall.execute();
       	return (List<EquipoBean>)out.get("equipos");
}
}
