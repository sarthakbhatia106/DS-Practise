// Q - Write a function f that returns product of x and y with both of the following function calls

// f(x, y)
// f(x)(y)

function f(x,y){
  if(arguments.length==1){
    return function(y){
      return x*y;
    }
  }else{
    return x*y;
  }
}

console.log(f(10,2));
console.log(f(10)(2));




// Solution:

// function f(y, x) {
//   if (arguments.length == 1) {
//     return function (x) {
//       return y * x;
//     };
//   } else {
//     return x * y;
//   }
// }

