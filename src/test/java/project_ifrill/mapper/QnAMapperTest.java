package project_ifrill.mapper;

import static org.junit.Assert.fail;

import java.util.List;

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
public class QnAMapperTest {
	protected static final Log log = LogFactory.getLog(QnAMapperTest.class);

	@Autowired
	private QnAMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void test01ListQna() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		List<QnA> list = mapper.listQna("one");
		Assert.assertNotNull(list);
		list.forEach(qna -> log.debug(qna.toString()));
	}

	@Test
	public void test02GetQnA() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다
		
		QnA qna = mapper.getQnA(2);
		Assert.assertNotNull(qna);
		log.debug(qna.toString());
	}

	@Test
	public void test03Insertqna() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다
		
//		SUBJECT, CONTENT, ID
		
		QnA qna = new QnA();
		qna.setSubject("테스트중입니다.");
		qna.setContent("테스트중이라 결과는 없습니다.");
		qna.setId("two");
		
		int res = mapper.insertqna(qna);
		
		Assert.assertEquals(1, res);
		
	}

	@Test
	public void test04ListAllQnA() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		List<QnA> list = mapper.listAllQnA();
		Assert.assertNotNull(list);
		list.forEach(qna -> log.debug(qna.toString()));
	}

	@Test
	public void test05UpdateQnA() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다
		/*
		 * UPDATE QNA SET REP=#{rep}, REP_YN='2' WHERE NO=#{no}
		 */
		QnA qna = new QnA();
		qna.setRep("테스트결과 입니다.");
		qna.setNo(3);
		int res = mapper.updateQnA(qna);
		Assert.assertEquals(1, res);
	}

}
