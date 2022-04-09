import React,{useContext} from 'react'
import myContext from './Context'
import DemoChild from './DemoChild';


function Demo() {
    //this will be rendered before demo child
    //also React.memo() is used to stop this from rendering when myContext is changed
    //but if provider is used with value in this state then react.memo() will also be not able to stop re-rendering of this

    console.log('Demo Render');
    const val=useContext(myContext);
    console.log(val);
    return (
        <div>
            <DemoChild/>
        </div>
    )
}

// export default React.memo(Demo);
export default Demo
