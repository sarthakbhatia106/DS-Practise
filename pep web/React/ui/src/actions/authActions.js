import * as actionTypes from './actionTypes';

export const signInRequest=()=>{
    return{
        type:actionTypes.SIGN_IN_REQUEST
    }
}

export const signInSuccess=()=>{
    return{
        type:actionTypes.SIGN_IN_SUCCESS
    }
}

export const signInFailed=(err)=>{
    return{
        type:actionTypes.SIGN_IN_FAILED,
        error: err
    }
}

export const removeError=()=>{
    return{
        type:actionTypes.REMOVE_ERROR
    }
}

export const signIn=(userData)=>{
    return async(dispatch,getState,{getFirebase,getFirestore})=>{
        dispatch(signInRequest());
        const firebase=getFirebase();
        try{
            let data=firebase.auth().signInWithEmailAndPassword(userData.email,userData.password);
            dispatch(signInSuccess());
        }catch(e){
            dispatch(signInFailed(e));
            setTimeout(()=>{
                dispatch(removeError())
            },2000)
        }
    }
}


export const registerRequest=()=>{
    return {
        type:actionTypes.REGISTER_REQUEST
    }
}

export const registerSuccess=()=>{
    return {
        type:actionTypes.REGISTER_SUCCESS
    }
}

export const registerFailed=(err)=>{
    return {
        type:actionTypes.REGISTER_FAILED,
        error:err
    }
}

export const regsiter=(userData)=>{
    return (dispatch,getState,{getFirebase,getFirestore})=>{
        dispatch(registerRequest());
        const firebase=getFirebase();
        const firestore=getFirestore();

        firebase.auth().createUserWithEmailAndPassword(userData.email,userData.password).then(async(data)=>{
            const res= await firestore.collection('users').doc(data.user.uid).set({
                email:userData.email,
                resumeIds:[]
            });
            dispatch(registerSuccess());
        }).catch((e)=>{
            dispatch(registerFailed(e));
            setTimeout(()=>{
                dispatch(removeError());
            },2000);
        })
    }
}

export function signOut(){
    return (dispatch,getState,{getFirebase,getFirestore})=>{
        const firebase=getFirebase();
        firebase.auth().signOut().then(()=>{
            dispatch({type:actionTypes.SIGN_OUT})
        }).catch((e)=>{
            dispatch({type:actionTypes.SIGN_OUT_FAILED,error:e})
        })
    }
}