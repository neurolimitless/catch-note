
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
	
	$(document).ready(function() {
    $(".editName").click(function(e){
	
    e.preventDefault();
        var content = $(this).text();
		var noteid = $(this).attr("content");
		
		        $(this).replaceWith('<form name="nameEdit" action="/edit-'+noteid+'-name" method="GET" ><input type="text" name="name" value="'+content+'"/><input type="submit" class="btn-success" value="Save"/></form>');
    });

});