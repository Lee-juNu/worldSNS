  var transformMatrix = [1, 0, 0, 1, 0, 0];
  	
var svg = null;
var centerX  = null;
var centerY  = null;
var viewbox = null;
var matrixGroup =null;

// Create an SVGPoint for future math
var pt = null;





window.onload = function(){
var countryElements = document.getElementById('countries').childNodes;
    var countryCount = countryElements.length;


	svg = document.getElementById('mapID');
    viewbox = svg.getAttributeNS(null, "viewBox").split(" ");
    centerX = parseFloat(viewbox[2]) / 2;
    centerY = parseFloat(viewbox[3]) / 2;
    matrixGroup = svg.getElementById("countries");
    pt = svg.createSVGPoint();  
  var newMatrix = "matrix(" +  transformMatrix.join(' ') + ")";
  matrixGroup.setAttributeNS(null, "transform", newMatrix);


for (var i = 0; i < countryCount; i++) {
      countryElements[i].onclick = function() {
        alert('You clicked on ' + this.getAttribute('data-name'));
      }
    }

svg.addEventListener('mousemove',function(evt){
  var loc = cursorPoint(evt);
},false);    	
}



document.addEventListener("wheel", function (e) {
  if (e.deltaY > 0) {
   		 zoom(1.25);
  } else {
   		 zoom(0.8);
  }
});

function zoom(scale) {
  for (var i = 0; i < 4; i++) {
    transformMatrix[i] *= scale;
  }
  transformMatrix[4] += (1 - scale) * centerX;
  transformMatrix[5] += (1 - scale) * centerY;
		        
  var newMatrix = "matrix(" +  transformMatrix.join(' ') + ")";
  matrixGroup.setAttributeNS(null, "transform", newMatrix);
}

function pan(dx, dy) {     	
  transformMatrix[4] += dx;
  transformMatrix[5] += dy;
            
  var newMatrix = "matrix(" +  transformMatrix.join(' ') + ")";
  matrixGroup.setAttributeNS(null, "transform", newMatrix);
}





// Get point in global SVG space
function cursorPoint(evt){
  pt.x = evt.clientX; pt.y = evt.clientY;
console.log(pt.x);
console.log(pt.y);
  return pt.matrixTransform(svg.getScreenCTM().inverse());
}


	