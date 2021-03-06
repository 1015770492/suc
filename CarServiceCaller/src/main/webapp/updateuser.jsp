<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/3/16
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>阳光好车</title>
    <link rel="stylesheet" type="text/css" href="css/base.css"/>
    <link rel="stylesheet" type="text/css" href="css/home.css"/>
    <link rel="stylesheet" type="text/css" href="css/hurst.css"/>
    <link rel="stylesheet" type="text/css" href="city/city.css">
    <script type="text/javascript" src="script/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="script/home_ban.js"></script>
    <script type="text/javascript" src="script/eg_top_search.js"></script>
    <script type="text/javascript" src="script/city.js"></script>
    <script type="text/javascript" src="script/snncar.js"></script>

    <script type="text/javascript">
        $(function(){
            $('.navmenu li').hover(function(){
                $('span',this).stop().css('height','2px');
                $('span',this).animate({
                    left:'0',
                    width:'100%',
                    right:'0'
                },200);
            },function(){
                $('span',this).stop().animate({
                    left:'50%',
                    width:'0'
                },200);
            });
        });
    </script>
    <!--导航登陆网页版下拉-->
    <script type="text/javascript">
        $(function () {
            var setTime;
            $(".egc-top .nav-cent .operate").hover(function () {
                var _this = $(this);
                setTime = setTimeout(function () {
                    _this.find(".sec-version").slideDown(200);
                    _this.find("i").removeClass("icon-angle-down").addClass("icon-angle-up");
                }, 200);
            }, function () {
                if (setTime) {
                    clearTimeout(setTime);
                }
                $(".egc-top .nav-cent .sec-version").slideUp(200);
                $(".egc-top .nav-cent .operate i").removeClass("icon-angle-up").addClass("icon-angle-down");
            });
        });
    </script>
    <!--底部信息下拉-->
    <script type="text/javascript">
        $(function () {
            var wind_wd = $(window).width();
            if(wind_wd<=735){
                /* $submenu.first().delay(400).slideDown(700);*/
                $('.relate .tit').on('click', function() {
                    $(this).next('.con').slideToggle()
                    $(this).parent().siblings('.items').find('.con').slideUp();
                });
            }else{
                $('.relate .tit').unbind("click");
                $('.relate .con').show();
            }
            $(window).resize(function(){
                var wind_wd = $(window).width();
                if(wind_wd<=735){
                    /* $submenu.first().delay(400).slideDown(700);*/
                    $('.relate .tit').on('click', function() {
                        $(this).next('.con').slideToggle()
                        $(this).parent().siblings('.items').find('.con').slideUp();
                    });
                }else{
                    $('.relate .tit').unbind("click");
                    $('.relate .con').show();
                }
            });
        });
    </script>
    <!--搜搜框获取焦点-->
    <script type="text/javascript">
        $(function () {
            $('.sea-ipt-txt').focus(function() {
                $(this).addClass("on");
                $('.search-btn').addClass("on");
            });
            $('.sea-ipt-txt').blur(function() {
                $(this).removeClass("on");
                $('.search-btn').removeClass("on");
            });
        });
    </script>
    <!--下拉导航关闭-->
    <script type="text/javascript">
        $(function () {
            $('.menu-mb i').click(function() {
                $(".navigation-mb-list").slideDown(300);
            });
            $('.navigation-mb-list .list-close-btn').click(function() {
                $(".navigation-mb-list").slideUp(300);
            });
        });
    </script>
    <!--stress搜索关闭-->
    <script type="text/javascript">
        $(function () {
            var setTime;
            $(".sercat .weixin").hover(function () {
                setTime = setTimeout(function () {
                    $(".sercat .wxewm").show();
                }, 300);
            }, function () {
                if (setTime) {
                    clearTimeout(setTime);
                }
                $(".sercat .wxewm").hide();
            });
        });
    </script>

    <script type="text/javascript">
        $(function () {
            var scroll_heitht = $('body').offset().top;
            var isShow = true;
            $(window).scroll(function () {
                if ($(window).scrollTop() > scroll_heitht && isShow) {
                    $('.stress-search-box').slideDown(200);
                }else{
                    $('.stress-search-box').slideUp(200);
                }
            });
            $('.stress-close a').click(function(){
                isShow=false;
                $('.stress-search-box').slideUp(200).unbind(window,aa);
            });
        });
    </script>
