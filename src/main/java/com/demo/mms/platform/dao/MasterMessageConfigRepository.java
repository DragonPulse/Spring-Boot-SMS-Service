package com.demo.mms.platform.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.mms.platform.entity.MasterMessageConfig;

public interface MasterMessageConfigRepository extends JpaRepository<MasterMessageConfig, Long> {

	List<MasterMessageConfig> findByOwnerId(String ownerId);

	MasterMessageConfig findDistinctByOwnerIdAndAndMsgType(String ownerId,String messageType);

	MasterMessageConfig findByMmcId(Long mmcId);



	
}
