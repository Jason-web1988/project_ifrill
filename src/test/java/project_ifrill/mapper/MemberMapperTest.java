package project_ifrill.mapper;

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
import project_ifrill.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberMapperTest {
	protected static final Log log = LogFactory.getLog(MemberMapperTest.class);

	@Autowired
	private MemberMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	

	@Test
	public void test02ConfirmID() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		int res = mapper.confirmID("one");
		Assert.assertEquals(1, res);
	}

	@Test
	public void test01GetMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다
		
		Member member = mapper.getMember("KNARI@TEST.CO.KR");
		Assert.assertNotNull(member);
		log.debug(member.toString());
	}

	@Test
	public void test03InsertMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다
		Member member = new Member();
		member.setId("two");
		member.setPwd("2222");
		member.setName("이현석");
		member.setEmail("dlgustjr1024@naver.com");
		member.setZipNum("704-130");
		member.setAddress("대구광역시 달서구 용산동 죽전우방");
		member.setPhone("010-1234-5678");
		
		int res = mapper.insertMember(member);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test04ListMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		List<Member> list = mapper.listMember("김나리");
		Assert.assertNotNull(list);
		list.forEach(member -> log.debug(member.toString()));
	}

}
