
const R = document.getElementById("point_coordinates:r");
const X = document.getElementById("point_coordinates:x");
const Y = document.getElementById("point_coordinates:y");
const btn_clear=document.getElementById("point_coordinates:clear_button")
const btn_submit=document.querySelector("input[type=submit]")
btn_submit.addEventListener('click',evt => {
    let x=X.value;
    console.log(x)
    let y=Y.value;
    console.log(y)
    console.log(X.value)
    if(checkY()&&checkX()&&checkR()) {
        createPoint(scaleR * x + Ox, (scaleR * y - Oy) * (-1),R.value);
    }
})
btn_clear.addEventListener('click',evt => {
    clearPoints();
})
function chooseButton(element,className){
    if(className==='R') {
        R = element.value;
        deleteGraph();
        drawGraph(element.value);
    }

    console.log(className);
    [...document.getElementsByClassName(className)].forEach(function (btn){
        btn.style.backgroundColor="#ffffff";
        btn.style.color="rgb(112,84,232)";

    });
    element.style.backgroundColor="rgb(112,84,232)";
    element.style.color="#ffffff";


}
function checkR(){
    return(R.value>=1);
}
function checkX(){
    return(X.value>=-2 && X.value<=2);
}
function checkY(){
    return(Y.value>=-3 && Y.value<=5);
}



