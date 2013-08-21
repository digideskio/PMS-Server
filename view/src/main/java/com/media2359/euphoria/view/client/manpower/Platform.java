package com.media2359.euphoria.view.client.manpower;

// just to show the converter feature
enum Platform {
	ANDROID("Android"), IOS("iOS"), RUBY("Ruby"), GRAILS(
			"Grails"), SERVER("Server"), UI("UI");
	static Platform parseString(String object) {
		if (Platform.ANDROID.toString().equals(object)) {
			return Platform.ANDROID;
		} else if (Platform.IOS.toString().equals(object)) {
			return Platform.IOS;
		} else if (Platform.RUBY.toString().equals(object)) {
			return Platform.RUBY;
		} else if (Platform.GRAILS.toString().equals(object)) {
			return Platform.GRAILS;
		} else if (Platform.UI.toString().equals(object)) {
			return Platform.UI;
		} else {
			return Platform.SERVER;
		}
	}

	private String text;

	Platform(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
