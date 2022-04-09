//Q create a polyfill of reduce

Array.prototype.myReduce = function (fun) {
  let ans = this[0];
  for (let i = 1; i < this.length; i++) {
    ans = fun(ans, this[i]);
  }
  return ans;
}

let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

function add(x,y){
  return x+y;
}
console.log(arr.myReduce(add));


// Solution:

function reduce(arr, reducer) {
  let ans = arr[0];
  for (let i = 1; i < arr.length; i++) {
    ans = reducer(ans, arr[i]);
  }
  return ans;
}

