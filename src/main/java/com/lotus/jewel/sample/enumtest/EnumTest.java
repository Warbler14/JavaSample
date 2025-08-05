package com.lotus.jewel.sample.enumtest;

import java.util.ArrayList;
import java.util.List;

public class EnumTest {

	public static enum ScServerApi {

		/**
		 * ALL
		 */
		ALL("*"),
		/**
		 * GET_CONNECTED_CONNECTION_CLIENT_LIST
		 */
		GET_CONNECTED_CONNECTION_CLIENT_COUNT("getConnectedConnectionClientCount"),
		/**
		 * GET_CONNECTED_CONNECTION_CLIENT_LIST
		 */
		GET_CONNECTED_CONNECTION_CLIENT_LIST("getConnectedConnectionClientList"),
		/**
		 * GET_CONNECTION_CLIENT_COUNT
		 */
		GET_CONNECTION_CLIENT_COUNT("getConnectionClientCount"),
		/**
		 * GET_CONNECTION_CLIENT_HISTORY_LIST
		 */
		GET_CONNECTION_CLIENT_HISTORY_LIST("getConnectionClientHistoryList"),
		/**
		 * POST_NOTIFICATION_TO_CLIENT
		 */
		POST_NOTIFICATION_TO_CLIENT("postNotificationToClient"),
		/**
		 * GET_CONNECTION_CLIENT_HISTORY_COUNT_LIST_FOR_BILL
		 */
		GET_CONNECTION_CLIENT_HISTORY_COUNT_LIST_FOR_BILL("getConnectionClientHistoryCountListForBill"),
		/**
		 * GET_CONNECTION_CLIENT_HISTORY_LIST_FOR_BILL
		 */
		GET_CONNECTION_CLIENT_HISTORY_LIST_FOR_BILL("getConnectionClientHistoryListForBill"),
		/**
		 * GET_CONNECTION_CLIENT_HISTORY_ALL_LIST_FOR_BILL
		 */
		GET_CONNECTION_CLIENT_HISTORY_ALL_LIST_FOR_BILL("getConnectionClientHistoryAllListForBill");

		/**
		 * API
		 */
		private final String api;

		/**
		 * ScServerApi 생성자입니다.
		 */
		private ScServerApi(String api) {
			this.api = api;
		}

		/**
		 * API 를 가져옵니다.
		 *
		 * @return API
		 */
		public String getApi() {
			return api;
		}

		/**
		 * ScServerApi 의 목록을 가져옵니다.
		 *
		 * @return API 목록
		 */
		public static List<String> getApiList() {
			List<String> returnVal = new ArrayList<String>();
			for (ScServerApi scServerApi : ScServerApi.values()) {
				returnVal.add(scServerApi.getApi());
			}
			return returnVal;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(   ScServerApi.ALL.toString() );
		System.out.println(   ScServerApi.ALL.getApi() );
	}
}
