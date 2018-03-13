package com.demo.mms.platform.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mms.platform.entity.MasterMessageConfig;
import com.demo.mms.platform.models.GenericResponseJson;
import com.demo.mms.platform.models.MasterMessageConfigDTO;
import com.demo.mms.platform.service.MasterMessageConfigService;


@RestController
public class MessageConfigController {

	@Autowired
	MasterMessageConfigService masterMessageConfigService;
	
	@RequestMapping(value="/findConfigByOwnerId",method=RequestMethod.GET )
	public List<MasterMessageConfig> getAllMessageConfig(@RequestParam("ownerId") String ownerId){
		return masterMessageConfigService.findByOwnerId(ownerId);
	}

	@RequestMapping(value="/saveConfig",method=RequestMethod.POST)
	public GenericResponseJson saveMessgaeConfig(@Valid @RequestBody MasterMessageConfigDTO configDTO){
		GenericResponseJson genericResponseJson;
		MasterMessageConfig messageConfig = new MasterMessageConfig();
		BeanUtils.copyProperties(configDTO, messageConfig);
		if(masterMessageConfigService.save(messageConfig)) {
			return new GenericResponseJson("success", HttpStatus.OK, "Record Saved Successfully");
		}else {
			return new GenericResponseJson("Failed", HttpStatus.EXPECTATION_FAILED, "Exception Occured");
		}
		
		
	}
}
