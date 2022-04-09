function decToBin(num) {
    let arr=[];

    while(num>=2){
        let rem=Number(num)%2;
        let quo=Number(num-rem)/2;
        arr.push(rem);
        num=quo;
    }
    arr.push(num);
    arr.reverse();
    return arr.join("");
}
console.log(decToBin(3672));