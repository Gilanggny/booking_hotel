const initialState = {
    data: null,
    login_status: false
}

const AuthReducer = (state = initialState, action)=>{
    switch(action.type){
        case "LOGIN_OK":
            return{
                data: action.data,
                login_status: true
            }
        case "LOGOUT_OK":
            return initialState;
        default:
            return state;
    }
}

export default AuthReducer;