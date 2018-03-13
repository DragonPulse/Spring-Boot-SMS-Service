package com.demo.mms.platform.service;

import com.demo.mms.platform.entity.MessageDetails;

import java.util.List;

public interface MessageDetailsService {

    List<MessageDetails> findAllMessageDetailsByOwnerId(String ownerId);

    MessageDetails findById(Long id);

    Boolean saveMessageDetails(MessageDetails messageDetails);

}
