package sge.base.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import sge.base.utils.JdbcUtils.JdbcSingleton;

public class BaseSpringDaoImpl<M> extends BaseSpringDao<M> {

	public BaseSpringDaoImpl(Class<M> modelClass) {
		super(modelClass);

		JdbcTemplate jdbcTemplate = JdbcSingleton.Instance.getJdbcTemplate();
		setJdbcTemplate(jdbcTemplate);
	}
}
