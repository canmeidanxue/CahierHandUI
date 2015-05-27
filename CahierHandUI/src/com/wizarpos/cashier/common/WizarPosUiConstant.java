package com.wizarpos.cashier.common;

public class WizarPosUiConstant {
	public final static String SCAN_SKIT_TYPE = "ActionType";
	public final static int SCAN_ITEM_ACTIVATE = 10000;
	public final static int SCAN_ITEM_QUERY = 100006;
	public final static int SCAN_ITEM_SALE = 10007;
	/** 券使用*/
	public final static int SCAN_ITEM_USE_TICKET = 10002;
	/** 充值*/
	public final static int SCAN_ITEM_RECHARGE = 10001;
	/** 券发行*/
	public final static int SCAN_ITEM_TICKET_PUBLIC = 10003;
	/** 积分赠送*/
	public final static int SCAN_ITEM_POINT_PUBLISH = 10004;
	/** 积分使用*/
	public final static int SCAN_ITEM_POINT_USE = 10005;
	
	
	/** 赠送积分*/
	public final static String SCORE_PUBLISH_TYPE = "1";
	/** 使用积分*/
	public final static String SCORE_USE_TYPE = "2";
	
	public final static String CARD_NO = "CardNo";
	
	public final static String SWIPE_TYPE_TAG = "swipeType";
	public final static String NET_STATE = "netState";
	public final static int SWIPE_TYPE_CONTACTLESS = 1;
	public final static int SWIPE_TYPE_SCANQRCODE = 2;
	public final static int SWIPE_TYPE_SWIPCARD = 3;
	public final static int SWIPE_TYPE_INPUTBYHAND = 4;
	
	public final static String TRAN_LOG_RECHARGE = "会员卡充值";
	public final static String TRAN_LOG_SALE = "会员卡消费";
	public final static String TRAN_LOG_UNDO = "会员卡交易撤销";
	public final static String TRAN_LOG_USE_TICKET = "券使用";
}
