package com.demo.mms.platform.service;

import com.demo.mms.platform.dao.MessageSubscriptionRepository;
import com.demo.mms.platform.entity.MasterMessageConfig;
import com.demo.mms.platform.entity.MessageSubscription;
import com.demo.mms.platform.models.SubscriberDTO;
import com.demo.mms.platform.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageSubscriptionServiceImpl implements MessageSubscriptionService{


    @Autowired
    DateUtil dateUtil;

    @Autowired
    MessageSubscriptionRepository subscriptionRepository;

    @Autowired
    MasterMessageConfigService masterMessageConfigService;

    @Override
    public List<MessageSubscription> findAllSubscriptionByOwnerId(String ownerId) {
        return subscriptionRepository.findAllByMasterMessageConfig_OwnerId(ownerId);
    }

    @Override
    public boolean save(MessageSubscription messageSubscription) {
        return subscriptionRepository.save(messageSubscription)!=null;
    }

    @Override
    public boolean saveSubscriber(SubscriberDTO subscriberDTO) {
        MasterMessageConfig masterMessageConfig = new MasterMessageConfig();
        MessageSubscription subscription = new MessageSubscription();
        if(subscriberDTO.getMasterMessageConfigDTO().getId()!=null){
            subscription.setMasterMessageConfig(masterMessageConfigService.findByMmcId(subscriberDTO.getMasterMessageConfigDTO().getId()));
        }else if(subscriberDTO.getMessageType()!=null && subscriberDTO.getOwnerId()!=null){
            subscription.setMasterMessageConfig(masterMessageConfigService.findDistinctByOwnerIdAndMsgType(subscriberDTO.getOwnerId().toLowerCase(),subscriberDTO.getMessageType()));
        }else{
            return false;
        }
       // subscription.setMasterMessageConfig(masterMessageConfig);
        subscription.setToNumber(subscriberDTO.getToNumber());
        return subscriptionRepository.save(subscription)!=null;
    }

    @Override
    public List<MessageSubscription> findSubscriberByOwnerAndDate(Date fromDate, Date endDate, String ownerId) {
        return subscriptionRepository.findByCreatedDateIsBetweenAndMasterMessageConfigOwnerId(fromDate,endDate,ownerId);
    }

    @Override
    public MessageSubscription findById(Long id) {
        return subscriptionRepository.findById(id);
    }
}
