export function reducer(state, action) {
  switch (action.type) {

    case 'TOGGLE PRODUCT CODE':
      console.log('exsisting state: ' + JSON.stringify((state)));
      console.log('payload: ' + action.payload);
      return{
        showProductCode: action.payload
      }

    default:
      return state;
  }
}
