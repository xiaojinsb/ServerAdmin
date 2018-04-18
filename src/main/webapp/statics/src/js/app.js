/**
 * Name:app.js
 * Author:Van
 * E-mail:zheng_jinfan@126.com
 * Website:http://kit.zhengjinfan.cn/
 * LICENSE:MIT
 */
var tab;
layui.define([ 'tab', 'navbar'], function(exports) {
    var $ = layui.jquery,
        navbar = layui.navbar;
    tab = layui.tab;
    var app = {

        config: {
            type: 'iframe'
        },
        set: function(options) {
            var that = this;
            $.extend(true, that.config, options);
            return that;
        },
        init: function() {
            var that = this,
                _config = that.config;
            if (_config.type === 'iframe') {
                tab.set({
                    elem: '#container',
                    onSwitch: function(data) { //选项卡切换时触发
                    },
                    closeBefore: function(data) { //关闭选项卡之前触发
                        return true; //返回true则关闭
                    }
                }).render();
                navbar.set({
                    remote: {
                        url: 'menu/nav'
                    }
                }).render(function(data) {
                    tab.tabAdd(data);
                });

            }
            return that;
        }
    };

    //输出test接口
    exports('app', app);
});