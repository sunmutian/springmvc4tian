/**
 * 服务器信息管理js
 */
$(function () {
    //添加
    $('#add').on('click', function () {
        $('.d_mask').load('toAdd', null, function () {
            var html = $(this).html();
            $.dialog({
                title: '添加用户信息',
                id: 'add',
                lock: true,
                content: html,
                ok: function () {
                    var params = checkParam();
                    if (params.success == 0) {
                        return;
                    }
                    common.showLoadMask();
                    common.ajaxPost('ajaxAddUserInfo', params, function (data) {
                        if (data.success) {
                            $.dialog.tips('添加成功', 1, null, function () {
                                window.location.reload();
                            });
                        } else {
                            $.dialog.tips(data.message);
                            common.hideLoadMask();
                        }
                    });
                },
                cancelVal: '关闭',
                cancel: function () {

                }
            });
        });
    });
    //修改
    $('.edit_btn').on('click', function () {
        var dataId = $(this).attr('data-id');
        $('.d_mask').load('toEdit/' + dataId, null, function () {
            var html = $(this).html();
            $.dialog({
                title: '修改服务器信息',
                id: 'edit',
                lock: true,
                content: html,
                ok: function () {
                    var params = checkParam();
                    if (params.success == 0) {
                        return;
                    }
                    common.showLoadMask();
                    common.ajaxPost('ajaxEditServerInfo', params, function (data) {
                        if (data.success) {
                            $.dialog.tips('修改成功', 1, null, function () {
                                window.location.reload();
                            });
                        } else {
                            $.dialog.tips(data.message);
                            common.hideLoadMask();
                        }
                    });
                },
                cancelVal: '关闭',
                cancel: function () {

                }
            });
        });
    });
    //删除
    $('.del_btn').on('click', function () {
        var dataId = $(this).attr('data-id');
        $.dialog.confirm('确定要删除吗？', function () {
            common.showLoadMask();
            common.ajaxPost('ajaxDelServerInfo/' + dataId, null, function (data) {
                if (data.success) {
                    $.dialog.tips('删除成功', 1, null, function () {
                        window.location.reload();
                    });
                } else {
                    $.dialog.tips(data.message);
                    common.hideLoadMask();
                }
            });
        }, function () {

        });
    });

    //单个启动
    $('.boot_btn').on('click', function () {
        var dataId = $(this).attr('data-id');
        $.dialog.confirm('确定要启动吗？', function () {
            common.showLoadMask();
            common.ajaxPost('ajaxBootServerInfo/' + dataId, null, function (data) {
                if (data.success) {
                    $.dialog.tips('启动成功', 1, null, function () {
                        window.location.reload();
                    });
                } else {
                    $.dialog.tips('启动失败');
                    common.hideLoadMask();
                }
            });
        }, function () {

        });
    });

    //启动全部
    $('#start_all').on('click', function () {
        $.dialog.confirm('确定全部启动吗？', function () {
            common.showLoadMask();
            common.ajaxPost('ajaxBootServerInfoAll', null, function (data) {
                if (data.success) {
                    $.dialog.tips('启动成功', 1, null, function () {
                        window.location.reload();
                    });
                } else {
                    $.dialog.tips('启动失败');
                    common.hideLoadMask();
                }
            });
        }, function () {

        });
    });


    //参数组装以及检查
    function checkParam() {
        var params = {
            success: 1
        };
        var userName = $('#userName', parent.document).val();
        if (userName == '') {
            $.dialog.tips('用户名为空');
            params.success = 0;
            return params;
        }
        params.userName = userName;
        var passWord = $('#passWord', parent.document).val();
        if (passWord == '') {
            $.dialog.tips('密码为空');
            params.success = 0;
            return params;
        }
        params.passWord = passWord;
        return params;
    }

});