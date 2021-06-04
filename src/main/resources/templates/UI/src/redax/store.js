let store = {
  _state: {},

  getState() {
    return this._state;
  },
  _callSubscriber() {
    console.log("state changed");
  },

  subscribe(observer) {
    this._callSubscriber = observer;
  },

  dispatch(action) {
    this._callSubscriber(this._state);
  },
};
export default store;
window.store = store;
