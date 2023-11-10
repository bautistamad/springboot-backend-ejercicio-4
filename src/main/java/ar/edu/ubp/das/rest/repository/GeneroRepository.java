package ar.edu.ubp.das.rest.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import ar.edu.ubp.das.rest.beans.GeneroBean;


@Repository
public class GeneroRepository {
	
   @Autowired
   private JdbcTemplate jdbcTpl;
   
   @SuppressWarnings("unchecked")
   public List<GeneroBean> getGeneros() {
	   SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
	    	   .withProcedureName("get_generos")
	           .withSchemaName("dbo")
	       	   .returningResultSet("generos", BeanPropertyRowMapper.newInstance(GeneroBean.class));
   
	   	Map<String, Object> out = jdbcCall.execute();
	  	return (List<GeneroBean>)out.get("generos");
   }
   

    
}
