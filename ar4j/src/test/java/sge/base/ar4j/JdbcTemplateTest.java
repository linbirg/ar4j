package sge.base.ar4j;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import sge.base.utils.JdbcUtils;

public class JdbcTemplateTest {
	
	@Test
	public void test_jdbcTemplate_init()
	{
		JdbcTemplate jdbcTemplate = JdbcUtils.JdbcSingleton.Instance.getJdbcTemplate();
		
		Assert.assertNotNull(jdbcTemplate);
		
		Assert.assertEquals(1, jdbcTemplate.queryForInt("select count(*) from dual"));
	}

}
