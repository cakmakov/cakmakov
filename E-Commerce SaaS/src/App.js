import React, {Component} from 'react';
import Main from './screens/Main';
import './App.css';
import {BrowserRouter} from "react-router-dom";
import { Provider } from 'react-redux';
import { store } from './redux/configureStore';

export default class App extends Component {
    render() {
    return (
        <BrowserRouter>
            <div>
                <Provider store={store}>
                    <Main/>
                </Provider>
            </div>
        </BrowserRouter>
    );
  }
}
