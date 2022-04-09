/////////////destructuring in object
let person={
    name:'Steve',
    country:'New York',
    job:'Avenger',
}

///traditional way
// let name=person.name;
// let country=person.country;
// let job=person.job;

//variable name should be same as keys
// let {name,country,job}=person;
// console.log(name);
// console.log(country);
// console.log(job);

//if we want to use different names
// let {name:a,country:b,job:c}=person;
// console.log(a);
// console.log(b);
// console.log(c);


/////////undefined case
// let {name,country,job,car}=person;
// console.log(car);

////to avoid this
// let {name,country,job,car='BMW'}=person;
// console.log(car);