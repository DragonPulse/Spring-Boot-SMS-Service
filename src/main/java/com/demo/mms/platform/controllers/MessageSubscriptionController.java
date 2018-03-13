package com.demo.mms.platform.controllers;

import com.demo.mms.platform.entity.MasterMessageConfig;
import com.demo.mms.platform.entity.MessageSubscription;
import com.demo.mms.platform.models.GenericResponseJson;
import com.demo.mms.platform.models.MasterMessageConfigDTO;
import com.demo.mms.platform.models.SubscriberDTO;
import com.demo.mms.platform.service.MessageSubscriptionService;
import com.demo.mms.platform.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
public class MessageSubscriptionController {

    @Autowired
    MessageSubscriptionService messageSubscriptionService;

    @Autowired
    DateUtil dateUtil;

    @RequestMapping(value = "/findSubscriptionByOwnerID",method = RequestMethod.GET)
    public List<MessageSubscription> findSubscriptionByOwnerId(@RequestParam String ownerID){
        return messageSubscriptionService.findAllSubscriptionByOwnerId(ownerID);
    }

    @RequestMapping(value="/subscribeToMessage",method=RequestMethod.POST)
    public GenericResponseJson subscribeToMessage(@Valid @RequestBody SubscriberDTO subscriberDTO){
        GenericResponseJson genericResponseJson;
        MasterMessageConfig messageConfig = new MasterMessageConfig();
        if(messageSubscriptionService.saveSubscriber(subscriberDTO)) {
            return new GenericResponseJson("success", HttpStatus.OK, "Record Saved Successfully");
        }else {
            return new GenericResponseJson("Failed", HttpStatus.EXPECTATION_FAILED, "Exception Occured");
        }
    }

    @RequestMapping(value = "/findSubscriberByDatesAndOwnerId",method=RequestMethod.GET)
    public List<MessageSubscription> findSubscriberByDatesAndOwnerId(@Valid @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date fromDate, @Valid @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date toDate, @Valid @RequestParam String ownerId){
        fromDate=dateUtil.getStartOfDay(fromDate);
        toDate = dateUtil.getEndOfDay(toDate);
        return messageSubscriptionService.findSubscriberByOwnerAndDate(fromDate,toDate,ownerId);
    }
}
