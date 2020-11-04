package project_ifrill.mapper;

import java.util.List;

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
import project_ifrill.dto.Address;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ControllerConfig.class })
public class AddressMapperTest {
	protected static final Log log = LogFactory.getLog(AddressMapperTest.class);

	@Autowired
	private AddressMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testSelectAddressByDong() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");	//getStackTrace는 메소드 이름이 나온다

		List<Address> list = mapper.selectAddressByDong("도곡1동");
		Assert.assertNotNull(list);
		list.forEach(address -> log.debug(address.toString()));
	}

}
