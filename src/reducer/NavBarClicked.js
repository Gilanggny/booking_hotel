const initialState = {
    clicked=false
}

const NavigationBarReducer =(state = initialState, action)=>{
    switch(action.type){
        case "NAVIGATION_BAR_CLICKED":
            return{clicked:true}
        case "NAVIGATION_BAR_UNCLICKED":
            return initialState;
        default:
            return state;
    }
}

export default NavigationBarReducer;