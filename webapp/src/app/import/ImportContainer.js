import { connect } from 'react-redux';
import ImportComponent from './ImportComponent';
import {resourceOperations} from '../resources/duck';
import {importOperations} from './duck'

const mapStateToProps = (state) => {
  return {
    listResource: state.resource.listResource,
    curUser : state.home.userInfo
  }
};

const mapDispatchToProps = dispatch => {

    const getListResource = (branch='null',type='null',status=1)=>dispatch(resourceOperations.getListResource(branch,type,status));
    const saveImport = listImport => dispatch(importOperations.saveImport(listImport));
    const saveResource = resource => dispatch(resourceOperations.saveResource(resource));
    
    return {
      getListResource,
      saveImport,
      saveResource
    }
  };

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(ImportComponent);