
 $(function() {   $(window).resize(function () {
        var cf = $('.dialog');

        $('.dialog').css('margin-top', ($(window).height() - cf.outerHeight()) / 2);

})
   
    $('#opnDial').on('click', function() {
        $('.dialog').fadeIn();
    })
    $('#closeDialog').on('click', function() {
        $('.dialog').fadeOut();
        return false;
    })
    $('#no').on('click', function() {
        $('.dialog').fadeOut();
    })
    
    })