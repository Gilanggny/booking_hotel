import { combineReducers } from "redux";
import DataHotelReducer from "./DataHotelReducer";
import RegisterReducer from "./RegisterReducer"
import NavigationBarReducer from "./NavBarClicked"

const CompileReducer = combineReducers(
    {
        HotelData: DataHotelReducer,
        OrderData: RegisterReducer,
        NavBarStat: NavigationBarReducer
    }
)

export default CompileReducer;