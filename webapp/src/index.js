import React from 'react';
import ReactDOM from 'react-dom';
import { HashRouter, Route, Switch } from 'react-router-dom';
import { Provider } from 'react-redux';
import logger from 'redux-logger';
import thunk from 'redux-thunk';
import {
  createStore,
  applyMiddleware
} from 'redux';
import rootReducer from './reducers';
import App from './app/App'

// Styles
// Import Flag Icons Set
import 'flag-icon-css/css/flag-icon.min.css';
// Import Font Awesome Icons Set
import 'font-awesome/css/font-awesome.min.css';
// Import Simple Line Icons Set
import 'simple-line-icons/css/simple-line-icons.css';

import './index.css'

import 'react-table/react-table.css'

import "react-datepicker/dist/react-datepicker.css";

// Views
import { default as Login } from './app/pages/login/LoginContainner'

function saveToLocalStorage(state) {
  try {
    const serializedState = JSON.stringify(state);
    localStorage.setItem('state', serializedState);
  } catch (e) {
    console.log(e);
  }
}

function loadFromLocalStorage() {
  try {
    const serializedState = localStorage.getItem('state');
    if (serializedState === null)
      return undefined;
    return JSON.parse(serializedState);
  } catch (e) {
    console.log(e);
    return undefined
  }
}

const persistedState = loadFromLocalStorage();

const middleware = applyMiddleware(thunk, logger);
const store = createStore(rootReducer,persistedState, middleware);

store.subscribe(() => saveToLocalStorage(store.getState()));

ReactDOM.render(
  <Provider store={store}>
    <HashRouter>
      <Switch>
        <Route exact path="/login" name="Login Page" component={Login} />
        <Route path="/" name="Home" component={App} />
      </Switch>
    </HashRouter>
  </Provider>,
  document.getElementById('root'));
