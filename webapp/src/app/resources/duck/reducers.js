import types from "./types";

const INITIAL_STATE = {
    listResource:[]
}

const resourceReducer = (state = INITIAL_STATE, action) => {
    switch (action.type) {
        case types.GETLISTRESOURCE:{
            return {
                ...state,
                listResource:action.value
            }
        }

        case types.SEARCH:{
            let listResource = action.value.listResource;            
            for (let i = 0; i < listResource.length; i++) {
                if (!String(listResource[i].resourceID).includes(action.value.searchContent)
                    && !String(listResource[i].name).includes(action.value.searchContent)
                    && !String(listResource[i].branchName).includes(action.value.searchContent)
                    && !String(listResource[i].count).includes(action.value.searchContent)
                    ) {
                        listResource.splice(i, 1);
                    i--;
                    continue;
                }
            }
            return {
                ...state,
                listResource: listResource
            }
        }

        default: return state;
    }
}


export default resourceReducer;