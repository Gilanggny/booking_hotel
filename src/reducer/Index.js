import { combineReducers } from "redux";
import DataHotelReducer from "./DataHotelReducer";
import RegisterReducer from "./RegisterReducer"
import NavigationBarReducer from "./NavBarClicked"
import AuthReducer from "./LoginReducer"

const CompileReducer = combineReducers(
    {
        HotelData: DataHotelReducer,
        OrderData: RegisterReducer,
        NavBarStat: NavigationBarReducer,
        AuthStat: AuthReducer
    }
)

export default CompileReducer;