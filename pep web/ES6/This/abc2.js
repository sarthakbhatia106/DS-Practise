// function fn() {
//   console.log(`Hi my name ${this.person}`);
//   function abc() {
//     console.log(`Hi my name ${this.person}`);
//   }
//   abc(); 
// }


// let obj={
//     person:'Sarthak',
//     func:fn
// };
// obj.func();
//here this is window object


////////////////////////////////////////solution-1 of this problem is BIND

//Bind is a function that is defined on other functions
//let ret=fn.bind(argument)
//bind returns a new function whose definition is similar to the function on which it is called
//and whose this is explicitly set equal to the argument that is passed 
// function fn() {
//     console.log(`Hi my name ${this.person}`);
//     function abc() {
//       console.log(`Hi my name ${this.person}`);
//     }
//     let ret=abc.bind(this);
//     ret();
//   }
  
  
//   let obj={
//       person:'Sarthak',
//       func:fn
//   };
//   obj.func();

  ///////////////////////////////////////////////solution-2 Arrow function
  
  function fn() {
    console.log(`Hi my name ${this.person}`);
    let abc=()=>{
      console.log(`Hi my name ${this.person}`);
    }
    abc();
  }
  
  
  let obj={
      person:'Sarthak',
      func:fn
  };
  obj.func();