var tokens;
$( document ).ready(function() {
   tokens = $(".tokenContainer");
   updateView();
   bindButtons();
});
function updateView(){
	boardHeight = $("#board").height();
	boardWidth = $("#board").width();
	centerX = $("#board").position().left + boardWidth/2;
	centerY = $("#board").position().top + boardHeight/2;
	$(tokens).each(function( index ) {
		player = $(this).data("player");
		x = $(this).data("position-x")/100 * boardWidth + centerX - $(this).width()/2;
		y = $(this).data("position-y")/100 * boardHeight + centerY - $(this).height()/2;
		$(this).css("left", x + "px");
		$(this).css("top", y + "px");
	});
}
function bindButtons(){
	$('#moveUpButton').click(function (event) {
		event.preventDefault();
		move("up");
	});
	$('#moveDownButton').click(function (event) {
		event.preventDefault();
		move("down");
	});
	$('#moveLeftButton').click(function (event) {
		event.preventDefault();
		move("left");
	});
	$('#moveRightButton').click(function (event) {
		event.preventDefault();
		move("right");
	});
	$('#throwDiceButton').click(function (event) {
		event.preventDefault();
		rollDice();
	});
}
function move(dir){
	url = "/move/" + dir;
	$.ajax({url: url,  method: "GET", success: function(result){
		alert("Data: " + result);
    }});
}
function rollDice(){
	url = "/rollDice";
	$.ajax({url: url,  method: "GET", success: function(result){
		$('#diceValue').html(result);
    }})
}