import {post} from "./request";

export function login(data) {
    return post('/loginInformation/queryLoginInfo', data);
}
export function createAnAccount(params) {
    return post('/loginInformation/addingLoginInfo', params);
}

export function createANewTask(params) {
    return post('/taskForm/addingNewTask', params);
}

export function whatWeShowListForAllTask(params){
    return post('/taskForm/selectingSearchNewTask', params);

}



export function whatWeShowListForTodayTask(params){
    return post('/taskForm/selectingSearchOnlyTodayTask', params);

}

export function changeANewTask(params){
    return post('/taskForm/changeNewTask', params);

}

export function blurSearch(params){
    return post('/taskForm/blurSearch', params);

}