package project_ifrill.mapper;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import project_ifrill.config.ControllerConfig;
import project_ifrill.dto.Worker;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerConfig.class })
public class WorkerMapperTest {
	protected static final Log log = LogFactory.getLog(WorkerMapperTest.class);

	@Autowired
	private WorkerMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void testWorkerCheck() {
		Worker worker = new Worker();
		
		worker.setId("ADMIN");
		worker.setPwd("ADMIN");
		
		int res = mapper.workerCheck(worker);
		Assert.assertEquals(1, res);
		
	}

}
