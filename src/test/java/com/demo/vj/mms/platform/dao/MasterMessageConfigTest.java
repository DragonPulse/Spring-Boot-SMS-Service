package com.demo.vj.mms.platform.dao;

import com.demo.mms.platform.dao.MasterMessageConfigRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;


@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class MasterMessageConfigTest {

    @Autowired
    private TestEntityManager entityManager;

//    @Autowired
//    MasterMessageConfigRepository messageConfigRepository;

    @Test
    public void testFindALl(){
        //Assert.notEmpty(messageConfigRepository.findByOwnerId("motp-gbdemo1"),"No Null");
    }
}
