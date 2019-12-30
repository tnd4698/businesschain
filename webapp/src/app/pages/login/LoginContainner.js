import { connect } from 'react-redux';
import LoginComponent from './LoginComponent';


import {homeOperations} from '../../../app/home/duck'


const mapDispatchToProps = dispatch => {

    const login = credentials => dispatch(homeOperations.login(credentials));    
    return {
        login
    }
};

const mapStateToProps = state => {
    return {
        role : state.home.role
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(LoginComponent);