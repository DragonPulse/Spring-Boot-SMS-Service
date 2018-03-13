package com.demo.mms.platform.service;

import com.demo.mms.platform.entity.MasterMessageConfig;
import com.demo.mms.platform.entity.MessageSubscription;
import com.demo.mms.platform.models.SubscriberDTO;

import java.util.Date;
import java.util.List;

public interface MessageSubscriptionService {

    List<MessageSubscription> findAllSubscriptionByOwnerId(String ownerId);

    MessageSubscription findById(Long id);

    boolean save(MessageSubscription messageSubscription);

    boolean saveSubscriber(SubscriberDTO subscriberDTO);

    List<MessageSubscription> findSubscriberByOwnerAndDate(Date fromDate, Date endDate, String ownerId);

}
