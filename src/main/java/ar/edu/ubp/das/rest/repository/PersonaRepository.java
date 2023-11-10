package ar.edu.ubp.das.rest.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ubp.das.rest.beans.ActividadBean;
import ar.edu.ubp.das.rest.beans.EquipoBean;
import ar.edu.ubp.das.rest.beans.PersonaBean;
import ar.edu.ubp.das.rest.beans.PersonaDataBean;

@SuppressWarnings("unused")
@Repository
public class PersonaRepository {

	@Autowired
	private JdbcTemplate jdbcTpl;

	@SuppressWarnings("unchecked")
	public List<PersonaDataBean> getPersona(String id) {

		SqlParameterSource in = new MapSqlParameterSource().addValue("id_persona", id);

		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl).withProcedureName("get_datos_persona").withSchemaName("dbo")
				.returningResultSet("persona", BeanPropertyRowMapper.newInstance(PersonaDataBean.class));

		Map<String, Object> out = jdbcCall.execute(in);
		return (List<PersonaDataBean>) out.get("persona");
	}
	
	   @SuppressWarnings("unchecked")
		public List<PersonaBean> getPersonas() {
	    	
	        SqlParameterSource in = new MapSqlParameterSource()
	                .addValue("string_busqueda", null);
	        
	    	SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
	    	   .withProcedureName("get_personas")
	           .withSchemaName("dbo")
	       	   .returningResultSet("personas", BeanPropertyRowMapper.newInstance(PersonaBean.class));
	       	
	       	Map<String, Object> out = jdbcCall.execute(in);
	       	return (List<PersonaBean>)out.get("personas");
	    }
	   
	   @Transactional
	    public PersonaDataBean insPersona(PersonaDataBean data) {
	   
	        SqlParameterSource in = new MapSqlParameterSource()
	           .addValue("apellido", data.getApellido())
	           .addValue("nombre", data.getNombre())
	           .addValue("clave", data.getClave())
	           .addValue("correo", data.getCorreo())
	           .addValue("cod_genero",data.getCodGenero())
	           .addValue("fecha_nacimiento",data.getFechaNacimiento())
	           .addValue("cod_nacionalidad",data.getCodNacionalidad())
	           .addValue("equipos",data.getEquipos())
	           .addValue("actividades",data.getActividades())
	           .addValue("otras_actividades", data.getOtrasActividades());
	        
	           
	        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTpl)
	           .withProcedureName("ins_persona")
	           .withSchemaName("dbo");
	        jdbcCall.execute(in);

	        return data;
	    }

}
