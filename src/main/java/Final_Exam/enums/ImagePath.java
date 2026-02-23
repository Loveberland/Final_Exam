package Final_Exam.enums;

public enum ImagePath {
    	PLAY_BTN_NORMAL("src/resources/image/nonHoverBtnPlay.png"),
   	PLAY_BTN_HOVER("src/resources/image/hoverBtnPlay.png"),
    	SETTING_BTN_NORMAL("src/resources/image/NonHovSetting.png"),
    	SETTING_BTN_HOVER("src/resources/image/HovSetting.png"),
    	LOGO("src/resources/image/Logo.png"),
   	EASTEREGG("src/resources/image/easteregg.jpg"),
	BACK_BTN_NORMAL("src/resources/image/NonHovBack.png"),
	BACK_BTN_HOVER("src/resources/image/HovBack.png"),
	SOUND_HOVER("src/resources/image/HovSound.png"),
	SOUND_NORMAL("src/resources/image/NonHovSound.png"),
	PAUSE("src/resources/image/PAUSE.png"),
	HERO("src/resources/image/Hero.png"),
	SUN("src/resources/image/Sun.png"),
	BG("src/resources/image/bg.png"),
	FIGHT_BG("src/resources/image/fightBg.png"),
	TOBE("src/resources/image/ToBeContinued.jpg");

    	private final String path;

    	ImagePath(String path) {
        	this.path = path;
    	}

    	public String getPath() {
        	return path;
    	}
}
