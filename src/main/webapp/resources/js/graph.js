const graph =document.getElementById('svg');
const svg = document.querySelector('svg');
const Ox = 150;
const Oy = 150;
const scaleR = 28;


graph.addEventListener('click',event => {
    const svgPoint = svg.createSVGPoint();
    svgPoint.x = event.clientX;
    svgPoint.y = event.clientY;
    const point = svgPoint.matrixTransform(svg.getScreenCTM().inverse());
    console.log(`Координаты: x=${point.x}, y=${point.y}, r=${R}`);
    const x = transformCoordinate(point.x).toFixed(4);
    const y = -1*transformCoordinate(point.y).toFixed(4)
    console.log(`Переведенные координаты: x=${x}, y=${y}, r=${R}`);
    document.getElementById("point_coordinates:y").setAttribute("value",y)
    document.getElementById("point_coordinates:x").setAttribute("value",x)
    document.getElementById("point_coordinates:j_idt34").click();
});

function createPoint(x,y){
        const circle = document.createElementNS("http://www.w3.org/2000/svg", "circle");
        circle.setAttribute("cx", x);
        circle.setAttribute("cy", y);
        circle.setAttribute("r", "5");
        circle.setAttribute("fill", "yellow");
        circle.setAttribute("stroke", "orange");
        circle.setAttribute("stroke-width", "1");
        circle.setAttribute("opacity", "1");
    if(!checkArea(x,y,R.value)) {
        circle.setAttribute("fill", "red")
    } else circle.setAttribute("fill", "yellow")
        svg.appendChild(circle);


}

function drawGraph(r){
    deleteGraph();
    createRect((r*scaleR),(r*scaleR));
    createPolygon(Ox+r*scaleR,Oy-(r*scaleR)/2);
    createPath(Ox+r*scaleR,Oy+r*scaleR,r*scaleR);
    checkPoints(r);

}

function createRect(width,height){
    const rect = document.createElementNS("http://www.w3.org/2000/svg","rect");
    rect.setAttribute('x',Ox-width);
    rect.setAttribute('y',Oy);
    rect.setAttribute('width',width);
    rect.setAttribute('height',height);
    rect.setAttribute('fill-opacity',0.4);
    rect.setAttribute('stroke','navy');
    rect.setAttribute('fill','blue');

    svg.appendChild(rect)

}
function createPolygon(x,y){
    const polygon = document.createElementNS('http://www.w3.org/2000/svg', 'polygon');
    polygon.setAttribute('points', `150,150 ${x},150 150,${y}`);
    polygon.setAttribute('fill-opacity',0.4);
    polygon.setAttribute('stroke','navy');
    polygon.setAttribute('fill', 'blue');

    svg.appendChild(polygon);
}

function createPath(x,y,r){
    const path = document.createElementNS('http://www.w3.org/2000/svg', 'path');
    path.setAttribute('d', `M 150 150 L ${x} 150 A ${r} ${r} 0 0 1 150 ${y} L Z`);
    path.setAttribute('fill', 'blue');
    path.setAttribute('fill-opacity',0.4);
    path.setAttribute('stroke', 'navy');

    svg.appendChild(path);
}
function transformCoordinate(x){
    return (x-Ox)/scaleR;
}
function clearPoints(){
    const circles = svg.querySelectorAll("circle");
    circles.forEach(circle => {
        circle.remove();
    });
}
function checkPoints(r){
    const circles = svg.querySelectorAll("circle");

    circles.forEach(circle => {
        let x = circle.getAttribute("cx")
        let y = circle.getAttribute("cy")
        svg.appendChild(circle);
        if(!checkArea(x,y,r)) {
            circle.setAttribute("fill", "red")
        } else circle.setAttribute("fill", "yellow")
    });
}
function checkArea(x,y,r){
    x = transformCoordinate(x)
    y = -1*transformCoordinate(y)
        if (Math.pow(x,2)+Math.pow(y,2)<=Math.pow(r,2) && x>=0 && y<=0){
            return true;
        } else if (Math.abs(x)<=(r) && Math.abs(y)<=r && x<=0 && y<=0) {
            return true;
        } else return y <= -x + r/2 && x >= 0 && y >= 0;

}
function deleteGraph(){
    const rect = document.getElementsByTagName("rect")[0];
    rect.parentNode.removeChild(rect);
    const path = document.getElementsByTagName("path")[0];
    path.parentNode.removeChild(path);
    const polygon = document.getElementsByTagName("polygon")[2];
    polygon.parentNode.removeChild(polygon);
}
