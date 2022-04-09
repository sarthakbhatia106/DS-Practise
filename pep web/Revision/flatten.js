function flatten(obj,parent,res={}){
    for(let key in obj){
        let prop=parent?parent+"."+key:key;
        if(typeof obj[key]=='object' && !Array.isArray(obj[key])){
            flatten(obj[key],prop,res);
        }else{
            res[prop]=obj[key];
        }
    }
    return res;
}


let o={
    flavor: "vanilla",
    topping: {
        drizzle: "chocolava",
        sprinkle: "choco-chips",
    },
    cone: {
        type: "waffle",
        crust: {
        color: "dark",
        texture: "soft",
        },
    },
}

console.log(flatten(o));