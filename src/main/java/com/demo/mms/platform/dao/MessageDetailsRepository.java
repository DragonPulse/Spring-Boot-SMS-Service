package com.demo.mms.platform.dao;

import com.demo.mms.platform.entity.MessageDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageDetailsRepository extends JpaRepository<com.demo.mms.platform.entity.MessageDetails,Long>{

    List<MessageDetails> findByMasterMessageConfigOwnerId(String ownerId);

    MessageDetails findById(Long id);


}
