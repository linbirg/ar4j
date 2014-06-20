package sge.base.ar4j;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import sge.base.dao.BaseSpringDaoImpl;
import sge.base.mock.TIPBPJob;
import sge.base.mock.TestTable;


public class ar4j {
	
	@Test
	public void test()
	{
		TIPBPJob job1 = new TIPBPJob();
		job1.setId(2);
		job1.setOutcome_id(100);
		job1.save();
		

		List<TIPBPJob> jobs = TIPBPJob.find_where(TIPBPJob.class,"where id = ?", 2);
		Assert.assertEquals(1, jobs.size());
		Assert.assertEquals(100, job1.getOutcome_id());
		
		job1.delete();
	}
	
	@Test
	public void test_pojo()
	{
		BaseSpringDaoImpl<TestTable> daoImpl = new BaseSpringDaoImpl<TestTable>(null);
		daoImpl.toString();
		//daoImpl.delete(null);
	}
}
