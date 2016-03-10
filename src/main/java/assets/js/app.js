var game;

function display(game) {
    console.log(game);
    $( '.columnOfCards .cardLocation' ).html("");

    $.each(game.cols[0], function( key, val ) {
        $( '#c0 .l'+key ).html(val.value + val.suit);
    });

    $.each(game.cols[1], function( key, val ) {
        $( '#c1 .l'+key ).html(val.value + val.suit);
    });

    if(game.error == true){
        $('#errorModal').modal('show');
    }
}

$.getJSON("http://localhost:8080/game", function( data ) {
    display(data);
    game = data;
});


var text = "\
    1.Four cards are dealt to four columns.Click on deal button will deal next four cards.<br>\
    2.A card can be removed when another card showing at the top of another column has the same suit and a higher value. (Example: a 2 of diamonds can be removed if a 6 of diamonds).<br>\
    3.Click on a column to remove the card in the column.<br>\
    4.A 2 is the lowest value and an ace is higher than a king. Therefore, an ace cannot be removed.<br>\
    5.When one of the four column is empty, any single card can be moved to that column.<br>\
    6.Enter which column you want to move from and to which column, then click on move button<br>\
    7.A game is won if all cards have been removed except for the four aces.";

function CustomAlert(){
    this.render = function(dialog){
        var winW = window.innerWidth;
        var winH = window.innerHeight;
        var dialogoverlay = document.getElementById('dialogoverlay');
        var dialogbox = document.getElementById('dialogbox');
        dialogoverlay.style.display = "block";
        dialogoverlay.style.height = winH+"px";
        dialogbox.style.left = (winW/2) - (550 * .5)+"px";
        dialogbox.style.top = "200px";
        dialogbox.style.display = "block";
        document.getElementById('dialogboxhead').innerHTML = "Help: How To Play ";
        document.getElementById('dialogboxbody').innerHTML = dialog;
        document.getElementById('dialogboxfoot').innerHTML = '<button id= "okButton"onclick="Alert.ok()">Enjoy!</button>';
    }
	this.ok = function(){
		document.getElementById('dialogbox').style.display = "none";
		document.getElementById('dialogoverlay').style.display = "none";
	}
}
var Alert = new CustomAlert();

//
// Wallet and Betting
//

var wallet = $("#walletValue");
var bet = $("#betValue");
console.log('"' + wallet.text() + '"');
console.log('"' + bet.text() + '"');


//
// BUTTONS
//

$("#HitBtn").click(function(){
    // hit button logic should go here
    console.log("hit button test");
});
$("#StayBtn").click(function(){
    // stay button logic should go here
    console.log("stay test");
});
$("#DoubleBtn").click(function(){
    // double button logic should go here
    console.log("double test");
});
$("#SplitBtn").click(function(){
    // split button logic should go here
    console.log("split test");
});

$("#bet1").click(function(){
    // bet logic should go here
    console.log("bet1 test");
});

$("#bet5").click(function(){
    // bet logic should go here
    console.log("bet5 test");
});

$("#bet20").click(function(){
    // bet logic should go here
    console.log("bet20 test");
});

$("#bet50").click(function(){
    // bet logic should go here
    console.log("bet50 test");
});


$(document).ready(function() {
    $( "#GameContainer" ).hide();
    $( "#StartGame" ).click(function() {
        $( "#GameContainer" ).show();
        $( "#StartGame" ).hide();
    });
});