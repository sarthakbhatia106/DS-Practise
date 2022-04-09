import React from 'react'
//similar to mapStateToProps
import { useSelector } from 'react-redux'
import { isEmpty, isLoaded } from 'react-redux-firebase'
import { Redirect, Route } from 'react-router-dom'

function PrivateRoute({ component: Component, ...remainingProps }) {
    const authFirebase = useSelector(state => state.firebase.auth)
    return (
        <Route {...remainingProps}
            render={({ props }) =>
                isLoaded(authFirebase) && !isEmpty(authFirebase) ?
                    (<Component {...props} />) : (<Redirect to='/' />)} >
        </Route>
    )
}

export default PrivateRoute
