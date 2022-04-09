//this is a keyword that particularly refers to an object
//the value of this would change according to the context in which it is being referred to

// console.log(this);//window object

//globally this--window object

//in normal call the value of this is passed as window object only

function fn(){
    console.log(this);
}
//normal call
// fn();

let obj={
    person:'Sarthak',
    fun: fn,
}
//function call with object
// obj.fun();
//in this case my this is equal to the object through which the fn is called

let ret=obj.fun;
ret();
//here again this is passed as window object
