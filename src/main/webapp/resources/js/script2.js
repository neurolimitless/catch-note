$(function () {
    $(window).resize(function () {
        var cf = $('.dialog');

        $('.dialog').css('margin-top', ($(window).height() - cf.outerHeight()) / 2);

    });

    $('#opnDial').on('click', function () {
        $('.dialog').fadeIn();
    });
    $('#closeDialog').on('click', function () {
        $('.dialog').fadeOut();
        return false;
    });
    $('#no').on('click', function () {
        $('.dialog').fadeOut();
    });
    $(".editName").click(function (e) {
        e.preventDefault();
        var content = $(this).text();
        var noteid = $(this).attr("content");
        $(this).replaceWith('<form name="nameEdit" action="/edit-' + noteid + '-name" method="GET" ><input type="text" name="name" value="' + content + '"/><input type="submit" class="btn-success" value="Save"/></form>');
    });
    $(".editData").click(function (e) {
        e.preventDefault();
        var content = $(this).text();
        var noteid = $(this).attr("content");
        $(this).replaceWith('<form name="dataEdit" action="/edit-' + noteid + '-data" method="GET" ><input type="text" name="data" value="' + content + '"/><input type="submit" class="btn-success" value="Save"/></form>');
    });
    $(".deleteNote").click(function () {
        var noteid = $(this).attr("content");
        $('.dialog').fadeIn();
		$(".butn").html("<button class='inn' id='yes'>OK</button><button class='inn' id='no'>Cancel</button>");
        document.getElementById('yes').setAttribute("onclick", "location.href='/delete-" + noteid + "-note'");
    });
	

});
