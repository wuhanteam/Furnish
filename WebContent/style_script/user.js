//$(function(){
//
//	//
//$(function () { 
//$(window).scroll(function () { 
//if ($(window).scrollTop() > 200) { 
//$(".searchbar").addClass("nav").css("top","0")
//$(".inputsea").css("opacity","1")
//} 
//else { } 
//}); 
//}); 
//});




$(function () { 
  var bar=$(".searchbar");
  var top=bar.position().top;
  $(window).scroll(function () { 
    if ($(window).scrollTop() > top) { 
      $(".searchbar").addClass("nav").css("top","0");
    } 
    else{ 
      $(".searchbar").removeClass("nav").css("top","0.5em");
    } 
  }); 
}); 

$("#loginbox > div.for").click(function(){
	alert(1);
	window.open("${cxt}/forgetpassword.jsp","_blank");
})

