package cc.squirtle.Entity;

public enum ResType {
    SUCCESS(101,"&2[Success]"), //绿色
    FAILED(401,"&4[Failed]"), //红色
    NOTICE(201,"&6[Notice]"), //黄色
    INFO(202,"&e[Info]"), //金色
    NAME(203, "&a[%name%]"), //浅绿
    UNAVAIL(301,"&8[Unavail]"), //灰色
    RAINBOW(102, "");
    
    private int type;
    private String title;
    
    private ResType(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }
}