</head>
<body>
<c:if test="${sessionScope.loginuser!=null}">
<div class="egc-top">
    <div class="nav-cent">
        <div class="top-r"> <a href="#" id="b-regist">${sessionScope.loginuser.userName}</a>|<a href="/userController/nologin" id="b-login" class="b-login">退出</a> </div>
        <div class="top-l">全国统一客服热线：400-877-9288</div>
        <div class="clear_fix"></div>
    </div>
</div>
<div class="navigation">
    <div class="nav-cent">
        <div class="logo"><a href="index.jsp"><img src="images/logo.png" width="240" /></a></div>
        <div class="city"> <span id="DY_site_name" class="red city-name Left">合肥</span>
            <div id="JS_hide_city_menu_11" class="city-select cut_handdler Left"> <a href="javascript:void(0);" class="common-bg selector">切换城市</a>
                <div id="JS_header_city_bar_box" class="hide_city_group">
                    <div class="hideMap">
                        <div class="showPanel clearfix">
                            <div class="Left mycity">
                                <div id="JS_current_city_box"> 当前城市：<strong id="JS_city_current_city">合肥</strong> </div>
                                <div id="JS_default_city_delete" style="display: none;"></div>
                            </div>
                        </div>
                        <div class="showPanel showPanel2 clearfix">
                            <div class="hot_city" id="JS_header_city_hot"> </div>
                            <div class="city_words mt10" id="JS_header_city_char"> </div>
                        </div>
                        <div class="scrollBody">
                            <div class="cityMap clearfix">
                                <table id="JS_header_city_list" class="city_list" style="margin-top: 0px;">
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                            <div class="scrollBar"> <span id="JS_header_city_bar" style="margin-top: 0px;"></span> </div>
                        </div>
                    </div>
                </div>
            </div>
            <span class="common-bg city-logo"></span> </div>
        <div class="sea">
            <div class="egc-sea-box">
                <form action="/carinfoController/setKeys" method="get">
                    <input type="text" class="sea-ipt-txt" placeholder="搜索您想要的车" name="keys" />
                    <input type="submit" class="search-btn" value="搜索"></input>
                </form>
            </div>
        </div>
        <div class="hot-phone"> <i></i> <span class="js-change-phone">400-877-9288</span> </div>
    </div>
</div>
<ul class="navmenu">
    <li class="active"><a href="index.jsp">首页</a><span></span></li>
    <li><a href="cars.jsp">我要买车</a><span></span></li>
    <li><a href="#">我要卖车</a><span></span></li>
    <li><a href="#">阳光联盟</a><span></span></li>
    <li><a href="#">我要加盟</a><span></span></li>
</ul>
<div class="clear_fix"></div>
<div class="stress-search-box row">
    <div class="stress-close"><a href="javascript:;"></a></div>
    <div class="nav-cents">
        <ul>
            <li class="logo"><a href="index.jsp"><img src="images/logo.png"  width="180"/></a></li>
            <li><a href="index.jsp">首页</a></li>
            <li><a href="cars.jsp">我要买车</a></li>
            <li><a href="#">我要卖车</a></li>
            <li><a href="#">阳光联盟</a></li>
            <li><a href="#">我要加盟</a></li>
        </ul>
        <div class="seas">
            <div class="egc-sea-box">
                <form action="/carinfoController/setKeys" method="get">
                    <input type="text" class="sea-ipt-txt" placeholder="搜索您想要的车" name="keys" />
                    <input type="submit" class="search-btn" value="搜索"></input>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="clear_fix"></div>
