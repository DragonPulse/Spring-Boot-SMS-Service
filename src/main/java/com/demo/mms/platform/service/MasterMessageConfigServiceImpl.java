package com.demo.mms.platform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.mms.platform.dao.MasterMessageConfigRepository;
import com.demo.mms.platform.entity.MasterMessageConfig;
import com.demo.mms.platform.util.DateUtil;

@Service
public class MasterMessageConfigServiceImpl implements MasterMessageConfigService {

	@Autowired
	MasterMessageConfigRepository masterMessageConfigRepository;
	
	@Autowired
	DateUtil dateUtil;
	 
	@Override
	public List<MasterMessageConfig> findByOwnerId(String ownerId) {
		// TODO Auto-generated method stub
		return masterMessageConfigRepository.findByOwnerId(ownerId);
	}

	@Override
	public boolean save(MasterMessageConfig masterMessageConfig) {
		// TODO Auto-generated method stub
		return masterMessageConfigRepository.save(masterMessageConfig) != null;
	}

	@Override
	public MasterMessageConfig findDistinctByOwnerIdAndMsgType(String ownerId, String msgType) {
		return masterMessageConfigRepository.findDistinctByOwnerIdAndAndMsgType(ownerId,msgType);
	}

	@Override
	public MasterMessageConfig findByMmcId(Long mmcId) {
		return masterMessageConfigRepository.findByMmcId(mmcId);
	}


}
