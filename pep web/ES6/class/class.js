// class abc{
//     constructor(person){
//         this.person=person;
//         this.age=25;
//         this.sayHi=this.sayHi.bind(this);
//     }
//     sayHi(){
//         console.log("Hello");
//         console.log(this);
//     }
// }

// let obj=new abc('Sarthak');
// let obj1=new abc('Tushar');

// // let fn=obj.sayHi;
// // fn();//here this is undefined as in classes for normal calls this is undefined

// let btn=document.querySelector('button');
// // btn.addEventListener('click',obj.sayHi);////here also answer will not be sarthak object neither it will be undefined, here this will be of the button
// btn.addEventListener('click',obj.sayHi);



class abc{
    constructor(person){
        this.person=person;
        this.age=25;
    }
    sayHi=()=>{
        console.log("Hello");
        console.log(this);
    }
}

let obj=new abc('Sarthak');
let obj1=new abc('Tushar');

let btn=document.querySelector('button');
btn.addEventListener('click',obj.sayHi);