$(document).ready(function () {
    $(window).resize(function () {
        var cf = $('#carbonForm');

        $('#carbonForm').css('margin-top', ($(window).height() - cf.outerHeight()) / 2);


    });
    $('#carbonForm').slideDown(600, function() {
        $('footer').slideDown(400);
    });
    
})