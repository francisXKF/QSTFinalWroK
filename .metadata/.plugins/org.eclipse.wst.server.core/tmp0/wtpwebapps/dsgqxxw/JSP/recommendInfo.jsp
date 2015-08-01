<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
        <title>Recommemd information</title>
        <style type="text/css">
            #recommendinfo-container{
                clear: both;
                width: 100%;
                height: 850px;
            }
            #recommendinfo-div-left{
                width: 45%;
                height: 150px;
                float: left;
            }
            #recommendinfo-div-right{
                width: 45%;
                height: 150px;
                float: left;
            }
            ul{
                list-style: none;
            }
             #li-ad{
                clear: both;
                height: 85px;
                background-image: url(../images/pcard2.jpg);
                background-repeat: no-repeat;
                background-size: cover;
            }
            #list-ad{
                margin-left: -50px;
                list-style: none;
            }
            .infotable-info{
                width: 100%;
            }
            .infotable-info td{
                width: 45%;
                height: 110px;
                border: 1px solid #fff;
            }
            .infotable-title{
                background-color: #0a957a;
                color: #fff;
            }
            .float-bottom{
                float: right;
                bottom: 0px;
            }
            #recommendinfo-div{
                width: 100%;
                height: 150px;
                background-color: #ccc;
                padding-top: 20px;
            }
            #infoTable-div{
                width: 100%;
                height: 470px;
                background-color: #ccc;
            }
            #recommendinfo-container ul{
                list-style: none;
                margin-left: -30px;
            }
            #recommendinfo-container span{
                color: #0e3295;
            }
            .li-div{
                 padding-top: 20px
             }
        </style>
    </head>
    <body>
        <div id="recommendinfo-container">
            <ul>
                <li class="li-div"><span>■推荐信息『缴费专区』</span><br>
                    <div id="recommendinfo-div">
                        <div id="recommendinfo-div-left">
                            <ul>
                                <li>『寻找启示』寻找启示标题</li>
                                <li>『车辆信息』车辆信息标题</li>
                                <li>『求职信息』求职信息标题</li>
                                <li>『招商引资』招商引资标题</li>
                                <li>『房屋信息』房屋信息标题</li>
                                <li>『招聘信息』招聘信息标题</li>
                            </ul>
                        </div>
                        <div id="recommendinfo-div-right">
                            <ul>
                                <li>『出售信息』出售信息标题</li>
                                <li>『家教信息』家教信息标题</li>
                                <li>『公寓信息』公寓信息标题</li>
                                <li>『求购信息』求购信息标题</li>
                                <li>『培训信息』培训信息标题</li>
                                <li>&nbsp;</li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li class="li-div">
                    <ol id="list-ad">
                        <li id="li-ad"></li>
                    </ol>
                </li>
                <li class="li-div"><span>■最新信息『免费专区』</span><br>
                    <div id="infoTable-div">
                        <table class="infotable-info">
                            <tr>
                                <td>
                                    <div class="infotable-title">▲招聘信息</div>
                                    <p>发布信息标题</p>
                                    <div class="float-bottom">更多...</div>
                                </td>
                                <td>
                                    <div class="infotable-title">▲培训信息</div>
                                    <p>发布信息标题</p>
                                    <div class="float-bottom">更多...</div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="infotable-title">▲公寓信息</div>
                                    <p>发布信息标题</p>
                                    <div class="float-bottom">更多...</div>
                                </td>
                                <td>
                                    <div class="infotable-title">▲求职信息</div>
                                    <p>发布信息标题</p>
                                    <div class="float-bottom">更多...</div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="infotable-title">▲家教信息</div>
                                    <p>发布信息标题</p>
                                    <div class="float-bottom">更多...</div>
                                </td>
                                <td>
                                    <div class="infotable-title">▲车辆信息</div>
                                    <p>发布信息标题</p>
                                    <div class="float-bottom">更多...</div>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <div class="infotable-title">▲出售信息</div>
                                    <p>发布信息标题</p>
                                    <div class="float-bottom">更多...</div>
                                </td>
                                <td>
                                    <div class="infotable-title">▲寻找信息</div>
                                    <p>发布信息标题</p>
                                    <div class="float-bottom">更多...</div>
                                </td>
                            </tr>
                        </table>
                    </div>
                </li>
            </ul>
        </div>
    </body>
</html>