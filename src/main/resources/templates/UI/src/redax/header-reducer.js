const SET_LANGUAGE_DATA = "SET_LANGUAGE_DATA";

let initialState = {
  language: "rus",
};

const headerReducer = (state = initialState, action) => {
  switch (action.type) {
    case SET_USER_DATA:
      return {
        ...state,
        ...action.data,
        language: "EN",
      };

    default:
      return state;
  }
};
export const setLanguageData = (language) => {
  return {
    type: SET_LANGUAGE_DATA,
    data: { language },
  };
};

export default headerReducer;
