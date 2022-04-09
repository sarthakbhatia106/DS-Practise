import React,{useContext} from 'react';
import myContext from './Context';


function DemoChild() {
    //here myContext value will be 1 as it is updated in main 
    //using provider with value of count
    console.log('Demo Child Render');
    const val=useContext(myContext);
    console.log(val);
    return (
        <div>
            
        </div>
    )
}

export default DemoChild
