package Final_Exam.enums;

public enum ImagePath {
    	PLAY_BTN_NORMAL("src/resources/image/nonHoverBtnPlay.png"),
   	PLAY_BTN_HOVER("src/resources/image/hoverBtnPlay.png"),
    	SETTING_BTN_NORMAL("src/resources/image/nonHoverBtnSetting.png"),
    	SETTING_BTN_HOVER("src/resources/image/hoverBtnSetting.png"),
    	LOGO("src/resources/image/Logo.png"),
   	EASTEREGG("src/resources/image/easteregg.jpg");

    	private final String path;

    	ImagePath(String path) {
        	this.path = path;
    	}

    	public String getPath() {
        	return path;
    	}
}
