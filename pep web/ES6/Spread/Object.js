let state={
    name:'John',
    address:{
        city:'London',
        country:{
            countryName:'United Kingdom',
            countryCode:'UK'
        }
    }
}

let copy=state;//referance copy
// copy.name='Sarthak';
// console.log(state);
// console.log(copy);


let copy1={...state};
// copy1.name='Sarthak';
// console.log(state);
// console.log(copy1);

//changes occured in both because every object is made at different memory locations
let copy2={...state};//shallow copy beacuse we just made a copy upar upar se

//shallow copy for an object that is spread, the upper most level is created at a new memory state
// the properties of upper level remain the same 
//the lower levels are not affected by this... they keep on pointing to their original referance

// copy2.address.city='Delhi';
// console.log(state);
// console.log(copy2);


//to resolve the previous problem 
let doubleCopy={
    ...state,
    address:{
        ...state.address
    }
}

doubleCopy.address.city='Delhi';
// console.log(state);
// console.log(doubleCopy);


let deepCopy={
    ...state,
    address:{
        ...state.address,
        country:{
            ...state.address.country,
        }
    }
}

deepCopy.address.country.countryCode="IN";
// console.log(deepCopy);
// console.log(state);

//better way to make deep copy of nested objects with a lot of levels
let deepCopy1=JSON.parse(JSON.stringify(state));
deepCopy1.address.country.countryCode="IND";
console.log(state);
console.log(deepCopy1);
