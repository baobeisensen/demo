/*
* @Author: Larry
* @Date:   2016-12-15 17:20:54
* @Last Modified by:   qinsh
* @Last Modified time: 2016-12-24 21:51:08
* +----------------------------------------------------------------------
* | LarryBlogCMS [ LarryCMS网站内容管理系统 ]
* | Copyright (c) 2016-2017 http://www.larrycms.com All rights reserved.
* | Licensed ( http://www.larrycms.com/licenses/ )
* | Author: qinshouwei <313492783@qq.com>
* +----------------------------------------------------------------------
*/
var myChart = echarts.init(document.getElementById('larry-seo-stats'));
option = {
    title : {
        text: '用户访问来源',
        subtext: '纯属虚构',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
    },
    series : [
        {
            name: '访问来源',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:335, name:'直接访问'},
                {value:310, name:'邮件营销'},
                {value:234, name:'联盟广告'},
                {value:135, name:'视频广告'},
                {value:1548, name:'搜索引擎'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
myChart.setOption(option);
$(document).ready(function(){
    //获取电脑系统
    var os = GetOSInfo();
    $("#editionClient").text(os);
    //获取网站域名
    $("#host").text(window.location.host);
    //网站目录
    $("#path").text(window.location.pathname);
    //获取系统信息
    getSystemInfo();
    //获取数据库基本信息
    getDatabaseInfo();
    //获取访问量
    getVisitCount();
});

/*获取电脑系统*/
function GetOSInfo(){
    var _bit;
    var _pf=navigator.platform;
    var appVer=navigator.userAgent;
    if(_pf=="Win32" || _pf == "Windows")
    {
        if(appVer.indexOf("WOW64")>-1)
        {
            _bit = "64位";
        }
        else
        {
            _bit = "32位";
        }
        if(appVer.indexOf("Windows NT 6.0") > -1 || appVer.indexOf("Windows Vista") > -1)
        {
            if(_bit=='64位' || appVer.indexOf("Windows Vista") > -1)
            {
                return 'Windows_vista '+_bit;
            }
            else
            {
                return "Unknow1";
            }
        }
        else if(appVer.indexOf("Windows NT 6.1") > -1 || appVer.indexOf("Windows 7") > -1)
        {
            if(_bit=='32位' || appVer.indexOf("Windows 7") > -1)
            {
                return 'Windows_7 '+_bit;
            }
            else
            {
                return "Unknow";
            }
        }
        else
        {
            try
            {
                var _winName = Array('2000','XP','2003');
                var _ntNum = appVer.match(/Windows NT 5.\d/i).toString();
                return 'Windows_' + _winName[_ntNum.replace(/Windows NT 5.(\d)/i,"$1")]+" "+_bit;
            }
            catch(e)
            {
                return 'Windows';
            }
        }
    }
    else if(_pf == "Mac68K" || _pf == "MacPPC" || _pf == "Macintosh")
    {
        return "Mac";
    }
    else if(_pf == "X11")
    {
        return "Unix";
    }
    else if(String(_pf).indexOf("Linux") > -1)
    {
        return "Linux";
    }
    else
    {
        return "Unknow";
    }
}
function getSystemInfo(){
    $.ajax({
        url :'/system/getSystem',
        method : "GET",
        success : function(data) {
            if (null==data||undefined == data){
                layer.open({
                    title: '系统故障',
                    content: '暂未查询到服务器信息,请联系系统管理员'
                });
            }else if (data.resultMsg=="success"){
                var result =data.resultData;
                $("#ip").text(result.ip);
                $("#env").text(result.osName+"  "+result.osArch);
            }
        },
        error : function(){
            layer.open({
                title: '系统故障',
                content: '查询服务器信息失败,请联系系统管理员'
            });
        }
    })

    }
function getDatabaseInfo() {
    $.ajax({
            url :"/system/getDatabaseInfo",
            method: "GET",
            success : function(data) {
                $("#databaseSpan").text(data.resultData.version);
                $("#fileUpload").text(data.resultData.value);
            },
            error : function(){
                layer.open({
                    title: '系统故障',
                    content: '查询数据库信息失败,请联系系统管理员'
                });
            }
        })
    }
    function getVisitCount(){
        $.ajax({
            url :"/visit/getVisitCount",
            method :"get",
            success : function(data) {
                $("#count1").text(data.allVisitCount);
                $("#count2").text(data.todayVisitCount);
            },
            error : function(){
                layer.open({
                    title: '系统故障',
                    content: '查询数据库信息失败,请联系系统管理员'
                });
            }
        })
    }