import * as ActionTypes from './ActionTypes';

export const dishes = (state = {
    isLoading: true,
    errMsg: null,
    dishes: []
}, action) => {
    if (action.type === ActionTypes.ADD_DISHES) {
        return {...state, isLoading: false, errMsg: null, dishes: action.payload};
    } else {
        return state;
    }
};