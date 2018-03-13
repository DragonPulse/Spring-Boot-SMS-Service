package com.demo.mms.platform.controllers;

import com.demo.mms.platform.entity.MessageSubscription;
import com.demo.mms.platform.service.MessageSubscriptionService;
import com.demo.mms.platform.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DashboardReportController {

    @Autowired
    MessageSubscriptionService messageSubscriptionService;

    @Autowired
    DateUtil dateUtil;

    @RequestMapping(value="/getStatsReport",method = RequestMethod.GET)
    public Map<String,String> getStatsReport(@Valid @RequestParam String ownerId){
        Map<String,String> reportMap = new HashMap<>();
        Date fromDate = dateUtil.getStartOfDay(dateUtil.minusDays(dateUtil.getCurrentTimestamp(),1));
        Date tillDate = dateUtil.getEndOfDay(dateUtil.getCurrentTimestamp());
        List<MessageSubscription> messageSubscriptionList = messageSubscriptionService.findSubscriberByOwnerAndDate(fromDate,tillDate,ownerId);
        reportMap.put("recent_subscriber_count",((Integer)messageSubscriptionList.size()).toString());
        
        reportMap.put("recent_opt_outs",((Integer)3).toString());
       
        reportMap.put("total_message_sent",((Integer)25).toString());
        
        reportMap.put("total_message_failed",((Integer)0).toString());
        
        
        return reportMap;
    }



}
