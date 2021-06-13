const initialState = {
    data: null,
    error: ""
}

const RegisterReducer = (state=initialState, action)=>{
    switch(action.type){
        case "FETCH_DATA_REGISTER":
            return{
                ...state,
                data: action.data
            }
        case "ERROR_REGISTER":
            return{
                ...state,
                err: action.message
            }
        default:
            return state
    }
}

export default RegisterReducer;
