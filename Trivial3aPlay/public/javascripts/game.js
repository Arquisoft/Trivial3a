var tokens;
$( document ).ready(function() {
   tokens = $(".tokenContainer");
   updateView();
});
function updateView(){
	boardHeight = $("#board").height();
	boardWidth = $("#board").width();
	console.log(boardHeight + " - " + boardWidth);
	centerX = $("#board").position().left + boardWidth/2;
	centerY = $("#board").position().top + boardHeight/2;
	console.log(centerX + " - " + centerY);
	$(tokens).each(function( index ) {
		player = $(this).data("player");
		x = $(this).data("position-x")/100 * boardWidth + centerX - $(this).width()/2;
		y = $(this).data("position-y")/100 * boardHeight + centerY - $(this).height()/2;
		console.log(x + " - " + y);
		$(this).css("left", x + "px");
		$(this).css("top", y + "px");
	});
}