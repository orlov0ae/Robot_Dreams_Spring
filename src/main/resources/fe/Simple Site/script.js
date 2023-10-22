const textElement = document.getElementById("animatedText");


function animateText() {
    textElement.style.animation = "flicker 1s infinite";
    textElement.style.opacity = 1;
}


window.onload = animateText;