package project_ifrill.service;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import project_ifrill.config.ControllerConfig;
import project_ifrill.dto.QnA;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QnAServiceTest {
	protected static final Log log = LogFactory.getLog(QnAServiceTest.class);
	
	@Autowired
	private QnAService service;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void test03ListQna() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		ArrayList<QnA> list = service.listQna("one");
		Assert.assertNotNull(list);
		
		list.forEach(qna -> log.debug(qna.toString()));
	}

	@Test
	public void test04GetQnA() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		QnA qna = service.getQnA(1);
		Assert.assertNotNull(qna);

		log.debug(qna.toString());
	}

	@Test
	public void test01Insertqna() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		QnA qna = new QnA();
		qna.setSubject("집에서 테스트중입니다.");
		qna.setContent("집에서 테스트중이라 결과는 없네요.");
		qna.setId("one");
		
		int res = service.insertqna(qna);
		
		Assert.assertEquals(1, res);
	}

	@Test
	public void test05ListAllQnA() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		ArrayList<QnA> list = service.listAllQnA();
		Assert.assertNotNull(list);
		
		list.forEach(qna -> log.debug(qna.toString()));
	}

	@Test
	public void test02UpdateQnA() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		QnA qna = new QnA();
		qna.setRep("집에서 테스트결과 수정 중 입니다.");
		qna.setNo(23);
		int res = service.updateQnA(qna);
		Assert.assertEquals(1, res);
	}

}
