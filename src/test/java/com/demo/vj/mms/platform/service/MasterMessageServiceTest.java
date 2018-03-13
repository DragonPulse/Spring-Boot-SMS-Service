package com.demo.vj.mms.platform.service;

import com.demo.mms.platform.MessagingServiceApplication;
import com.demo.mms.platform.dao.MasterMessageConfigRepository;
import com.demo.mms.platform.service.MasterMessageConfigService;
import com.demo.mms.platform.service.MasterMessageConfigServiceImpl;
import com.demo.mms.platform.util.DateUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ActiveProfiles("AddressService-test")
@RunWith(SpringJUnit4ClassRunner.class)
public class MasterMessageServiceTest {


    @Mock
    MasterMessageConfigRepository masterMessageConfigRepository;

    @Mock
    MasterMessageConfigService masterMessageConfigService;

    @Mock
    DateUtil dateUtil;

    @Before
    public void setUp() {
        masterMessageConfigRepository = Mockito.mock(MasterMessageConfigRepository.class);
        masterMessageConfigService = Mockito.mock(MasterMessageConfigServiceImpl.class);
        dateUtil = Mockito.mock(DateUtil.class);
    }

    @Test
    public void testNotNull(){
        Assert.assertNotNull(masterMessageConfigRepository);
        Assert.assertNotNull(masterMessageConfigService);
        Assert.assertNotNull(dateUtil);
    }




}
