import { combineReducers } from "redux";
import DataHotelReducer from "./DataHotelReducer";
import RegisterReducer from "./RegisterReducer"

const CompileReducer = combineReducers(
    {
        HotelData: DataHotelReducer,
        OrderData: RegisterReducer
    }
)s

export default CompileReducer;