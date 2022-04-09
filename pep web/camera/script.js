let video = document.querySelector("video");
let vidbtn = document.querySelector("button#record");
let capBtn = document.querySelector("button#capture");
let body = document.querySelector("body");
let filters = document.querySelectorAll(".filters");

let zoomIn = document.querySelector(".zoom-in");
let zoomOut = document.querySelector(".zoom-out");

let minZoom = 1;
let maxZoom = 3;
let currentZoom = 1;

let constraints = { video: true, audio: false }; //constraints is an object given to the getUserMedia which tels that what media we want

let mediaRecorder; // this holds the media recorder from browser
let isRecording = false; // tells if recording is being started of not
let chunks = []; //contains binary chunks of data of video recorded

let filter = "";

//applying event to get filter when we click filters
for (let i = 0; i < filters.length; i++) {
  filters[i].addEventListener("click", function (e) {
    filter = e.currentTarget.style.backgroundColor;
    //remove existing filter
    removeFilter();
    //apply new filter using the above value
    applyFilter(filter);
  });
}

zoomIn.addEventListener("click", function () {
  if (currentZoom < maxZoom) {
    currentZoom += 0.1;
    video.style.transform = `scale(${currentZoom})`;
  }
});

zoomOut.addEventListener("click", function () {
  if (currentZoom > minZoom) {
    currentZoom -= 0.1;
    video.style.transform = `scale(${currentZoom})`;
  }
});

vidbtn.addEventListener("click", function () {
  let innerDiv = vidbtn.querySelector("div");
  //button events
  if (isRecording) {
    mediaRecorder.stop(); //stops the recording of video
    isRecording = false;
    innerDiv.classList.remove("record-animation");
  } else {
    mediaRecorder.start(); // starts video recording
    filter = "";
    removeFilter();
    video.style.transform = "scale(1)";
    currentZoom = 1;  
    isRecording = true;
    innerDiv.classList.add("record-animation");
  }
});

capBtn.addEventListener("click", function () {
  let innerdiv = capBtn.querySelector("div");
  innerdiv.classList.add("capture-animation");
  setTimeout(function () {
    innerdiv.classList.remove("capture-animation");
  }, 500);
  capture();
});

//  navgator is a browser object which contains another object mediaDevices
navigator.mediaDevices //getUserMedia is a promise which is resolved when we allow access from browser and is rejected when we deny
  //  media devices has the fucntionality to use media devices of the computer.
  .getUserMedia(constraints)
  .then(function (mediaStream) {
    video.srcObject = mediaStream; //here we are giving source to the video element we made using html

    mediaRecorder = new MediaRecorder(mediaStream); //media recorded object

    mediaRecorder.addEventListener("dataavailable", function (e) {
      //this event is triggered while media recorder has media stream or when we have clicked start
      chunks.push(e.data); // binary data being pushed into chunks
    });

    mediaRecorder.addEventListener("stop", function (e) {
      // this will happen when recording stops or we click stop
      let blob = new Blob(chunks, { type: "video/mp4" }); //blob stitches all the binary data from the chunks array and store it in blob
      addMedia("video",blob);
      chunks = [];

      //jab bhi chunks me zada data ho jaega to blob me akar uska variable ban jata hai blob and end me vo blob ka url bana dete hai

      let url = URL.createObjectURL(blob); //creates url of the blob variable

      //downloads the blob file
      let a = document.createElement("a");
      a.href = url;
      a.download = "video.mp4";
      a.click();
      a.remove();
    });
  });

function capture() {
  let c = document.createElement("canvas");
  c.width = video.videoWidth;
  c.height = video.videoHeight;

  //drawing the video image shown in video box on canvas
  let ctx = c.getContext("2d");

  ctx.translate(c.width / 2, c.height / 2);
  ctx.scale(currentZoom, currentZoom);
  ctx.translate(-c.width / 2, -c.height / 2);

  ctx.drawImage(video, 0, 0);
  //apply filter while capturing image
  if (filter != "") {
    ctx.fillStyle = filter;
    ctx.fillRect(0, 0, c.width, c.height);
  }

  //downloading the image on canvas
  let a = document.createElement("a");
  a.download = "image.jpg";
  a.href = c.toDataURL(); //gets the url of canvas
  addMedia("img",c.toDataURL());
  a.click();
  a.remove();
}

//applies a div over the whole body with the colour of the filter
function applyFilter(filterColor) {
  let filterDiv = document.createElement("div");
  filterDiv.classList.add("filter-div");
  filterDiv.style.backgroundColor = filterColor;
  body.append(filterDiv);
}
//removes the div we applied while applying fiter
function removeFilter() {
  let filterDiv = document.querySelector(".filter-div");
  if (filterDiv) {
    filterDiv.remove();
  }
}
