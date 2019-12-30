import { connect } from 'react-redux';
import HomeComponent from './HomeComponent';


const mapStateToProps = (state) => {
  return {
    userInfo: state.home.userInfo
  }
};


export default connect(
  mapStateToProps,
  null
)(HomeComponent);