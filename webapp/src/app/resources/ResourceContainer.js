import { connect } from 'react-redux';
import ResourcesComponent from './ResourcesComponent';

import {branchOperations} from '../branches/duck'
import {resourceOperations} from './duck'

const mapStateToProps = state => {
    return {
        curUser : state.home.userInfo,
        curRole: state.home.role,
        listBranch: state.branch.listBranch,
        listResource: state.resource.listResource
    }
};

const mapDispatchToProps = dispatch => {
    const getListBranch = () => dispatch(branchOperations.getListBranch())
    const getListResource = (branch='null',type='null',status=1)=>dispatch(resourceOperations.getListResource(branch,type,status));
    const search = (searchContent,branch='null',role='null',status='1') => dispatch(resourceOperations.search(searchContent,branch,role,status));
    const updateResource = resource=>dispatch(resourceOperations.handleUpdateResource(resource))
    return {
        getListBranch,
        getListResource,
        search,
        updateResource
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(ResourcesComponent);