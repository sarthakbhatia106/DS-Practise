//database open/create
//database object store-> gallery
//photo capture/ video record-> gallery(obs) store

// format:
// data={
//     mId: 5456845313,
//     type:"img"/"vid",
//     media:actual content (img->c.toDataUrl, video->blob)
// }

let request = indexedDB.open("Camera", 1);
let dbAccess;
request.addEventListener("success", function () {
  //object store can not be done in success event
  dbAccess = request.result;
});

request.addEventListener("upgradeneeded", function () {
  let db = request.result;
  //object store can only be done in upgradeneeded event
  db.createObjectStore("gallery", {
    keyPath: "mId",
  });
});

request.addEventListener("error", function () {
  alert("some error occured");
});

function addMedia(type,media){
    //only called when we have acces to db
    //it lets us get the gallery object store from data base with readwrite functionality 
    let tx = dbAccess.transaction("gallery", "readwrite");
    //gallery object store
    let galleryObjectStore=tx.objectStore("gallery");
    //making the data to be added
    let data={
        mId: Date.now(),
        type,
        media,
    }
    //data being added to the gallery object store
    galleryObjectStore.add(data);
}
