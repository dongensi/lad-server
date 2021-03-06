package com.lad.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.lad.bo.ChatroomBo;
import com.lad.dao.IChatroomDao;
import com.mongodb.WriteResult;

@Repository("chatroomDao")
public class ChatroomDaoImpl implements IChatroomDao {
	@Autowired
	private MongoTemplate mongoTemplate;

	public ChatroomBo insert(ChatroomBo chatroom) {
		mongoTemplate.insert(chatroom);
		return chatroom;
	}

	public ChatroomBo updateName(ChatroomBo chatroom) {
		Query query = new Query();
		query.addCriteria(new Criteria("_id").is(chatroom.getId()));
		query.addCriteria(new Criteria("deleted").is(0));
		Update update = new Update();
		update.set("name", chatroom.getName());
		mongoTemplate.updateFirst(query, update, ChatroomBo.class);
		return chatroom;
	}

	public ChatroomBo get(String chatroomId) {
		Query query = new Query();
		query.addCriteria(new Criteria("_id").is(chatroomId));
		query.addCriteria(new Criteria("deleted").is(0));
		return mongoTemplate.findOne(query, ChatroomBo.class);
	}

	public ChatroomBo updateUsers(ChatroomBo chatroom) {
		Query query = new Query();
		query.addCriteria(new Criteria("_id").is(chatroom.getId()));
		query.addCriteria(new Criteria("deleted").is(0));
		Update update = new Update();
		update.set("users", chatroom.getUsers());
		mongoTemplate.updateFirst(query, update, ChatroomBo.class);
		return chatroom;
	}

	public WriteResult delete(String chatroomId) {
		Query query = new Query();
		query.addCriteria(new Criteria("_id").is(chatroomId));
		query.addCriteria(new Criteria("deleted").is(0));
		Update update = new Update();
		update.set("deleted", 1);
		return mongoTemplate.updateFirst(query, update, ChatroomBo.class);
	}

	public ChatroomBo selectByUserIdAndFriendid(String userid, String friendid) {
		Query query = new Query();
		query.addCriteria(new Criteria("userid").is(userid));
		query.addCriteria(new Criteria("friendid").is(friendid));
		query.addCriteria(new Criteria("deleted").is(0));
		query.addCriteria(new Criteria("type").is(1));
		return mongoTemplate.findOne(query, ChatroomBo.class);
	}

	public ChatroomBo selectBySeq(int seq) {
		Query query = new Query();
		query.addCriteria(new Criteria("seq").is(seq));
		query.addCriteria(new Criteria("type").is(3));
		query.addCriteria(new Criteria("deleted").is(0));
		return mongoTemplate.findOne(query, ChatroomBo.class);
	}

	public WriteResult setSeqExpire(int seq) {
		Query query = new Query();
		query.addCriteria(new Criteria("seq").is(seq));
		query.addCriteria(new Criteria("type").is(3));
		query.addCriteria(new Criteria("deleted").is(0));
		Update update = new Update();
		update.set("expire", 0);
		return mongoTemplate.updateFirst(query, update, ChatroomBo.class);
	}

}
