import { combineReducers } from "redux";

import BallReducer from "./ball/ballsreducer";
import BatReducer from "./bat/batReducer";
import userReducer from "./users/userReducer";

const rootReducer=combineReducers({
    ball:BallReducer,
    bat:BatReducer,
    user:userReducer
})

export default rootReducer