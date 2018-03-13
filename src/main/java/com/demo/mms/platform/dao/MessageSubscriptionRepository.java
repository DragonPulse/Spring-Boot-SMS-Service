package com.demo.mms.platform.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.mms.platform.entity.MessageSubscription;

public interface MessageSubscriptionRepository extends JpaRepository<MessageSubscription,Long>{
	
	List<MessageSubscription> findAllByMasterMessageConfig_OwnerId(String ownerId);

	List<MessageSubscription> findByCreatedDateIsBetweenAndMasterMessageConfigOwnerId(Date dateFrom, Date dateTill,String ownerId);

	MessageSubscription findById(Long id);
	
}
