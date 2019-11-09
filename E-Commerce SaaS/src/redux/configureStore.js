import {createStore, combineReducers, applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
import logger from 'redux-logger';
import { dishes } from './dishes';
import * as ActionTypes from "./ActionTypes";
import {DISHES} from "../utils/dishes";

export const store = createStore(
        combineReducers({
            dishes
        }),
        applyMiddleware(thunk, logger)
    );

function addDishes() {
    return {
        type: ActionTypes.ADD_DISHES,
        payload: DISHES
    }
}

store.dispatch(addDishes());
