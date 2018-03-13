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

import com.demo.mms.platform.entity.MessageDetails;
import com.demo.mms.platform.models.GenericResponseJson;
import com.demo.mms.platform.models.MessageDetailsDTO;
import com.demo.mms.platform.service.MasterMessageConfigService;
import com.demo.mms.platform.service.MessageDetailsService;
import com.demo.mms.platform.service.MessageSubscriptionService;
import com.demo.mms.platform.util.DateUtil;

@RestController
public class MessageDetailsController {

    @Autowired
    MessageDetailsService messageDetailsService;

    @Autowired
    MasterMessageConfigService masterMessageConfigService;

    @Autowired
    MessageSubscriptionService messageSubscriptionService;

    @Autowired
    DateUtil dateUtil;



    @RequestMapping(value = "/findAllMessages",method = RequestMethod.GET)
    public List<MessageDetails> findAllMessagesByOwnerId(@Valid @RequestParam String ownerId){
        return messageDetailsService.findAllMessageDetailsByOwnerId(ownerId);
    }

    @RequestMapping(value = "/saveMessageDetails",method = RequestMethod.POST)
    public GenericResponseJson saveMessage(@Valid @RequestBody MessageDetailsDTO messageDetailsDTO){
        GenericResponseJson genericResponseJson;
        MessageDetails messageDetails = new MessageDetails();
        messageDetails.setMasterMessageConfig(masterMessageConfigService.findByMmcId(messageDetailsDTO.getMasterMessageConfigId()));
        messageDetails.setSubscriber(messageSubscriptionService.findById(messageDetailsDTO.getSubscriberId()));
        BeanUtils.copyProperties(messageDetailsDTO,messageDetails);
        messageDetails.setSentDate(dateUtil.getCurrentDate());
        if(messageDetailsService.saveMessageDetails(messageDetails)) {
            return new GenericResponseJson("success", HttpStatus.OK, "Record Saved Successfully");
        }else {
            return new GenericResponseJson("Failed", HttpStatus.EXPECTATION_FAILED, "Exception Occured");
        }
    }
}
