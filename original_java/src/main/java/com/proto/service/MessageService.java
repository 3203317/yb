package com.proto.service;

import java.util.List;

import com.proto.model.Message;

/**
 *
 * @author Administrator
 *
 */
public interface MessageService extends IService<Message> {

	List<Message> findByMessage(Message message, int page, int rows);
}
