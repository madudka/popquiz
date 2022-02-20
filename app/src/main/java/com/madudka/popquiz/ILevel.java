package com.madudka.popquiz;

public interface ILevel {
    String getFileName();
    int getTextLevel();
    int getPrevTextLvl();
    int getEndTextLvl();
    int getPrevImgId();
    int getPrevTextTheme();
}

class LevelHelper{
    static ILevel getLevelObject(int numLevel){
        switch (numLevel){
            default:
            case 1: return new Level1();
            case 2: return new Level2();
            case 3: return new Level3();
            case 4: return new Level4();
            case 5: return new Level5();
            case 6: return new Level6();
            case 7: return new Level7();
            case 8: return new Level8();
            case 9: return new Level9();
            case 10: return new Level10();
            case 11: return new Level11();
            case 12: return new Level12();
            case 13: return new Level13();
            case 14: return new Level14();
            case 15: return new Level15();
            case 16: return new Level16();
            case 17: return new Level17();
            case 18: return new Level18();
            case 19: return new Level19();
            case 20: return new Level20();
            case 21: return new Level21();
            case 22: return new Level22();
            case 23: return new Level23();
            case 24: return new Level24();
            case 25: return new Level25();
            case 26: return new Level26();
            case 27: return new Level27();
            case 28: return new Level28();
            case 29: return new Level29();
            case 30: return new Level30();
        }
    }
}

class Level1 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_1.json";
    }

    @Override
    public int getTextLevel() { return R.string.level1; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_1_6_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl1_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_one; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl1_theme; }
}

class Level2 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_2.json";
    }

    @Override
    public int getTextLevel() { return R.string.level2; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_2_7_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl2_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_two; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl2_theme; }
}

class Level3 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_3.json";
    }

    @Override
    public int getTextLevel() { return R.string.level3; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_3_8_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl3_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_three; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl3_theme; }
}

class Level4 implements ILevel{
    @Override
    public String getFileName() { return "questions_4.json"; }

    @Override
    public int getTextLevel() { return R.string.level4; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_4_9_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl4_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_four; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl4_theme; }
}

class Level5 implements ILevel{
    @Override
    public String getFileName() { return "questions_5.json"; }

    @Override
    public int getTextLevel() { return R.string.level5; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_5_0_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl5_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_five; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl5_theme; }
}

class Level6 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_6.json";
    }

    @Override
    public int getTextLevel() { return R.string.level6; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_1_6_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl6_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_six; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl6_theme; }
}

class Level7 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_7.json";
    }

    @Override
    public int getTextLevel() { return R.string.level7; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_2_7_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl7_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_seven; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl7_theme; }
}

class Level8 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_8.json";
    }

    @Override
    public int getTextLevel() { return R.string.level8; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_3_8_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl8_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_eight; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl8_theme; }
}

class Level9 implements ILevel{
    @Override
    public String getFileName() { return "questions_9.json"; }

    @Override
    public int getTextLevel() { return R.string.level9; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_4_9_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl9_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_nine; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl9_theme; }
}

class Level10 implements ILevel{
    @Override
    public String getFileName() { return "questions_10.json"; }

    @Override
    public int getTextLevel() { return R.string.level10; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_5_0_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl10_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_ten; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl10_theme; }
}

class Level11 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_11.json";
    }

    @Override
    public int getTextLevel() { return R.string.level11; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_1_6_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl10_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_eleven; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl11_theme; }
}

class Level12 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_12.json";
    }

    @Override
    public int getTextLevel() { return R.string.level12; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_2_7_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl12_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_twelve; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl12_theme; }
}

class Level13 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_13.json";
    }

    @Override
    public int getTextLevel() { return R.string.level13; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_3_8_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl13_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_thirteen; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl13_theme; }
}

class Level14 implements ILevel{
    @Override
    public String getFileName() { return "questions_14.json"; }

    @Override
    public int getTextLevel() { return R.string.level14; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_4_9_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl14_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_fourteen; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl14_theme; }
}

class Level15 implements ILevel{
    @Override
    public String getFileName() { return "questions_15.json"; }

    @Override
    public int getTextLevel() { return R.string.level15; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_5_0_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl15_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_fifteen; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl15_theme; }
}

class Level16 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_16.json";
    }

    @Override
    public int getTextLevel() { return R.string.level16; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_1_6_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl16_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_sixteen; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl16_theme; }
}

class Level17 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_17.json";
    }

    @Override
    public int getTextLevel() { return R.string.level17; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_2_7_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl17_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_seventeen; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl17_theme; }
}

class Level18 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_18.json";
    }

    @Override
    public int getTextLevel() { return R.string.level18; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_3_8_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl18_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_eighteen; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl18_theme; }
}

class Level19 implements ILevel{
    @Override
    public String getFileName() { return "questions_19.json"; }

    @Override
    public int getTextLevel() { return R.string.level19; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_4_9_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl19_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_nineteen; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl19_theme; }
}

class Level20 implements ILevel{
    @Override
    public String getFileName() { return "questions_20.json"; }

    @Override
    public int getTextLevel() { return R.string.level20; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_5_0_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl20_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_twenty; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl20_theme; }
}

class Level21 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_21.json";
    }

    @Override
    public int getTextLevel() { return R.string.level21; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_1_6_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl21_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_twenty_one; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl21_theme; }
}

class Level22 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_22.json";
    }

    @Override
    public int getTextLevel() { return R.string.level22; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_2_7_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl22_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_twenty_two; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl22_theme; }
}

class Level23 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_23.json";
    }

    @Override
    public int getTextLevel() { return R.string.level23; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_3_8_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl23_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_twenty_three; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl23_theme; }
}

class Level24 implements ILevel{
    @Override
    public String getFileName() { return "questions_24.json"; }

    @Override
    public int getTextLevel() { return R.string.level24; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_4_9_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl24_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_twenty_four; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl24_theme; }
}

class Level25 implements ILevel{
    @Override
    public String getFileName() { return "questions_25.json"; }

    @Override
    public int getTextLevel() { return R.string.level25; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_5_0_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl25_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_twenty_five; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl25_theme; }
}

class Level26 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_26.json";
    }

    @Override
    public int getTextLevel() { return R.string.level26; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_1_6_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl26_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_twenty_six; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl26_theme; }
}

class Level27 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_27.json";
    }

    @Override
    public int getTextLevel() { return R.string.level27; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_2_7_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl27_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_twenty_seven; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl27_theme; }
}

class Level28 implements ILevel{
    @Override
    public String getFileName() {
        return "questions_28.json";
    }

    @Override
    public int getTextLevel() { return R.string.level28; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_3_8_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl28_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_twenty_eight; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl28_theme; }
}

class Level29 implements ILevel{
    @Override
    public String getFileName() { return "questions_29.json"; }

    @Override
    public int getTextLevel() { return R.string.level29; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_4_9_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl29_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_twenty_nine; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl29_theme; }
}

class Level30 implements ILevel{
    @Override
    public String getFileName() { return "questions_30.json"; }

    @Override
    public int getTextLevel() { return R.string.level30; }

    @Override
    public int getPrevTextLvl() { return R.string.lvl_5_0_start; }

    @Override
    public int getEndTextLvl() { return R.string.lvl30_end; }

    @Override
    public int getPrevImgId() { return R.drawable.preview_image_thirty; }

    @Override
    public int getPrevTextTheme() { return R.string.lvl30_theme; }
}