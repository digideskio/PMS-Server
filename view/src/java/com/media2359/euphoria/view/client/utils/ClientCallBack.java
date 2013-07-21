package com.media2359.euphoria.view.client.utils;

public interface ClientCallBack {
	public static final int DELETE = 0;
	public static final int CANCEL = 0;
	public static final int ADD = 1;
	public static final int OK = 1;
	public static final int CONFIRM=1;
	
	
	
	public void confirmCallBackForDelete(int action);
	public void nameCallBackForAdding(int action, String name);
	public void addOrDeleteCallBackFromTree(int action);

}
