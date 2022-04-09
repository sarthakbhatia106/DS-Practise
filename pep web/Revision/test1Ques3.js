function solve(rain) {
    let ans = [];
    for (let obj in rain) {
        let o = { 'name': rain[obj].name };
        let sum = 0;
        for (const i in rain[obj].rainfall) {
            sum += Number(rain[obj].rainfall[i]);
        }
        let avg = sum / rain[obj].rainfall.length;
        o.avgRainfall = avg;
        ans.push(o);
    }
    return ans;
}
let arr = [
    { name: "Boston", rainfall: [1, 2, 3, 4, 5, 6, 7] },
    { name: "Chandler", rainfall: [0, 0, 1, 0, 0, 1, 1] },
    { name: "Charlotte", rainfall: [2, 2, 2, 2, 2, 2, 2] },
    { name: "Dallas", rainfall: [3, 3, 2, 6, 1, 3, 8] },
];

console.log(solve(arr));