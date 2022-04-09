//...-> spread operator

// let arr=[1,2,3,4,5,6];
// console.log(...arr);


let arr1=[1,2,3,4];
let arr2=[6,7,8]
// output needed=[1,2,3,4,5,6,7,8]

let narr=[...arr1,5,...arr2];
console.log(...narr);