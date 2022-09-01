var transformMatrix = [1, 0, 0, 1, 0, 0];
  	
var svg = null;
var centerX  = null;
var centerY  = null;
var viewbox = null;
var matrixGroup =null;


// Create an SVGPoint for future math
var pt = null;

var mouseX=null;
var mouseY=null;


var onMouse = null;
var prevMousePt = null; 

var onClick = false;


var prevScale = 1;
var currentScale = 1;


var offsetPtX=0;
var offsetPtY=0;



function mapInit(){
	addCountrySelectEvent();
	mapMatrixInit();
	addMapDivEvnet();
	svg.addEventListener('mousemove',function(evt){
  		var loc = cursorPoint(evt);
		onMouse = loc;
		if(onClick)
		{
			//MapMove();			
		}
		
		
	},false);    	
	
	document.addEventListener("wheel", function (e) {
	
	if (e.deltaY > 0) {
			//zoom(-1,e);    		 
  		} else {
			//zoom(1,e);
  		}
	});
	
}


function addCountrySelectEvent()
{
	var countryElements = document.getElementById('countries').childNodes;
    	var countryCount = countryElements.length;
    	for (var i = 0; i < countryCount; i++) {
      countryElements[i].onclick = function() {
        alert('You clicked on ' + this.getAttribute('data-name'));
      }
    }
}

function addMapDivEvnet()
{
	var mapDiv = document.getElementById("tempMapDiv");

	mapDiv.addEventListener('mousedown', (event) => {
  			mapMouseDown(event);
		});
		document.addEventListener('mouseup', (event) => {
  			mapMouseUp();
		});
}
function mapMatrixInit()
{
		svg = document.getElementById('mapID');
    	viewbox = svg.getAttributeNS(null, "viewBox").split(" ");
    	centerX = parseFloat(viewbox[2]) / 2;
    	centerY = parseFloat(viewbox[3]) / 2;
    	matrixGroup = svg.getElementById("countries");
    	pt = svg.createSVGPoint(); 
 		var newMatrix = "matrix(" +  transformMatrix.join(' ') + ")";
  		matrixGroup.setAttributeNS(null, "transform", newMatrix);
}

function MapMove()
{
	var changePtX = prevMousePt.x -onMouse.x;
	var changePtY = prevMousePt.y -onMouse.y;
	
	offsetPtX+=(changePtX)/transformMatrix[0];
	offsetPtY+=(changePtY)/transformMatrix[0];
	
	pan(-changePtX,-changePtY);
	
	prevMousePt.x =onMouse.x;
	prevMousePt.y =onMouse.y;
}

var PrevMOffsetX = 0;
var PrevMOffsetY = 0;
	
function zoom(scale,event) {

	transformMatrix[0] = 1;
	transformMatrix[1] = 0;
	transformMatrix[2] = 0;
	transformMatrix[3] = 1;
	
	console.log(transformMatrix);	
    

	var prevScale =  currentScale;	
	
	if(currentScale+scale<1)
	{
		currentScale = 1;
	}
	else if(currentScale+scale>8)
	{
		currentScale = 8;
	}
	else{
		currentScale+= scale;
	}
	
	transformMatrix[0] = currentScale;
    transformMatrix[3] = currentScale;
	
	console.log("PrevScale="+prevScale);	
	console.log("currScale="+currentScale);	
	console.log("distance="+((cursorPoint(event).x-transformMatrix[4]))/ prevScale);	
	
	var centerX = ((cursorPoint(event).x-transformMatrix[4]) / prevScale)*(1-currentScale);
	var centerY = ((cursorPoint(event).y-transformMatrix[5])/ prevScale)*(1-currentScale);

	
	console.log("Mx="+(cursorPoint(event).x));	
	console.log("Mx="+(cursorPoint(event).x));	
	console.log("Cx="+centerX);	
  	transformMatrix[4] = centerX-offsetPtX;
  	transformMatrix[5] = centerY-offsetPtY;
	console.log(transformMatrix);	
	

  	var newMatrix = "matrix(" +  transformMatrix.join(' ') + ")";
  	matrixGroup.setAttributeNS(null, "transform", newMatrix);
}

function pan(dx, dy) {     	
  transformMatrix[4] += dx 
 ;
  transformMatrix[5] += dy;
            
  var newMatrix = "matrix(" +  transformMatrix.join(' ') + ")";
  matrixGroup.setAttributeNS(null, "transform", newMatrix);
	console.log(transformMatrix);	

}


// Get point in global SVG space
function cursorPoint(evt){
  pt.x = evt.clientX; pt.y = evt.clientY;
  return pt.matrixTransform(svg.getScreenCTM().inverse());
}

function mapMouseDown(event)  {
  	onClick=true;
	prevMousePt= cursorPoint(event);
	
	
	console.log(onClick);
	console.log(Math.floor(cursorPoint(event).x));
	console.log(Math.floor(cursorPoint(event).y));
}
function mapMouseUp()  {
  	onClick=false;
	console.log(onClick);
}


	