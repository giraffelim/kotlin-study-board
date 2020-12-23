var main = {

    init: function () {
        var _this = this;
        $("#btn-save").on("click", function () {
            _this.save();
        });
        $("#btn-update").on("click", function () {
            _this.update();
        });
    },
    
    save: function () {
        var data = {
            title: $("#title").val(),
            author: $("#author").val(),
            content: $("#content").val()
        };

        $.ajax({
            type: 'POST',
            dataType: 'json',
            url: '/api/v1/posts',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = "/";
        }).fail(function (err) {
            alert(JSON.stringify(err));
        });
    },
    
    update: function () {
        var data = {
            title: $("#title").val(),
            content: $("#content").val()
        };

        var id = $("#id").val();

        $.ajax({
            type: 'put',
            dataType: 'json',
            url: '/api/v1/posts/' + id,
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function () {
            alert('글이 수정되었습니다.');
            window.location.href = "/";
        }).fail(function (err) {
            alert(JSON.stringify(err));
        })
    }
}

main.init();