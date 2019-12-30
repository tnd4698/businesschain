import { connect } from 'react-redux';
import ShipwayComponent from './ShipwayComponent';
import { resourceOperations } from '../resources/duck';
import { branchOperations } from '../branches/duck'
import { shipwayOperations } from './duck';


const mapStateToProps = (state) => {
  return {
    listResource: state.resource.listResource,
    curUser: state.home.userInfo,
    listBranch: state.branch.listBranch
  }
};

const mapDispatchToProps = dispatch => {

  const getListBranch = (status = '1') => dispatch(branchOperations.getListBranch(status));
  const getListResource = (branch = 'null', type = 'null', status = 1) => dispatch(resourceOperations.getListResource(branch, type, status));
  const saveShipway = listShipway => dispatch(shipwayOperations.saveShipway(listShipway));

  return {
    getListBranch,
    getListResource,
    saveShipway
  }
};

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(ShipwayComponent);