<!--会员中心-->
<div class="mebBox">
    <div class="meb-cont clearfix mainbox">
        <div class="meb-nav fl dInline">
            <ul class="clearfix">
                <li><a href="yhcenter.jsp">会员中心</a></li>
                <li><a href="mycollect.jsp">我的收藏</a></li>
                <li><a href="myreserve.jsp">我的预约</a></li>
                <li class="on"><a href="updateuser.jsp">账户管理</a></li>
            </ul>
        </div>
        <div class="meb-right fr dInline">
            <div class="mr-top">
                <div class="mr-top-div clearfix">
        <span class="fl">
            <img src="images/photo.png">
        </span>
                    <div class="mr-infor fl dInline">
                        <h2>中午好，尊敬的会员 <b>${sessionScope.loginuser.userName}</b></h2>
                        <p>
                            手机：${sessionScope.loginuser.userTel}    |  [ <a href="updateuser.jsp">管理账户信息</a> ]
                        </p>
                    </div>
                </div>
            </div>
            <div class="mr-detail">
                <div class="mr-tab clearfix">
                    <a class="on">个人资料管理 </a>
                    <a>修改密码</a>
                </div>
                <div class="me-box me-box1">
                    <div class="me-dl" style="display:block;">
                        <div class="me-one">
                            <div class="accForm">
                                <form action="/userController/updateUser" enctype="multipart/form-data" name="editM" method="post" >
                                    <div class="afl clearfix">
                                        <label class="fl">
                                            手机号码
                                        </label>
                                        <div class="af-r fl dInline">
                                            <input type="text" class="ar-txt" name="userTel" id="userTel" placeholder="请输入手机号码" value="${sessionScope.loginuser.userTel}" readonly="readonly">
                                        </div>
                                    </div>
                                    <div class="afl clearfix">
                                        <label class="fl">
                                            姓名
                                        </label>
                                        <div class="af-r fl dInline">
                                            <input type="text" class="ar-txt" onblur="checkname()" name="userName" id="username" placeholder="请输入您的姓名" value="${sessionScope.loginuser.userName}"><span id="tip1"></span>
                                        </div>
                                    </div>
                                    <div class="afl clearfix">
                                        <label class="fl">
                                        </label>
                                        <div class="af-r fl dInline">
                                            <input type="submit" value="提 交" class="ar-btn" onclick="return checkup1()">
                                        </div>
                                    </div>
                                </form>
                                <script >
                                    function checkname() {
                                        var name=document.getElementById("username");
                                        if(name==""||name==null){
                                            return false;
                                            $("#tip1").html("用户名不能为空")
                                        }else{
                                            return true;
                                        }
                                    }
                                    function  checkup1 (){
                                        return checkname();
                                    }
                                </script>
                            </div>
                        </div>
                    </div>
                    <script>
                        var Ypass=/\S{6,}/;
                        var flag1=false;
                        function checkusertel1() {
                              var tel1=document.getElementById("userTel1").value;
                              var pwd1=document.getElementById("pwd1").value;
                              if(pwd1==""||pwd1==null||Ypass.test(pwd1)==false){
                                  $("#tip2").html("原密码密码不正确");
                                  return false;
                              }else {
                                  $.get("/userController/checkPwd",{userTel:tel1,userPwd:pwd1},function (data) {
                                    if(data=="ok"){
                                        $("#tip2").html("");
                                        flag1=true;
                                    }else{
                                        $("#tip2").html("原密码密码不正确");
                                        flag1=false;
                                    }
                                  });
                                  return true;
                              }
                        }
                        function newpwd1() {
                                var pwd2=document.getElementById("pwd2").value;
                                if(pwd2==""||pwd2==null||Ypass.test(pwd2)==false){
                                    $("#tip3").html("密码格式不正确，必须以字母开头的6-16 字母，数字");
                                    return false;
                                }else{
                                    $("#tip3").html("");
                                    return true;
                                }
                        }
                        function newpwd2() {
                            var pwd1=document.getElementById("pwd2").value;
                            var pwd2=document.getElementById("pwd3").value;
                            if(pwd1==pwd2){
                                $("#tip4").html("");
                                return true;
                            }else{
                                $("#tip4").html("请输入相同密码");
                                return false;
                            }
                        }
                        function checkuppwd() {
                          return flag1&checkusertel1()&newpwd1()&newpwd2();
                        }
                    </script>
                    <div class="me-dl" style="display:none;">
                        <div class="me-one">
                            <div class="accForm">
                                <form action="/userController/updatePwd" enctype="multipart/form-data" name="editP" method="post" >
                                    <div class="afl clearfix">
                                        <label class="fl">
                                            当前密码
                                        </label>
                                        <div class="af-r fl dInline">
                                            <input type="text" id="userTel1" value="${sessionScope.loginuser.userTel}"name="userTel" hidden="true">
                                            <input type="password" id="pwd1" class="ar-txt" name="password" placeholder="请输入当前密码" onblur="checkusertel1()"><span id="tip2"></span>
                                        </div>
                                    </div>
                                    <div class="afl clearfix">
                                        <label class="fl">
                                            新密码
                                        </label>
                                        <div class="af-r fl dInline">
                                            <input type="password" class="ar-txt" id="pwd2" name="userPwd" placeholder="请输入新密码" onblur="newpwd1()"><span id="tip3"></span>
                                        </div>
                                    </div>
                                    <div class="afl clearfix">
                                        <label class="fl">
                                            确认新密码
                                        </label>
                                        <div class="af-r fl dInline">
                                            <input type="password" class="ar-txt" id="pwd3" name="password2" placeholder="请确认输入的新密码" onblur="newpwd2()"><span id="tip4"></span>
                                        </div>
                                    </div>
                                    <div class="afl clearfix">
                                        <label class="fl">
                                        </label>
                                        <div class="af-r fl dInline">
                                            <input type="submit" value="提 交" class="ar-btn" onclick="return checkuppwd()">
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="clear_fix"></div>
<!--底部-->
<div class="ftWrap">
    <div class="foot">
        <div class="cent">
            <div class="relate">
                <div class="items">
                    <div class="tit"><i class="icon-angle-right"></i>交易帮助</div>
                    <div class="con"> <a href="#">买车帮助</a> <a href="#">卖车帮助</a> <a href="#">过户帮助</a> </div>
                </div>
                <div class="items">
                    <div class="tit"><i class="icon-angle-right"></i>客服中心</div>
                    <div class="con"> <a href="#">网站合作</a> <a href="#">关于我们</a> <a href="#">联系我们</a> </div>
                </div>
                <div class="items">
                    <div class="tit"><i class="icon-angle-right"></i>购车指南</div>
                    <div class="con"> <a href="#">购车帮助</a></div>
                </div>
                <div class="app-section"> <img class="js-delayed-img"  src="images/f_wx.jpg">
                    <div class="title">扫码关注微信</div>
                    <p> 随时随地，秒杀好车<br />
                        优质个人二手车 </p>
                </div>
                <div class="items last">
                    <div class="tel">
                        <h1>400-877-9288</h1>
                        <p>周一至周日 8:00-18:00</p>
                        <p>免费咨询(咨询、建议、投诉)</p>
                        <a href="#" class="kf"><i class="kf-icon"></i>在线客服</a> </div>
                    <div class="tel-mb">
                        <p><span>400-710-8886</span>周一至周日 8:00-18:00(仅收市话费)</p>
                        <a href="#" class="kf"><i class="kf-icon"></i>在线客服</a> </div>
                </div>
            </div>
        </div>
    </div>
    <div class="copyright">
        <div class="cent"> Copyright © 2016-2017, snncar.com,All Rights Reserved 皖ICP备16022456号-1</div>
    </div>
</div>
<script type="text/javascript" src="script/3c-menu.js"></script>
<script type="text/javascript" src="script/lg_reg.js"></script>
<!--会员登录和注册弹出框开始-->

<!--会员登录和注册弹出框结束-->
<script type="text/javascript">
    $(function(){
        $('.mr-tab a').each(function(index){
            $(this).click(function(){
                $(this).addClass('on').siblings().removeClass('on');
                $('.me-dl').eq(index).show().siblings().hide();
            })
        });
    })
</script>
</c:if>
<%--<c:if test="${sessionScope.loginuser==null}">--%>
    <%--<script >--%>
        <%--$(document).ready(function () {--%>
            <%--location.href="../index.jsp";--%>
        <%--});--%>
    <%--</script>--%>
<%--</c:if>--%>
</body>
</html>
