$(document).ready(function () {
    $(window).resize(function () {
        var cf = $('#carbonForm');

        $('#carbonForm').css('margin-top', ($(window).height() - cf.outerHeight()) / 2);


    });


    $('.two').slideDown(600);
    $(".footer, .footerTwo").slideToggle(600);


})