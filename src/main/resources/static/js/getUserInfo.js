$(document).ready(function () {
    $.ajax({
        type: "GET",
        contentType: 'application/json;charset=utf-8',
        url: "/v0.1/user/user_info",
        traditional: true,//这使json格式的字符不会被转码
        timeout: 20000,
        dataType: "JSON",
        success: function (data) {
            $("#user_name").html(data.userName);
            getWebsocket(data);
        }
    });
});