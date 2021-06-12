const initialState = {
    data: null,
    error: ""
}

const DataHotelReducer =(state=initialState, action)=>{
    switch(action.type){
        case "FETCH_DATA_HOTEL":
            return{
                ...state,
                data: action.data
            }
        case "ERROR_FETCH_HOTEL":
            return{
                ...state,
                err: action.message
            }
        default:
            return state
    }
}

export default DataHotelReducer;