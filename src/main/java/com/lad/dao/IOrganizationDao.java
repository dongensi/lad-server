package com.lad.dao;

import java.util.HashSet;
import java.util.List;

import com.lad.bo.OrganizationBo;
import com.mongodb.WriteResult;

public interface IOrganizationDao extends IBaseDao {
	public OrganizationBo insert(OrganizationBo organizationBo);
	public List<OrganizationBo> selectByTag(String tag, String sub_tag);
	public WriteResult updateUsers(String organizationBoId, HashSet<String> users);
	public WriteResult updateDescription(String organizationBoId, String description);
	public OrganizationBo get(String organizationBoId);
	public WriteResult updateUsersApply(String organizationBoId, HashSet<String> usersApply);
	
}
