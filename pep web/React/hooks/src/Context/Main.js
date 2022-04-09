import React,{useState} from 'react'
import Demo from './Demo';
import myContext from './Context';

function Main() {
    // render main->demo render->demo child with value as output i.e. value of count
    console.log('Render Main');
    const [count,setCount]=useState(0);

    return (
        <div>
            {/* this button is changing the context of our myContext */}
            <button onClick={()=>setCount(count+1)}>Click</button>

            {/* this will give the context value of count and render all its children having context information */}
            <myContext.Provider value={count}>
                <Demo/>
            </myContext.Provider>
        </div>
    )
}

export default Main
