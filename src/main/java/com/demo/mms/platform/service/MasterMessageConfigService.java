package com.demo.mms.platform.service;

import java.util.List;

import com.demo.mms.platform.entity.MasterMessageConfig;

public interface MasterMessageConfigService {

	List<MasterMessageConfig> findByOwnerId(String ownerId);
	
	boolean save(MasterMessageConfig masterMEssageConfig);

	MasterMessageConfig findDistinctByOwnerIdAndMsgType(String ownerId, String msgType);

	MasterMessageConfig findByMmcId(Long mmcId);
}
