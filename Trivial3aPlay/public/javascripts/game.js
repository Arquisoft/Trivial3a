var tokens;
$( document ).ready(function() {
   tokens = $(".tokenContainer");
   updatePosition();
   bindButtons();
   $('#winnerWrapper').hide();
   updateTokens();
   button = getAction();
   console.log(button);
   rollDice(false);
   move("none");
   answer(-1);
   enableButton(button);
   
});
function enableButton(button){
	$('.buttonWrapper button').attr("disabled", "disabled");
	switch(button){
	case "roll":
		$('#throwDiceButton').removeAttr("disabled");
		break;
	case "move":
		$('#moveUpButton').removeAttr("disabled");
		$('#moveDownButton').removeAttr("disabled");
		$('#moveLeftButton').removeAttr("disabled");
		$('#moveRightButton').removeAttr("disabled");
		break;
	case "answer":
		$('#answer1').removeAttr("disabled");
		$('#answer2').removeAttr("disabled");
		$('#answer3').removeAttr("disabled");
		$('#answer4').removeAttr("disabled");
		break;
	}
}
function updateView(){
	boardHeight = $("#board").height();
	boardWidth = $("#board").width();
	centerX = $("#board").position().left + boardWidth/2;
	centerY = $("#board").position().top + boardHeight/2;
	$(tokens).each(function( index ) {
		player = $(this).data("player");
		x = $(this).data("position-x")/100 * boardWidth + centerX - $(this).width()/2;
		y = $(this).data("position-y")/100 * boardHeight + centerY - $(this).height()/2;
		$(this).velocity({"left": x + "px", "top": y + "px"}, {duration: 1000});
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
		rollDice(true);
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
function getAction(){
	url = "/getAction";
	$.ajax({url: url,  method: "GET", success: function(result){
		//console.log(result);
		r = result.split(" - ");
		if(r[0] != r[2])
			enableButton("");
		else {
			enableButton(r[1]);
			return r[1];
		}
    }})
}
function answer(id){
	enableButton("");
	url = "/answer/" + id;
	$.ajax({url: url,  method: "GET", success: function(result){
		if(result == 'true'){
			$('#gameQuestionText').css("color", "green");
			updateTokens();
			printChatServer("Respuesta correcta, sigue jugando");
		}
		else {
			if(id!=-1){
				$('#gameQuestionText').css("color", "red");
				$.ajax({url: "/getPlayer",  method: "GET", success: function(result){
					printChatServer("Respuesta incorrecta, turno de " + result);
				}});
			}
		}
		getAction();
		isFinished();
    }})
}
function move(dir){
	enableButton("");
	url = "/move/" + dir;
	$.ajax({url: url,  method: "GET", success: function(result){
		res = result.split(" - ");
		$('#gameQuestionText').html(res[0]);
		$('#answer1').html(res[1]);
		$('#answer2').html(res[2]);
		$('#answer3').html(res[3]);
		$('#answer4').html(res[4]);
		updatePosition();
		enableButton("answer");
    }});
	
}
function rollDice(reroll){
	enableButton("");
	url = "/rollDice/" + reroll;
	$.ajax({url: url,  method: "GET", success: function(result){
		$('#diceValue').html(result);
		enableButton("move");
		$('#gameQuestionText').css("color", "white");
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
			updateView();
		}
    }})
}
function isFinished(){
	url = "/isFinished";
	$.ajax({url: url,  method: "GET", success: function(result){
		if(result != ""){
			finish(result);
		}
    }})
}
function finish(winner){
	$('#winnerWrapper').append('<audio src="assets/sound/win.mp3" autoplay>');
	$('#winnerWrapper').fadeIn(500);
	$('#winnerPlayer').html(winner);
}
function updateTokens(){
	url = "/getTokens";
	$.ajax({url: url,  method: "GET", success: function(result){
		if(result != ""){
			r1 = result.split(" / ");
			for(i=0; i<r1.length; i++){
				r2=r1[i].split(" - ");
				for(j=1; j<r2.length; j++){
					token = "#token" + r2[0]; 
					console.log(r2[j]);
					switch(r2[j]){
						case "amarillo":
							$(token + "> .token-space-1").removeClass("tokenBlank");
							$(token + "> .token-space-1").addClass("tokenYellow");
							break;
						case "azul":
							$(token + "> .token-space-2").removeClass("tokenBlank");
							$(token + "> .token-space-2").addClass("tokenBlue");
							console.log(token);
							break;
						case "morado":
							$(token + "> .token-space-3").removeClass("tokenBlank");
							$(token + "> .token-space-3").addClass("tokenPurple");
							break;
						case "naranja":
							$(token + "> .token-space-4").removeClass("tokenBlank");
							$(token + "> .token-space-4").addClass("tokenOrange");
							break;
						case "rojo":
							$(token + "> .token-space-5").removeClass("tokenBlank");
							$(token + "> .token-space-5").addClass("tokenRed");
							break;
						case "verde":
							$(token + "> .token-space-6").removeClass("tokenBlank");
							$(token + "> .token-space-6").addClass("tokenGreen");
							break;
					}
				}
			}
		}
    }})
}
function printChatServer(message){
	$('#chatText').append('<p><span class="chatAuthor chatServer">SERVIDOR: </span>'+ message +'</p>');
}