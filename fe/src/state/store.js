import userReducer from './reducer/user.reducer';
import actorReducer from './reducer/actor.reducer';
import hireReducer from './reducer/hire.reducer';
import profileReducer from './reducer/profile.reducer';
import producerReducer from './reducer/producer.reducer.js';
import fileReducer from './reducer/file.reducer.js';
import messageReducer from './reducer/message.reducer.js';

const { configureStore, getDefaultMiddleware } = require('@reduxjs/toolkit');
const { combineReducers } = require('redux');

const rootReducer = combineReducers({
    userReducer,
    actorReducer,
    hireReducer,
    profileReducer,
    producerReducer,
    fileReducer,
    messageReducer,
});
const store = configureStore({
    reducer: rootReducer,
    middleware: [...getDefaultMiddleware()],
});

export default store;
