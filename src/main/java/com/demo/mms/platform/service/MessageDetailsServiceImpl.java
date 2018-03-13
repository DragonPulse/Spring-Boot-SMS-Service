package com.demo.mms.platform.service;

import com.demo.mms.platform.dao.MessageDetailsRepository;
import com.demo.mms.platform.entity.MessageDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageDetailsServiceImpl implements MessageDetailsService{

    @Autowired
    MessageDetailsRepository messageDetailsRepository;

    @Override
    public List<MessageDetails> findAllMessageDetailsByOwnerId(String ownerId) {
        return messageDetailsRepository.findByMasterMessageConfigOwnerId(ownerId);
    }

    @Override
    public MessageDetails findById(Long id) {
        return messageDetailsRepository.findById(id);
    }

    @Override
    public Boolean saveMessageDetails(MessageDetails messageDetails) {
        return messageDetailsRepository.save(messageDetails)!=null;
    }
}
