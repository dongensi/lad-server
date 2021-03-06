package com.lad.service;

import com.lad.bo.HomepageBo;

public interface IHomepageService extends IBaseService {
	public HomepageBo insert(HomepageBo homepageBo);

	public HomepageBo update_new_visitors_count(HomepageBo homepageBo);

	public HomepageBo update_total_visitors_count(HomepageBo homepageBo);

	public HomepageBo update_visitor_ids(HomepageBo homepageBo);

	public HomepageBo selectByUserId(String userId);
}
