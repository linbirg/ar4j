package sge.base.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

public class JdbcUtils {
	
	private final static Logger logger = LoggerFactory.getLogger(JdbcUtils.class);
	
	public enum JdbcSingleton{
		Instance;
		final private JdbcTemplate _jdbcTemplate;
		final private DataSourceTransactionManager _transactionManager;
		private JdbcSingleton()
		{
			ClassPathXmlApplicationContext applicationContext = null;
			applicationContext = ApplicationBeans.App.getApp();
			
			if (applicationContext == null) {
				_jdbcTemplate = null;
				_transactionManager = null;
			}else {
				_jdbcTemplate = (JdbcTemplate)applicationContext.getBean("jdbcTemplate");
				_transactionManager =(DataSourceTransactionManager)
						applicationContext.getBean("transactionManager");
			}
		}
		
		public JdbcTemplate getJdbcTemplate() {
			return _jdbcTemplate;
		}
		
		public DataSourceTransactionManager getTransactionManager() {
			return _transactionManager;
		}
	}
	
	public enum ApplicationBeans{
		App;
		final private ClassPathXmlApplicationContext _applicationContext;
		
		private ApplicationBeans(){
			_applicationContext = loadApplicationContext();
		}
		
		private ClassPathXmlApplicationContext loadApplicationContext() {
			ClassPathXmlApplicationContext applicationContext = null;
			try {
				long minisec = System.currentTimeMillis();
				applicationContext = new ClassPathXmlApplicationContext(
						"/application-context.xml");
				minisec = System.currentTimeMillis() - minisec;
				logger.debug("加载ClassPathXmlApplicationContext成功");
				logger.debug(String.format("加载ApplicationContext用时:%dms",minisec));
			} catch (BeansException e) {
				logger.debug("加载ClassPathXmlApplicationContext失败",e);
			}
			
			return applicationContext;
		}
		
		public ClassPathXmlApplicationContext getApp() {
			return _applicationContext;
		}
	}
	
	//static JdbcTemplate jdbcTemplate = null;
	
	
	/**
	 * 私有化构造函数，禁止初始化.
	 * */
	private JdbcUtils(){};

}
