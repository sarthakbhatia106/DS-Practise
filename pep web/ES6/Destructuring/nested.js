const user={
    id:077,
    name:'Sarthak',
    age:22,
    education:{
        degree:"Bachelor's",
        school:{
            name:'LVM',
            location:'Shakti Nagar'
        }
    }
}
///age
// let {age}=user;
// console.log(age);

////degree
// let {education:{degree}}=user;
// console.log(degree);

////school
let {education:{school:{name}}}=user;
console.log(name);