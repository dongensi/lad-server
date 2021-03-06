package com.lad.util;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

public class JPushUtil {

	private static String MASTER_SECRET = "db587bc126abddf27e548ecc";
	private static String APP_KEY = "d53e8d39d6df18e379bf5da4";
	public static String APPLY = "申请加我为好友";
	public static String AGREE_APPLY_FRIEND = "同意添加我为好友";
	public static String REFUSE_APPLY_FRIEND = "拒绝添加我为好友";
	public static String MULTI_INSERT = "邀请我加入群聊";

	public static void pushAll(String content) {
		JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null,
				ClientConfig.getInstance());
		PushPayload payload = buildPushObject_all_alias_alert(content);
		try {
			PushResult result = jpushClient.sendPush(payload);
			System.out.println("Got result - " + result);

		} catch (APIConnectionException e) {
			System.out.println("Connection error, should retry later : "
					+ e.getMessage());

		} catch (APIRequestException e) {
			System.out
					.println("Should review the error, and fix the request : "
							+ e.getMessage());
			System.out.println("HTTP Status: " + e.getStatus());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Error Message: " + e.getErrorMessage());
		}
	}

	public static PushPayload buildPushObject_all_alias_alert(String content) {
		return PushPayload.newBuilder().setPlatform(Platform.all())
				.setNotification(Notification.alert(content)).build();
	}

	public static void pushTo(String content, String... alias) {
		JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null,
				ClientConfig.getInstance());
		PushPayload payload = buildPushObject_to_alias_alert(content, alias);
		System.out.println("alias: " + alias);
		try {
			PushResult result = jpushClient.sendPush(payload);
			System.out.println("Got result - " + result);

		} catch (APIConnectionException e) {
			System.out.println("Connection error, should retry later : "
					+ e.getMessage());

		} catch (APIRequestException e) {
			System.out
					.println("Should review the error, and fix the request : "
							+ e.getMessage());
			System.out.println("alias: " + alias);
			System.out.println("HTTP Status: " + e.getStatus());
			System.out.println("Error Code: " + e.getErrorCode());
			System.out.println("Error Message: " + e.getErrorMessage());
		}
	}

	public static PushPayload buildPushObject_to_alias_alert(String content,
			String... alias) {
		return PushPayload.newBuilder().setPlatform(Platform.all())
				.setAudience(Audience.alias(alias))
				.setNotification(Notification.alert(content)).build();
	}

	public static void main(String[] args) {
		JPushUtil.pushTo("Test from B","591e984231f0a5786e240f6c");
	}
}
