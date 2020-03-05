$(function () {
    window.onload = function () {
        var t = document.documentElement.scrollTop || document.body.scrollTop;
        $("#header-home").addClass('scroll-header');
        if (t <= 0) {
            $("#header-home").removeClass('scroll-header');
        }
    }
    window.addEventListener("scroll", function (e) {
        var t = document.documentElement.scrollTop || document.body.scrollTop;
        $("#header-home").addClass('scroll-header');
        if (t <= 0) {
            $("#header-home").removeClass('scroll-header');
        }
    });

    GLOBAL_WIN_WIDTH = Number($(window).width());
    //窗口宽度大于等于576px，采用横版样式
    if (GLOBAL_WIN_WIDTH >= 576) {

    }
    //反之用竖版样式
    else {

    }
    //调节窗口宽度，刷新页面
    //高度变化，不刷新，防止手机端一些浏览器，滚动的时候自动隐藏工具条，导致页面大小发生变化
    $(window).resize(function () {
        if (Number($(window).width()) != GLOBAL_WIN_WIDTH) {
            window.location.reload();
        }
    });


    $(".dropdown-toggle").on("click", function () {
        if ($(this).next(".dropdown-menu").is(":visible")) {
            $(this).next(".dropdown-menu").hide();
        } else {
            $(this).next(".dropdown-menu").show();
        }
    });
    $("button.collapsed").on("click", function () {
        if ($(".bs-example-js-navbar-collapse").is(":visible")) {
            $(".bs-example-js-navbar-collapse").hide();
        } else {
            $(".bs-example-js-navbar-collapse").show();
        }
    });

    $(".test-nav li").on("click", function () {
        $(this).addClass('active').siblings().removeClass('active');
        var i = $(this).index();
        $(".wrap-banner-center .test-des").find("li").removeClass('active').eq(i).addClass('active');
    }).on("mouseover", function () {
        $(this).addClass('active').siblings().removeClass('active');
        var i = $(this).index();
        $(".wrap-banner-center .test-des").find("li").removeClass('active').eq(i).addClass('active');
    });

    $(".partner-nav li").on("click", function () {
        $(this).addClass('active').siblings().removeClass('active');
        var i = $(this).index();
        $(".partner-type").removeClass('active').eq(i).addClass('active');
    })

})