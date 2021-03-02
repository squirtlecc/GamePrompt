package cc.squirtle.entity

//val type: Int, val title: String
enum class ResType(val type: Int, val title: String) {

    SUCCESS(101, "&2[Success]"),  //绿色
    FAILED(401, "&4[Failed]"),  //红色
    NOTICE(201, "&6[Notice]"),  //黄色
    INFO(202, "&e[Info]"),  //金色
    NAME(203, "&a[%name%]"),  //浅绿
    UNAVAIL(301, "&8[Unavail]"),  //灰色
    RAINBOW(102, "");

//    constructor(type: Int, title: String){
//        this.title = title
//        this.type = type
//    }
//    constructor(type: Int, title: String,data : String){
//        this.title = title
//        this.type = type
//        this.data = data
//    }
//    constructor(data : String){
//        this.data = data
//    }
//    override fun toString():String {
//        return "[] ${this.title} ${this.data}"
//    }
//   fun setData(data: String?):ResType{
//        this.data = data?:""
//        return this
//    }
//
//    private var type: Int = 0
//    private var title: String = ""
//    private var data: String = ""

}