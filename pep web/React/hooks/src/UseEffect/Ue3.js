import React,{useState,useEffect} from 'react'
import './Ue3.css'
//3rd variation
//non empty dependency array
//us array ke andar jo bhi value hogi uske basis pe useEffect chalega

function Ue3() {

    //runs after every render and re-render
    console.log('render');
    
    //run when the page loads for the first time
    const [count,setCount]=useState(0);
    const [darkMode,setDarkMode]= useState(false);

    //this will only run when count value will be updated i.e. whatever is there in the dependency array
    useEffect(()=>{
        console.log('useEffect');
        document.title=`Clicked ${count} times`;
    },[count]);

    return (
        <div className={darkMode?"view dark-mode":"view"}> 
            <label htmlFor='dark Mode'>DarkMode</label>
            <input type='checkbox' checked={darkMode} onChange={()=>setDarkMode(!darkMode)}></input>
            <br/>
            <button onClick={()=> setCount(count+1)}>{count}</button>
        </div>
    )
}

export default Ue3
