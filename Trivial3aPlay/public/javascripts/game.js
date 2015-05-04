var tokens;
$( document ).ready(function() {
   tokens = $(".tokenContainer");
   updatePosition();
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
	$('#answer1').click(function (event) {
		event.preventDefault();
		answer(0);
	});
	$('#answer2').click(function (event) {
		event.preventDefault();
		answer(1);
	});
	$('#answer3').click(function (event) {
		event.preventDefault();
		answer(2);
	});
	$('#answer4').click(function (event) {
		event.preventDefault();
		answer(3);
	});
}
function answer(id){
	url = "/answer/" + id;
	$.ajax({url: url,  method: "GET", success: function(result){
		if(result == 'true'){
			$('#gameQuestionText').css("color", "green");
		}
		else {
			$('#gameQuestionText').css("color", "red");
		}
    }})
}
function move(dir){
	url = "/move/" + dir;
	$.ajax({url: url,  method: "GET", success: function(result){
		res = result.split(" - ");
		$('#gameQuestionText').html(res[0]);
		$('#answer1').html(res[1]);
		$('#answer2').html(res[2]);
		$('#answer3').html(res[3]);
		$('#answer4').html(res[4]);
		updatePosition();
    }});
	
}
function rollDice(){
	url = "/rollDice";
	$.ajax({url: url,  method: "GET", success: function(result){
		$('#diceValue').html(result);
    }})
}
function updatePosition(){
	url = "/getPosition";
	$.ajax({url: url,  method: "GET", success: function(result){
		res = result.split(" - ");
		for(i=0; i<res.length; i++){
			res2 = res[i].split("/");
			token = '#token' + res2[0];
			console.log(token);
			console.log(res2[1] + " " + res2[2])
			$(token).data("position-x", res2[1]);
			$(token).data("position-y", res2[2]);
		}
    }})
    updateView();
}