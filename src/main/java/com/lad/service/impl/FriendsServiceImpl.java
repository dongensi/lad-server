package com.lad.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lad.bo.FriendsBo;
import com.lad.dao.IFriendsDao;
import com.lad.service.IFriendsService;
import com.mongodb.WriteResult;

@Service("friendsService")
public class FriendsServiceImpl implements IFriendsService {

	@Autowired
	private IFriendsDao friendsDao;
	
	public FriendsBo insert(FriendsBo friendsBo) {
		return friendsDao.insert(friendsBo);
	}

	public WriteResult updateBackname(String userid, String friendid, String backname) {
		return friendsDao.updateBackname(userid, friendid, backname);
	}

	public WriteResult updateTag(String userid, String friendid, List tag) {
		return friendsDao.updateTag(userid, friendid, tag);
	}

	public WriteResult updatePhone(String userid, String friendid, String phone) {
		return friendsDao.updatePhone(userid, friendid, phone);
	}

	public WriteResult updateDescription(String userid, String friendid, String description) {
		return friendsDao.updateDescription(userid, friendid, description);
	}

	public WriteResult updateVIP(String userid, String friendid, Integer VIP) {
		return friendsDao.updateVIP(userid, friendid, VIP);
	}

	public WriteResult updateBlack(String userid, String friendid, Integer black) {
		return friendsDao.updateBlack(userid, friendid, black);
	}

	public FriendsBo getFriendByIdAndVisitorId(String userid, String friendid) {
		return friendsDao.getFriendByIdAndVisitorId(userid, friendid);
	}
	
	public FriendsBo getFriendByIdAndVisitorIdAgree(String userid, String friendid) {
		return friendsDao.getFriendByIdAndVisitorIdAgree(userid, friendid);
	}

	public List<FriendsBo> getFriendByUserid(String userid) {
		return friendsDao.getFriendByUserid(userid);
	}

	public List<FriendsBo> getFriendByFriendid(String friendid) {
		return friendsDao.getFriendByFriendid(friendid);
	}

	public WriteResult delete(String userid, String friendid) {
		return friendsDao.delete(userid, friendid);
	}

	public WriteResult updateApply(String id, int apply) {
		return friendsDao.updateApply(id, apply);
	}

	public List<FriendsBo> getApplyFriendByuserid(String userid) {
		return friendsDao.getApplyFriendByuserid(userid);
	}

	public FriendsBo get(String id) {
		return friendsDao.get(id);
	}
	
	

}
