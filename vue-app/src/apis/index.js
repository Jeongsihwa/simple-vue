import axios from "axios";

const DOMAIN = () => `http://localhost:8080`;

// GET
const USER_LIST_URL = () => `${DOMAIN()}/findAll`;
export const getUserListRequest = async () => {
  const result = await axios
    .get(USER_LIST_URL())
    .then((response) => {
      const responseBody = response.data;
      return responseBody;
    })
    .catch((error) => {
      if (!error) return null;
      const responseBody = error.response.data;
      return responseBody;
    });
  return result;
};
// Post
const CREATE_USER_URL = () => `${DOMAIN()}/save`;
export const createUserRequest = async(requestBody) => {
  const result = await axios
    .post(CREATE_USER_URL(),requestBody)
    .then((response) => {
      const responseBody = response.data;
      return responseBody;
    })
    .catch((error) => {
      if(!error) return null;
      const responseBody = error.response.data;
      return responseBody;
    })
  return result;
}

const EDIT_USER_URL = () => `${DOMAIN()}/editById`;
export const editUserRequest = async (requestBody) => {
  const result = await axios
    .post(EDIT_USER_URL(), requestBody)
    .then((response) => {
      const responseBody = response.data;
      return responseBody;
    })
    .catch((error)=>{
      if(!error) return;
      const responseBody = error.response.data;
      return responseBody;
    });
    return result;
};
// Delete
const USER_DELETE_URL = () => `${DOMAIN()}/delete`;
export const deleteUserRequest = async (userId) => {
  const result = await axios
    .delete(USER_DELETE_URL(), { params: { id: userId } })
    .then((response) => {
      const responseBody = response.data;
      return responseBody;
    })
    .catch((error) => {
      if (!error) return null;
      console.log(error);
      const responseBody = error.response.data;
      return responseBody;
    });
  return result;
};
