package project_ifrill.service;

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
public class WorkerServiceTest {
	protected static final Log log = LogFactory.getLog(WorkerServiceTest.class);

	@Autowired
	private WorkerService service;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void testWorkerCheck() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다
		
		Worker worker = new Worker();
		
		worker.setId("PINKSUNG");
		worker.setPwd("PINKSUNG");
		
		int res = service.workerCheck(worker);
		Assert.assertEquals(1, res);
		
		log.debug(worker.toString());
	}

}
