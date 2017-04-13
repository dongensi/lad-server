package com.junlenet.mongodb.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junlenet.mongodb.demo.bo.ThumbsupBo;
import com.junlenet.mongodb.demo.dao.IThumbsupDao;
import com.junlenet.mongodb.demo.service.IThumbsupService;

@Service("thumbsupService")
public class ThumbsupService implements IThumbsupService {

	@Autowired
	private IThumbsupDao thumbsupDao;
	
	public ThumbsupBo insert(ThumbsupBo thumbsupBo) {
		return thumbsupDao.insert(thumbsupBo);
	}

	public List<ThumbsupBo> selectByOwnerId(String ownerId) {
		return thumbsupDao.selectByOwnerId(ownerId);
	}

	public List<ThumbsupBo> selectByVisitorId(String visitorId) {
		return thumbsupDao.selectByVisitorId(visitorId);
	}

}