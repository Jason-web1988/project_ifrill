package project_ifrill.service;

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
import project_ifrill.dto.Address;
import project_ifrill.dto.Member;
import project_ifrill.mapper.AddressMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberServiceTest {
	protected static final Log log = LogFactory.getLog(MemberServiceTest.class);
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private AddressMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Test
	public void test01ConfirmId() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		int res = service.confirmId("one");
		Assert.assertEquals(1, res);
	}

	@Test
	public void test02ShowAddressByDong() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		ArrayList<Address> list = mapper.selectAddressByDong("도곡1동");
		Assert.assertNotNull(list);
		
		list.forEach(address -> log.debug(address.toString()));
	}

	@Test
	public void test03JoinMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		Member member = new Member();
		member.setId("three");
		member.setPwd("1212");
		member.setName("최수정");
		member.setEmail("zzanggu1988@hanmail.net");
		member.setZipNum("123-456");
		member.setAddress("대구광역시 달서구 감삼동 우방드림");
		member.setPhone("010-9876-5432");
		
		int res = service.joinMember(member);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test04GetMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		Member getMember = service.getMember("three");
		Assert.assertNotNull(getMember);
		
		log.debug(getMember.toString());
	}

	@Test
	public void test05GetMemberList() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		
		ArrayList<Member> list = service.getMemberList("최수정");
		Assert.assertNotNull(list);
		
		list.forEach(member -> log.debug(member.toString()));
	}

}
